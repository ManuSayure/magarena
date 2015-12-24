package magic.data;

import java.util.EnumSet;
import java.util.Set;

public enum MagicIcon {

    // Future Sight symbols
    FS_CREATURE("creature_black.png"),
    FS_LAND("land_black.png"),
    FS_INSTANT("instant_black.png"),
    FS_ARTIFACT("artifact_black.png"),
    FS_ENCHANTMENT("enchantment_black.png"),
    FS_SORCERY("sorcery_black.png"),
    FS_PLANESWALKER("planeswalker_black.png"),

    ILLEGAL_ICON("card_illegal.png"),
    LEGAL_ICON("card_legal.png"),
    BANNED_ICON("card_banned.png"),
    RESTRICTED_ICON("card_restricted.png"),
    LOG_FILE("w_examine.png"),
    UPARROW_ICON("w_up.png"),
    DOWNARROW_ICON("w_down.png"),
    MENU_ICON("w_menu5@18.png"),
    OPTIONS_ICON("w_book.png"),
    OPTIONBAR_ICON("w_book24.png"),
    REFRESH_ICON("w_refresh.png"),
    MULLIGAN_ICON("w_mulligan.png"),
    HAND_ICON("w_hand.png"),
    TILED_ICON("w_tiled.png"),
    SAVE_ICON("w_save.png"),
    LOAD_ICON("w_load.png"),
    SWAP_ICON("w_swap.png"),
    DECK_ICON("w_deck.png"),
    NEXT_ICON("w_next.png"),
    BACK_ICON("w_back.png"),
    LIFE_ICON("w_life.png"),
    TARGET_ICON("w_target.png"),
    CUBE_ICON("w_cube.png"),
    LANDS_ICON("w_lands.png"),
    CREATURES_ICON("w_creatures.png"),
    SPELLS_ICON("w_spells.png"),
    EDIT_ICON("w_edit.png"),
    HELP_ICON("w_help.png"),
    OPEN_ICON("w_open.png"),
    RANDOM_ICON("w_random32.png"),
    CLEAR_ICON("w_clear28.png"),
    FILTER_ICON("w_filter24.png"),
    ARROWDOWN_ICON("w_arrowdown.png"),
    ARROWUP_ICON("w_arrowup.png"),
    PLUS_ICON("w_plus28.png"),
    MINUS_ICON("w_minus28.png"),
    MARKER_ICON("w_marker.png"),

    MISSING_ICON("missing2.png"),
    ANY("any.png"),
    FOLDER("folder.png"),
    LOG("log.png"),
    OK(LEGAL_ICON.iconFilename),
    CANCEL(BANNED_ICON.iconFilename),
    FORWARD("forward.png"),
    FORWARD2("forward2.png"),
    START("start.png"),
    STOP("stop.png"),
    UNDO("undo.png"),
    BUSY("busy.gif"),
    BUSY16("busy16.gif"),
    ALL("all.gif"),
    LEFT("left.gif"),
    RIGHT("right.gif"),
    CREATURE("creature.png"),
    ARTIFACT("artifact.png"),
    EQUIPMENT("equipment.gif"),
    ENCHANTMENT("enchantment.gif"),
    AURA("aura.png"),
    SPELL("spell.gif"),
    ABILITY("ability.png"),
    TRIGGER("trigger.png"),
    TOKEN("token.png"),
    LAND("land.gif"),
    LAND2("land2.gif"),
    LIFE("life.gif"),
    PREVENT("prevent.gif"),
    PREVENT2("prevent2.gif"),
    POISON("poison.png"),
    HAND("hand.gif"),
    HAND2("hand2.png"),
    HAND_ZONE("b_hand_zone.png"),
    LIBRARY2("library2.gif"),
    LIBRARY_ZONE("b_library_zone.png"),
    GRAVEYARD("graveyard.gif"),
    GRAVEYARD2("graveyard2.gif"),
    GRAVEYARD_ZONE("b_graveyard_zone.png"),
    EXILE("exile.png"),
    EXILE_ZONE("b_exile_zone.png"),
    DIFFICULTY("difficulty.png"),
    CANNOTTAP("cannottap.png"),
    SLEEP("sleep.gif"),
    REGENERATED("regenerated.gif"),
    DAMAGE("damage.gif"),
    COMBAT("combat.gif"),
    ATTACK("attack.gif"),
    BLOCK("block.gif"),
    BLOCKED("blocked.gif"),
    LOSE("lose.png"),
    TARGET("target.gif"),
    VALID("valid.gif"),

