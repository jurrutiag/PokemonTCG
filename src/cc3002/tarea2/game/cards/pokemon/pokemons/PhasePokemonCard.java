package cc3002.tarea2.game.cards.pokemon.pokemons;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.ElectricType;
import cc3002.tarea2.game.cards.pokemon.phases.EvolvedPhase;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;

public class PhasePokemonCard extends ElectricType {
    public PhasePokemonCard(Trainer trainer) {this(10, 2, new Attack[] {}, trainer, new EvolvedPhase(1));}

    public PhasePokemonCard(Trainer trainer, IPhase phase, int id) {
        this(10, id, new Attack[] {}, trainer, phase);
    }

    public PhasePokemonCard(int hp, int id, Attack[] attack, Trainer trainer, IPhase phase) {
        super(hp, id, "PhasePokemonCard", attack, trainer, phase);
    }

}
