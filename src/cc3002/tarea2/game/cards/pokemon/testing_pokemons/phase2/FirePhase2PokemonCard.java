package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.FirePhase2Pokemon;


/**
 * Class that represents a phase 2 fire pokemon.
 *
 * @author Juan Urrutia
 */
public class FirePhase2PokemonCard extends FirePhase2Pokemon {

    public FirePhase2PokemonCard(Trainer trainer) {this(10, 302, new IAttack[] {}, trainer);}
    
    public FirePhase2PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "FirePhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 301;
    }
}
