package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.PsychicBasePokemon;

/**
 * Psychic Type pokemon class created for testing, represents a psychic pokemon.
 *
 * @author Juan Urrutia
 */
public class PsychicTypePokemonCard extends PsychicBasePokemon {
    public PsychicTypePokemonCard(Trainer trainer) {this(10, 5, new IAttack[] {}, trainer);}

    public PsychicTypePokemonCard(int hp, IAttack[] attack, Trainer trainer) {
        this(hp, 5, attack, trainer);
    }

    public PsychicTypePokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "PsychicTypePokemonCard", attack, trainer);
    }
}
