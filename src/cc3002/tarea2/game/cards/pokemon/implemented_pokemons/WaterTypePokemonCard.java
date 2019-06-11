package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.WaterBasePokemon;


/**
 * Water Type pokemon class created for testing, represents a water pokemon.
 *
 * @author Juan Urrutia
 */
public class WaterTypePokemonCard extends WaterBasePokemon {

    public WaterTypePokemonCard(Trainer trainer) {this(10, 6, new IAttack[] {}, trainer);}

    public WaterTypePokemonCard(int hp, IAttack[] attack, Trainer trainer) {
        this(hp, 6, attack, trainer);
    }

    public WaterTypePokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "WaterTypePokemonCard", attack, trainer);
    }
}
