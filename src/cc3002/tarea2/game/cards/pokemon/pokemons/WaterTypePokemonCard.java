package cc3002.tarea2.game.cards.pokemon.pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.cards.pokemon.WaterType;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;


/**
 * Water Type pokemon class created for testing, represents a water pokemon.
 *
 * @author Juan Urrutia
 */
public class WaterTypePokemonCard extends WaterType {

    public WaterTypePokemonCard(Trainer trainer) {this(10, 6, new Attack[] {}, trainer, new BasicPhase());}

    public WaterTypePokemonCard(int hp, Attack[] attack, Trainer trainer) {
        this(hp, 6, attack, trainer, new BasicPhase());
    }

    public WaterTypePokemonCard(int hp, int id, Attack[] attack, Trainer trainer, IPhase phase) {
        super(hp, id, "WaterTypePokemonCard", attack, trainer, phase);
    }
}
