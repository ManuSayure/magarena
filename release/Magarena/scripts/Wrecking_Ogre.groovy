[
    new MagicBloodrushActivation(
        MagicManaCost.THREE_RED_RED,
        "Target attacking creature\$ gets +3/+3 and gains double strike until end of turn.") {
        @Override
        public void executeEvent(final MagicGame game,final MagicEvent event,final Object[] choiceResults) {
            event.processTargetPermanent(game,choiceResults,0,new MagicPermanentAction() {
                public void doAction(final MagicPermanent creature) {
                    game.doAction(new MagicChangeTurnPTAction(creature,3,3));
                    game.doAction(new MagicSetAbilityAction(creature,MagicAbility.DoubleStrike));
                }
            });
        }
    }
]
