package cc3002.tarea2.game.cards.pokemon.pokemons;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.PsychicType;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;

/**
 * Psychic Type pokemon class created for testing, represents a psychic pokemon.
 *
 * @author Juan Urrutia
 */
public class PsychicTypePokemonCard extends PsychicType {
    public PsychicTypePokemonCard(Trainer trainer) {this(10, 5, new Attack[] {}, trainer, new BasicPhase());}

    public PsychicTypePokemonCard(int hp, Attack[] attack, Trainer trainer) {
        this(hp, 5, attack, trainer, new BasicPhase());
    }

    public PsychicTypePokemonCard(int hp, int id, Attack[] attack, Trainer trainer, IPhase phase) {
        super(hp, id, "PsychicTypePokemonCard", attack, trainer, phase);
    }
}
