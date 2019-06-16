package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase1.FirePhase1Pokemon;


/**
 * Class that represents a phase 1 fire pokemon.
 *
 * @author Juan Urrutia
 */
public class FirePhase1PokemonCard extends FirePhase1Pokemon {

    public FirePhase1PokemonCard(Trainer trainer) {this(10, 301, new IAttack[] {}, trainer);}

    public FirePhase1PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "FirePhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 300;
    }
}
