[
    new MagicETBEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack,final MagicPayedCost payedCost) {
            return new MagicEvent(
                cardOnStack,
                new MagicMayChoice(
                    new MagicTargetChoice("a nonland permanent")
                ),
                MagicCopyPermanentPicker.create(),
                this,
                "PN may\$ have SN enter the battlefield as a copy of any nonland permanent on the battlefield.\$"
            );
        }

        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            if (event.isYes()) {
                game.doAction(new EnterAsCopyAction(event.getCardOnStack(), event.getTarget()))
            } else {
                game.logAppendMessage(event.getPlayer(), "Put ${event.getCardOnStack()} onto the battlefield.");
                game.doAction(new PlayCardFromStackAction(
                    event.getCardOnStack()
                ));
            }
        }
    }
]