    // ability icons
    FLYING("flying.png"),
    TRAMPLE("trample.png"),
    STRIKE("strike.png"),
    DEATHTOUCH("deathtouch.png"),
    PROTBLACK("protblack.png"),
    PROTBLUE("protblue.png"),
    PROTGREEN("protgreen.png"),
    PROTRED("protred.png"),
    PROTWHITE("protwhite.png"),
    PROTALLCOLORS("protallcolors.png"),
    DEFENDER("defender.png"),
    VIGILANCE("vigilance.png"),
    DOUBLESTRIKE("doublestrike.png"),
    INFECT("infect.png"),
    WITHER("wither.png"),
    LIFELINK("lifelink.png"),
    REACH("reach.png"),
    SHROUD("shroud.png"),
    HEXPROOF("hexproof.png"),
    FEAR("fear.png"),
    INTIMIDATE("intimidate.png"),
    INDESTRUCTIBLE("indestructible.png"),

    // counters
    PLUS("plus.png"),
    MINUS("minus.png"),
    PLUSTWO("plusTwo.png"),
    MINUSTWO("minusTwo.png"),
    PLUSZEROPLUSONE("plusZeroPlusOne.png"),
    MINUSZEROMINUSONE("minusZeroMinusOne.png"),
    PLUSZEROPLUSTWO("plusZeroPlusTwo.png"),
    MINUSZEROMINUSTWO("minusZeroMinusTwo.png"),
    PLUSONEPLUSZERO("plusOnePlusZero.png"),
    MINUSONEMINUSZERO("minusOneMinusZero.png"),
    PLUSONEPLUSTWO("plusOnePlusTwo.png"),
    PLUSTWOPLUSZERO("plusTwoPlusZero.png"),
    MINUSTWOMINUSONE("minusTwoMinusOne.png"),
    CHARGE("charge.png"),
    FEATHER("feather.gif"),
    GOLDCOUNTER("goldcounter.png"),
    BRIBECOUNTER("bribecounter.png"),
    TIMECOUNTER("time-counter.png"),
    FADECOUNTER("fade-counter.png"),
    QUESTCOUNTER("quest-counter.png"),
    LEVELCOUNTER("level-counter.png"),
    HOOFPRINTCOUNTER("hoofprint-counter.png"),
    AGECOUNTER("age-counter.png"),
    ICECOUNTER("ice-counter.png"),
    SPORECOUNTER("spore-counter.png"),
    ARROWHEADCOUNTER("arrowhead-counter.png"),
    LOYALTYCOUNTER("loyalty-counter.png"),
    KICOUNTER("ki-counter.png"),
    DEPLETIONCOUNTER("depletion-counter.png"),
    MININGCOUNTER("mining-counter.png"),
    MUSTERCOUNTER("muster-counter.png"),
    TREASURECOUNTER("treasure-counter.png"),
    STRIFECOUNTER("strife-counter.png"),
    STUDYCOUNTER("study-counter.png"),
    TRAPCOUNTER("trap-counter.png"),
    SHIELDCOUNTER("shield-counter.png"),
    WISHCOUNTER("wish-counter.png"),
    SHELLCOUNTER("shell-counter.png"),
    BLAZECOUNTER("blaze-counter.png"),
    TIDECOUNTER("tide-counter.png"),
    GEMCOUNTER("gem-counter.png"),
    PRESSURECOUNTER("pressure-counter.png"),
    VERSECOUNTER("verse-counter.png"),
    MUSICCOUNTER("verse-counter.png"),
    RUSTCOUNTER("rust-counter.png"),
    BLOODCOUNTER("blood-counter.png"),
    GROWTHCOUNTER("spore-counter.png"),
    PLAGUECOUNTER("spore-counter.png"),
    PINCOUNTER("pin-counter.png"),
    HEALINGCOUNTER("healing-counter.png"),
    SCREAMCOUNTER("scream-counter.png"),
    DEVOTIONCOUNTER("devotion-counter.png"),
    DIVINITYCOUNTER("divinity-counter.png"),
    DEATHCOUNTER("death-counter.png"),
    WINDCOUNTER("wind-counter.png"),
    TOWERCOUNTER("tower-counter.png"),

