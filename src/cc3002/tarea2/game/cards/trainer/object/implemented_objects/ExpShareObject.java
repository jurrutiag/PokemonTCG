package cc3002.tarea2.game.cards.trainer.object.implemented_objects;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.object.AbstractNonInstantObject;

/**
 * Exp Share object. Non instant object that gets executed when the active pokemon of a trainer dies
 * Only electric energies are added to the pokemon that holds this card.
 *
 * @author Juan Urrutia
 */
public class ExpShareObject extends AbstractNonInstantObject {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Exp. Share";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Gives the possibility to move an energy from the active pokemon to the pokemon that holds this card in case the active pokemon dies.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect() {
        IPokemonCard activePokemon = this.getTrainer().getActivePokemon();
        if (activePokemon.getEnergySet().getElectricEnergies() > 0) {
            this.getPokemon().addElectricEnergy();
        }
    }
}
