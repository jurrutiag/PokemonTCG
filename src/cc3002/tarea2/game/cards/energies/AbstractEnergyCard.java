package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.AbstractCard;
import cc3002.tarea2.game.visitor.ICardVisitor;

/**
 * Represents an energy card, required for the Pokemons to cast abilities.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractEnergyCard extends AbstractCard implements IEnergyCard {

    public AbstractEnergyCard(Trainer trainer) {
        super(trainer);
    }

    public AbstractEnergyCard() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActivelySelectable() {
        return false;
    }


    /**
     * {@inheritDoc}
     */
    public abstract String getName();

    @Override
    public String toString() {
        return "AbstractEnergyCard: " + this.getName();
    }

    @Override
    public void accept(ICardVisitor visitor) {
        visitor.visitEnergyCard(this);
    }
}
