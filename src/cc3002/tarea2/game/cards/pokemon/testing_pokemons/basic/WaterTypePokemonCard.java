package cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.WaterBasePokemon;


/**
 * Water Type pokemon class created for testing, represents a water pokemon.
 *
 * @author Juan Urrutia
 */
public class WaterTypePokemonCard extends WaterBasePokemon {

    public WaterTypePokemonCard(Trainer trainer) {this(10, 600, new IAttack[] {}, trainer);}

    public WaterTypePokemonCard(int hp, IAbility[] abilities, Trainer trainer) {
        this(hp, 600, abilities, trainer);
    }

    public WaterTypePokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "WaterBasePokemonCard", abilities, trainer);
    }
}
