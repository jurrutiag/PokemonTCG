package cc3002.tarea2.game.cards.pokemon.implemented_pokemons.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase1.WaterPhase1Pokemon;


/**
 * Water Type pokemon class created for testing, represents a water pokemon.
 *
 * @author Juan Urrutia
 */
public class WaterPhase1PokemonCard extends WaterPhase1Pokemon {

    public WaterPhase1PokemonCard(Trainer trainer) {this(10, 601, new IAttack[] {}, trainer);}

    public WaterPhase1PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "WaterPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 600;
    }
}
