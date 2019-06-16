package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase1.FightingPhase1Pokemon;

/**
 * Class that represents a phase 1 fighting pokemon.
 *
 * @author Juan Urrutia
 */
public class FightingPhase1PokemonCard extends FightingPhase1Pokemon {

    public FightingPhase1PokemonCard(Trainer trainer) {this(10, 201, new IAttack[] {}, trainer);}

    public FightingPhase1PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "FightingPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 200;
    }
}
