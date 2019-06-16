package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.card.ICardVisitable;

/**
 * ICard interface gives common methods to cards.
 *
 * @author Juan Urrutia
 */
public interface ICard extends ICardVisitable {
    /**
     * Checks if the card can be used as an active pokemon, in this case,
     * the card is an AbstractEnergyCard so the answer is always no.
     *
     * @return Boolean value that represents if the card is selectable as active pokemon.
     */
    public boolean isActivelySelectable();

    /**
     *
     * @return Returns the name of the card.
     */
    public String getName();

    /**
     * Sets the trainer that plays the card.
     * @param trainer the trainer to set.
     */
    public void setTrainer(Trainer trainer);

    /**
     *
     * @return Returns the trainer that plays the card.
     */
    public Trainer getTrainer();

    //TODO: revisar esto
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString();

    /**
     * Gets this card discarded by a trainer.
     * @param trainer the trainer that discards the card.
     */
    public void getDiscarded(Trainer trainer);
}