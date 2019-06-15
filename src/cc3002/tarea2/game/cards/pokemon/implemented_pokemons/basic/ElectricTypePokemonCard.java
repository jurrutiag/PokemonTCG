package cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.ElectricBasePokemon;

/**
 * Electric Type pokemon class created for testing, represents an electric pokemon.
 *
 * @author Juan Urrutia
 */
public class ElectricTypePokemonCard extends ElectricBasePokemon {

    public ElectricTypePokemonCard(Trainer trainer) {this(10, 100, new IAttack[] {}, trainer);}
    public ElectricTypePokemonCard(int hp, IAbility[] abilities, Trainer trainer) {
        this(hp, 100, abilities, trainer);
    }
    public ElectricTypePokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "ElectricTypePokemonCard", abilities, trainer);
    }

}
