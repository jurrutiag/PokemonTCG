package cc3002.tarea2.game.cards.pokemon.implemented_pokemons.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.FightingPhase2Pokemon;

/**
 * Fighting Type pokemon class created for testing, represents a fighting pokemon.
 *
 * @author Juan Urrutia
 */
public class FightingPhase2PokemonCard extends FightingPhase2Pokemon {

    public FightingPhase2PokemonCard(Trainer trainer) {this(10, 202, new IAttack[] {}, trainer);}

    public FightingPhase2PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "FightingPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 201;
    }
}
