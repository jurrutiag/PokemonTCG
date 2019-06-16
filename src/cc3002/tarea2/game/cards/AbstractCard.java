package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Trainer;

/**
 * Class that represents an AbstractCard.
 *
 * @author Juan Urrutia
 */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getDiscarded(Trainer trainer) {
        trainer.getDiscardPile().add(this);
    }
}
