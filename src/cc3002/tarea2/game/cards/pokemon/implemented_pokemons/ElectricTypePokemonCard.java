package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.ElectricBasePokemon;

/**
 * Electric Type pokemon class created for testing, represents an electric pokemon.
 *
 * @author Juan Urrutia
 */
public class ElectricTypePokemonCard extends ElectricBasePokemon {

    public ElectricTypePokemonCard(Trainer trainer) {this(10, 1, new IAttack[] {}, trainer);}
    public ElectricTypePokemonCard(int hp, IAttack[] attack, Trainer trainer) {
        this(hp, 1, attack, trainer);
    }
    public ElectricTypePokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "ElectricTypePokemonCard", attack, trainer);
    }

}
