package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase1.GrassPhase1Pokemon;

/**
 * Class that represents a phase 1 grass pokemon.
 *
 * @author Juan Urrutia
 */
public class GrassPhase1PokemonCard extends GrassPhase1Pokemon {
    public GrassPhase1PokemonCard(Trainer trainer) {this(10, 401, new IAttack[] {}, trainer);}

    public GrassPhase1PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "GrassPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 400;
    }
}
