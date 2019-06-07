package cc3002.tarea2.game.cards.pokemon.pokemons;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.FireType;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;


/**
 * Fire Type pokemon class created for testing, represents a fire pokemon.
 *
 * @author Juan Urrutia
 */
public class FireTypePokemonCard extends FireType {

    public FireTypePokemonCard(Trainer trainer) {this(10, 3, new Attack[] {}, trainer, new BasicPhase());}

    public FireTypePokemonCard(int hp, Attack[] attack, Trainer trainer) {
        this(hp, 3, attack, trainer, new BasicPhase());
    }

    public FireTypePokemonCard(int hp, int id, Attack[] attack, Trainer trainer, IPhase phase) {
        super(hp, id, "FireTypePokemonCard", attack, trainer, phase);
    }
}
