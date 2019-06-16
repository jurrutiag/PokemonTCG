package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.ElectricPhase2Pokemon;

/**
 * Class that represents a phase 2 electric pokemon.
 *
 * @author Juan Urrutia
 */
public class ElectricPhase2PokemonCard extends ElectricPhase2Pokemon {

    public ElectricPhase2PokemonCard(Trainer trainer) {this(10, 102, new IAttack[] {}, trainer);}

    public ElectricPhase2PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "ElectricPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 101;
    }
}
