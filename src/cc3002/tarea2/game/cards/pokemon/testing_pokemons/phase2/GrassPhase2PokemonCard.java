package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.GrassPhase2Pokemon;

/**
 * Class that represents a phase 2 grass pokemon.
 *
 * @author Juan Urrutia
 */
public class GrassPhase2PokemonCard extends GrassPhase2Pokemon {
    public GrassPhase2PokemonCard(Trainer trainer) {this(10, 402, new IAttack[] {}, trainer);}

    public GrassPhase2PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "GrassPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 401;
    }
}
