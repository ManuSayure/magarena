package magic;

import magic.utility.ProgressReporter;
import magic.ui.SplashProgressReporter;
import magic.utility.MagicSystem;
import java.awt.SplashScreen;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import magic.data.CardDefinitions;
import magic.data.CubeDefinitions;
import magic.data.DeckGenerators;
import magic.data.DeckUtils;
import magic.data.DuelConfig;
import magic.data.GeneralConfig;
import magic.data.KeywordDefinitions;
import magic.data.UnimplementedParser;
import magic.model.MagicGameLog;
import magic.test.TestGameBuilder;
import magic.ui.ScreenController;
import magic.utility.MagicFileSystem;
import magic.utility.MagicFileSystem.DataPath;

public class MagicMain {

    private static SplashScreen splash;
    private static ProgressReporter reporter = new ProgressReporter();

    public static void main(final String[] args) {

        // setup the handler for any uncaught exception
        Thread.setDefaultUncaughtExceptionHandler(new magic.model.MagicGameReport());

        setSplashScreen();
       
        System.out.println(MagicSystem.getRuntimeParameters());
        parseCommandline(args);

        // setup the game log
        reporter.setMessage("Initializing log...");
        MagicGameLog.initialize();

        // show the data folder being used
        System.out.println("Data folder : "+ MagicFileSystem.getDataPath());

        // try to set the look and feel
        try {
            for (final LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            // customize nimbus look
            UIManager.getLookAndFeelDefaults().put("Table.showGrid", true);
            // removes hardcoded border
            UIManager.getLookAndFeelDefaults().put("ScrollPane[Enabled].borderPainter", null);
        }
        catch (Exception e) {
            System.err.println("Unable to set look and feel. Probably missing the latest version of Java 6.");
            e.printStackTrace();
        }

        final long start_time = System.currentTimeMillis();
        reporter.setMessage("Initializing game engine...");

        // must load config here otherwise annotated card image theme-specifc
        // icons are not loaded before the AbilityIcon class is initialized
        // and you end up with the default icons instead.
        GeneralConfig.getInstance().load();

        initialize();
        if (MagicSystem.showStartupStats()) {
            final double duration = (double)(System.currentTimeMillis() - start_time) / 1000;
            System.err.println("Initalization of engine took " + duration + "s");
        }

        reporter.setMessage("Starting UI...");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startUI();
            }
        });
    }

    /**
     * Sets splash screen as defined in JAR manifest or via "-splash" command line.
     * <p>
     * Can override with custom splash by placing "splash.png" in mods folder.
     */
    private static void setSplashScreen() {
        splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.err.println("Error: no splash image specified on the command line");
        } else {
            reporter = new SplashProgressReporter(splash);
            try {
                final File splashFile = MagicFileSystem.getDataPath(DataPath.MODS).resolve("splash.png").toFile();
                if (splashFile.exists()) {
                    splash.setImageURL(splashFile.toURI().toURL());
                }
            } catch (IOException ex) {
                // A problem occurred trying to set custom splash.
                // Log error and use default splash screen.
                System.err.println(ex);
            }
        }
    }

    private static void startUI() {
        ScreenController.showMainMenuScreen();
        // Add "-DtestGame=X" VM argument to start a TestGameBuilder game
        // where X is one of the classes (without the .java) in "magic.test".
        final String testGame = System.getProperty("testGame");
        if (testGame != null) {
            ScreenController.showDuelGameScreen(TestGameBuilder.buildGame(testGame));
        }
        if (MagicSystem.isAiVersusAi()) {
            final DuelConfig config = DuelConfig.getInstance();
            config.load();
            ScreenController.getMainFrame().newDuel(config);
        }
    }

    private static void parseCommandline(final String[] args) {
        for (String arg : args) {
            switch (arg.toLowerCase()) {
            case "disablelogviewer":
                GeneralConfig.getInstance().setLogViewerDisabled(true);
                break;
            }
        }
    }

    static void initializeEngine() {
        if (Boolean.getBoolean("parseMissing")) {
            UnimplementedParser.parseScriptsMissing(reporter);
            reporter.setMessage("Parsing card abilities...");
            UnimplementedParser.parseCardAbilities();
        }
        CardDefinitions.loadCardDefinitions(reporter);
        if (Boolean.getBoolean("debug")) {
            reporter.setMessage("Loading card abilities...");
            CardDefinitions.loadCardAbilities();
        }
        reporter.setMessage("Loading cube definitions...");
        CubeDefinitions.loadCubeDefinitions();
        reporter.setMessage("Loading keyword definitions...");
        KeywordDefinitions.getInstance().loadKeywordDefinitions();
        reporter.setMessage("Loading deck generators...");
        DeckGenerators.getInstance().loadDeckGenerators();
    }

    private static void initialize() {
        final File gamePathFile = MagicFileSystem.getDataPath().toFile();
        if (!gamePathFile.exists() && !gamePathFile.mkdir()) {
            System.err.println("Unable to create directory " + gamePathFile.toString());
        }

        final File modsPathFile = MagicFileSystem.getDataPath(DataPath.MODS).toFile();
        if (!modsPathFile.exists() && !modsPathFile.mkdir()) {
            System.err.println("Unable to create directory " + modsPathFile.toString());
        }

        DeckUtils.createDeckFolder();
        initializeEngine();
    }

}
