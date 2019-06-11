package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.FireBasePokemon;


/**
 * Fire Type pokemon class created for testing, represents a fire pokemon.
 *
 * @author Juan Urrutia
 */
public class FireTypePokemonCard extends FireBasePokemon {

    public FireTypePokemonCard(Trainer trainer) {this(10, 3, new IAttack[] {}, trainer);}

    public FireTypePokemonCard(int hp, IAttack[] attack, Trainer trainer) {
        this(hp, 3, attack, trainer);
    }

    public FireTypePokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "FireTypePokemonCard", attack, trainer);
    }
}
