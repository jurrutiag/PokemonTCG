package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.WaterPhase2Pokemon;


/**
 * Class that represents a phase 2 water pokemon.
 *
 * @author Juan Urrutia
 */
public class WaterPhase2PokemonCard extends WaterPhase2Pokemon {

    public WaterPhase2PokemonCard(Trainer trainer) {this(10, 602, new IAttack[] {}, trainer);}

    public WaterPhase2PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "WaterPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 601;
    }
}
