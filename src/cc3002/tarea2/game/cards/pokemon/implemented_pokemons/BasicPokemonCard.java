package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.ElectricBasePokemon;

public class BasicPokemonCard extends ElectricBasePokemon {

    public BasicPokemonCard(Trainer trainer) {this(10, 100, new IAttack[] {}, trainer);}
    public BasicPokemonCard(int hp, IAttack[] attack, Trainer trainer) {
        this(hp, 0, attack, trainer);
    }
    public BasicPokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "BasicPokemonCard", attack, trainer);
    }
}
