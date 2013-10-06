[
    new MagicStatic(MagicLayer.Type) {
        @Override
        public int getTypeFlags(final MagicPermanent permanent,final int flags) {
            return flags & ~MagicType.Creature.getMask();
        }
        @Override
        public void modSubTypeFlags(final MagicPermanent permanent,final Set<MagicSubType> flags) {
            flags.remove(MagicSubType.God);
        }
        @Override
        public boolean condition(final MagicGame game,final MagicPermanent source,final MagicPermanent target) {
            return source.getController().getDevotion(MagicColor.Red) < 5;
        }
    },
    new MagicWhenOtherComesIntoPlayTrigger() {
        @Override
        public MagicEvent executeTrigger(final MagicGame game, final MagicPermanent permanent, final MagicPermanent otherPermanent) {
            return (otherPermanent != permanent &&
                    otherPermanent.isFriend(permanent) &&
                    otherPermanent.isCreature()) ?
                new MagicEvent(
                    permanent,
                    this,
                    "SN deals 2 damage to each opponent."
                ):
                MagicEvent.NONE;
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            game.doAction(new MagicDealDamageAction(
                new MagicDamage(
                    event.getSource(),
                    event.getPlayer().getOpponent(),
                    2
                )
            ));
        }
    },
    new MagicPermanentActivation(
        new MagicActivationHints(MagicTiming.Pump),
        "Pump"
    ) {

        @Override
        public Iterable<MagicEvent> getCostEvent(final MagicPermanent source) {
            return [new MagicPayManaCostEvent(source,"{2}{R}")];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                this,
                "Creatures PN controls get +1/+0 until end of turn."
            );
        }

        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            final Collection<MagicPermanent> targets = game.filterPermanents(
                event.getPlayer(),
                MagicTargetFilter.TARGET_CREATURE_YOU_CONTROL
            );
            for (final MagicPermanent creature : targets) {
                game.doAction(new MagicChangeTurnPTAction(creature,1,0));
            }
        }
    }
]