    MANA_ANY("anymana.gif"),

    MANA_UNTAP("Q.png"),
    MANA_TAP("T.png"),
    MANA_WHITE("W.png"),
    MANA_BLUE("U.png"),
    MANA_BLACK("B.png"),
    MANA_RED("R.png"),
    MANA_GREEN("G.png"),
    MANA_SNOW("S.png"),
    MANA_COLORLESS("C.png"),
    MANA_HYBRID_WHITE("2W.png"),
    MANA_HYBRID_BLUE("2U.png"),
    MANA_HYBRID_BLACK("2B.png"),
    MANA_HYBRID_RED("2R.png"),
    MANA_HYBRID_GREEN("2G.png"),
    MANA_PHYREXIAN_WHITE("WP.png"),
    MANA_PHYREXIAN_BLUE("UP.png"),
    MANA_PHYREXIAN_BLACK("BP.png"),
    MANA_PHYREXIAN_RED("RP.png"),
    MANA_PHYREXIAN_GREEN("GP.png"),
    MANA_WHITE_BLUE("WU.png"),
    MANA_WHITE_BLACK("WB.png"),
    MANA_BLUE_BLACK("UB.png"),
    MANA_BLUE_RED("UR.png"),
    MANA_BLACK_RED("BR.png"),
    MANA_BLACK_GREEN("BG.png"),
    MANA_RED_WHITE("RW.png"),
    MANA_RED_GREEN("RG.png"),
    MANA_GREEN_WHITE("GW.png"),
    MANA_GREEN_BLUE("GU.png"),
    MANA_0("0.png"),
    MANA_1("1.png"),
    MANA_2("2.png"),
    MANA_3("3.png"),
    MANA_4("4.png"),
    MANA_5("5.png"),
    MANA_6("6.png"),
    MANA_7("7.png"),
    MANA_8("8.png"),
    MANA_9("9.png"),
    MANA_10("10.png"),
    MANA_11("11.png"),
    MANA_12("12.png"),
    MANA_13("13.png"),
    MANA_14("14.png"),
    MANA_15("15.png"),
    MANA_16("16.png"),
    MANA_17("17.png"),
    MANA_18("18.png"),
    MANA_19("19.png"),
    MANA_20("20.png"),
    MANA_X("X.png");

    public static final Set<MagicIcon> COLOR_MANA = EnumSet.range(MANA_WHITE, MANA_GREEN);
    public static final Set<MagicIcon> HYBRID_COLOR_MANA = EnumSet.range(MANA_WHITE_BLUE, MANA_GREEN_BLUE);
    public static final Set<MagicIcon> COST_ICON = EnumSet.range(MANA_UNTAP,MANA_X);

    private final String iconFilename;

    MagicIcon(String iconFilename) {
        this.iconFilename = iconFilename;
    }

    public String getFilename() {
        if (iconFilename != null) {
            return iconFilename;
        } else {
            throw new UnsupportedOperationException("Mana icons do not have an associated filename.");
        }
    }

    public boolean isManaIcon() {
        return COST_ICON.contains(this);
    }

}
