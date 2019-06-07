package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.EnergyCard;

/**
 * Class representing an electric energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class ElectricEnergyCard extends EnergyCard {

    @Override
    public boolean bePlayedBy(Trainer trainer) {
        trainer.getSelectedPokemon().addElectricEnergy();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "ElectricEnergyCard";
    }


}
