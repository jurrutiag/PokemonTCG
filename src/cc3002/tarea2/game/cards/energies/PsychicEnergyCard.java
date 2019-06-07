package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.EnergyCard;

/**
 * Class representing a psychic energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class PsychicEnergyCard extends EnergyCard {

    @Override
    public boolean bePlayedBy(Trainer trainer) {
        trainer.getSelectedPokemon().addPsychicEnergy();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "PsychicEnergyCard";
    }
}
