package cc3002.tarea2.game.cards.pokemon.pokemons;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.ElectricType;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;

/**
 * Electric Type pokemon class created for testing, represents an electric pokemon.
 *
 * @author Juan Urrutia
 */
public class ElectricTypePokemonCard extends ElectricType {

    public ElectricTypePokemonCard(Trainer trainer) {this(10, 1, new Attack[] {}, trainer, new BasicPhase());}
    public ElectricTypePokemonCard(int hp, Attack[] attack, Trainer trainer) {
        this(hp, 1, attack, trainer, new BasicPhase());
    }
    public ElectricTypePokemonCard(int hp, int id, Attack[] attack, Trainer trainer, IPhase phase) {
        super(hp, id, "ElectricTypePokemonCard", attack, trainer, phase);
    }

}
