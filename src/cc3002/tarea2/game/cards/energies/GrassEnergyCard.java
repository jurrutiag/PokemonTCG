package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Class representing a grass energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class GrassEnergyCard extends AbstractEnergyCard {



    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "GrassEnergyCard";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitGrassEnergyCard(this);
    }
}
