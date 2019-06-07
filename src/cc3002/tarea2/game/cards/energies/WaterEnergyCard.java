package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.EnergyCard;

/**
 * Class representing a water energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class WaterEnergyCard extends EnergyCard {

    @Override
    public boolean bePlayedBy(Trainer trainer) {
        trainer.getSelectedPokemon().addWaterEnergy();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "WaterEnergyCard";
    }
}
