package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.cards.AbstractCard;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Represents an energy card, required for the Pokemons to cast abilities.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractEnergyCard extends AbstractCard implements IEnergyCard {


    /**
     * {@inheritDoc}
     */
    public abstract String getName();

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitEnergyCard(this);
    }
}
