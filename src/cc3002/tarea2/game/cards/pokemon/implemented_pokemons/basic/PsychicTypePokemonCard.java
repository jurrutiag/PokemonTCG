package cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.PsychicBasePokemon;

/**
 * Psychic Type pokemon class created for testing, represents a psychic pokemon.
 *
 * @author Juan Urrutia
 */
public class PsychicTypePokemonCard extends PsychicBasePokemon {
    public PsychicTypePokemonCard(Trainer trainer) {this(10, 500, new IAttack[] {}, trainer);}

    public PsychicTypePokemonCard(int hp, IAbility[] abilities, Trainer trainer) {
        this(hp, 500, abilities, trainer);
    }

    public PsychicTypePokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "PsychicPhase2PokemonCard", abilities, trainer);
    }
}
