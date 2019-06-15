package cc3002.tarea2.game.cards.trainer.support.implemented_support;

import cc3002.tarea2.game.cards.trainer.support.AbstractSupportCard;

public class ProfessorCozmoDiscovery extends AbstractSupportCard {
    @Override
    public void executeEffect() {
        double coin = Math.random();
        if (coin < 0.5) {
            this.getTrainer().drawBottomCards(3);
        } else {
            this.getTrainer().drawTopCards(2);
        }
    }

    @Override
    public String getDescription() {
        return "Throw a coin, if it lands heads, draw the 3 bottom cards of your deck, if it lands tails, draw the 2 first.";
    }

    @Override
    public String getName() {
        return "Professor Cozmo's Discovery";
    }
}
