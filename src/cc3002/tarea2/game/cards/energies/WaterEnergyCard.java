package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.visitor.ICardVisitor;

/**
 * Class representing a water energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class WaterEnergyCard extends AbstractEnergyCard {


    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "WaterEnergyCard";
    }

    @Override
    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitWaterEnergyCard(this);
    }
}
