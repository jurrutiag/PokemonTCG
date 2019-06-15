package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Trainer;

public abstract class AbstractCard implements ICard {
    /**
     * The trainer responsible for the AbstractPokemonCard.
     */
    private Trainer trainer;

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Trainer getTrainer() {
        return trainer;
    }

    @Override
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public void getDiscarded(Trainer trainer) {
        trainer.getDiscardPile().add(this);
    }
}
