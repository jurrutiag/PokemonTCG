package cc3002.tarea2.game;

import cc3002.tarea2.game.visitor.Visitable;

/**
 * Card interface gives common methods to cards.
 *
 * @author Juan Urrutia
 */
public interface Card extends Visitable {
    /**
     * Checks if the card can be used as an active pokemon, in this case,
     * the card is an EnergyCard so the answer is always no.
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
     * Plays the card selected.
     * @param trainer The trainer that plays the card.
     * @return Returns true if the card was played successfully
     */
    public boolean bePlayedBy(Trainer trainer);

    @Override
    public String toString();
}