package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.Visitor;

/**
 * Represents an energy card, required for the Pokemons to cast abilities.
 *
 * @author Juan Urrutia
 */
public abstract class EnergyCard implements IEnergyCard {


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActivelySelectable() {
        return false;
    }

    /**
     * Makes the player play this energy card.
     * @param trainer The trainer that plays the card.
     */
    public abstract boolean bePlayedBy(Trainer trainer);

    /**
     * {@inheritDoc}
     */
    public abstract String getName();

    @Override
    public String toString() {
        return "EnergyCard: " + this.getName();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEnergyCard(this);
    }
}
