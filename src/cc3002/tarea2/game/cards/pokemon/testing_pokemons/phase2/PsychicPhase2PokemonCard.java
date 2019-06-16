package cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.PsychicPhase2Pokemon;

/**
 * Class that represents a phase 2 psychic pokemon.
 *
 * @author Juan Urrutia
 */
public class PsychicPhase2PokemonCard extends PsychicPhase2Pokemon {
    public PsychicPhase2PokemonCard(Trainer trainer) {this(10, 502, new IAttack[] {}, trainer);}


    public PsychicPhase2PokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "PsychicPhase2PokemonCard", abilities, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 501;
    }
}
