package cc3002.tarea2.game.cards.pokemon.pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.cards.pokemon.FightingType;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;

/**
 * Fighting Type pokemon class created for testing, represents a fighting pokemon.
 *
 * @author Juan Urrutia
 */
public class FightingTypePokemonCard extends FightingType {

    public FightingTypePokemonCard(Trainer trainer) {this(10, 2, new Attack[] {}, trainer, new BasicPhase());}

    public FightingTypePokemonCard(int hp, Attack[] attack, Trainer trainer) {
        this(hp, 2, attack, trainer, new BasicPhase());
    }

    public FightingTypePokemonCard(int hp, int id, Attack[] attack, Trainer trainer, IPhase phase) {
        super(hp, id, "FightingTypePokemonCard", attack, trainer, phase);
    }
}
