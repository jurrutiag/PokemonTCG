package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase1.PsychicPhase1Pokemon;

/**
 * Class that represents a phase 1 psychic pokemon.
 *
 * @author Juan Urrutia
 */
public class PsychicPhase1PokemonCard extends PsychicPhase1Pokemon {
    public PsychicPhase1PokemonCard(Trainer trainer) {this(10, 501, new IAttack[] {}, trainer);}


    public PsychicPhase1PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "PsychicPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 500;
    }
}
