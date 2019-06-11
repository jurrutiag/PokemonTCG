package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.ICardVisitor;

/**
 * Class representing an electric energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class ElectricEnergyCard extends AbstractEnergyCard {

    public ElectricEnergyCard(Trainer trainer) {
        super(trainer);
    }

    public ElectricEnergyCard() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "ElectricEnergyCard";
    }

    @Override
    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitElectricEnergyCard(this);
    }

}
