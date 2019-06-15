package cc3002.tarea2.game.cards.trainer.object.implemented_objects;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.object.AbstractNonInstantObject;

public class ExpShareObject extends AbstractNonInstantObject {

    @Override
    public String getName() {
        return "Exp. Share";
    }

    @Override
    public String getDescription() {
        return "Gives the possibility to move an energy from the active pokemon to the pokemon that holds this card in case the active pokemon dies.";
    }

    @Override
    public void executeEffect() {
        IPokemonCard activePokemon = this.getTrainer().getActivePokemon();
        if (activePokemon.getEnergySet().getElectricEnergies() > 0) {
            this.getPokemon().addElectricEnergy();
        }
    }
}
