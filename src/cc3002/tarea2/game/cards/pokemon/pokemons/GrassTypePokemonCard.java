package cc3002.tarea2.game.cards.pokemon.pokemons;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.GrassType;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;

/**
 * Grass Type pokemon class created for testing, represents a grass pokemon.
 *
 * @author Juan Urrutia
 */
public class GrassTypePokemonCard extends GrassType {
    public GrassTypePokemonCard(Trainer trainer) {this(10, 4, new Attack[] {}, trainer, new BasicPhase());}

    public GrassTypePokemonCard(int hp, Attack[] attack, Trainer trainer) {
        this(hp, 4, attack, trainer, new BasicPhase());
    }

    public GrassTypePokemonCard(int hp, int id, Attack[] attack, Trainer trainer, IPhase phase) {
        super(hp, id, "GrassTypePokemonCard", attack, trainer, phase);
    }
}
