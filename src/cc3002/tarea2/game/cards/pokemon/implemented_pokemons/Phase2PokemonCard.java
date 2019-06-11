package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.ElectricPhase2Pokemon;

public class Phase2PokemonCard extends ElectricPhase2Pokemon {

    public Phase2PokemonCard(Trainer trainer) {this(10, 102, new IAttack[] {}, trainer);}

    public Phase2PokemonCard(Trainer trainer, int id) {
        this(10, id, new IAttack[] {}, trainer);
    }

    public Phase2PokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "Phase2PokemonCard", attack, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 101;
    }
}
