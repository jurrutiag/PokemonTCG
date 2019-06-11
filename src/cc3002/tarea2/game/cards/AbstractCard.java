package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Trainer;

public abstract class AbstractCard {
    /**
     * The trainer responsible for the AbstractPokemonCard.
     */
    protected Trainer trainer;

    public AbstractCard() {

    }

    public AbstractCard(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
