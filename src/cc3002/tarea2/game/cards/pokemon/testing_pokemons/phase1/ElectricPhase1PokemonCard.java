package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase1.ElectricPhase1Pokemon;

/**
 * Class that represents a phase 1 electric pokemon.
 *
 * @author Juan Urrutia
 */
public class ElectricPhase1PokemonCard extends ElectricPhase1Pokemon {
    public ElectricPhase1PokemonCard(Trainer trainer) {this(10, 101, new IAttack[] {}, trainer);}


    public ElectricPhase1PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "ElectricPhase1PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 100;
    }
}
