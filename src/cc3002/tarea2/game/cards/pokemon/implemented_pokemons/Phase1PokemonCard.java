package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase1.ElectricPhase1Pokemon;

public class Phase1PokemonCard extends ElectricPhase1Pokemon {
    public Phase1PokemonCard(Trainer trainer) {this(10, 101, new IAttack[] {}, trainer);}

    public Phase1PokemonCard(Trainer trainer, int id) {
        this(10, id, new IAttack[] {}, trainer);
    }

    public Phase1PokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "Phase1PokemonCard", attack, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 100;
    }
}
