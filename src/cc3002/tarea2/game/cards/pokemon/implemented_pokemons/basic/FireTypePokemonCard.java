package cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.FireBasePokemon;


/**
 * Fire Type pokemon class created for testing, represents a fire pokemon.
 *
 * @author Juan Urrutia
 */
public class FireTypePokemonCard extends FireBasePokemon {

    public FireTypePokemonCard(Trainer trainer) {this(10, 300, new IAttack[] {}, trainer);}

    public FireTypePokemonCard(int hp, IAbility[] abilities, Trainer trainer) {
        this(hp, 300, abilities, trainer);
    }

    public FireTypePokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "FirePhase2PokemonCard", abilities, trainer);
    }
}
