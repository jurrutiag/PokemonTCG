package cc3002.tarea2.game.cards.pokemon;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.cards.PokemonCard;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;

/**
 * Class representing the fire type of Pokemons.
 *
 * @author Juan Urrutia
 */
public abstract class FireType extends PokemonCard {

    /**
     * Creates a fire type PokemonCard.
     * @param hp The initial hp of the PokemonCard.
     * @param attacks An array with the attacks of the PokemonCard.
     * @param trainer The trainer owner of the PokemonCard.
     */
    public FireType(int hp, int id, String name, Attack[] attacks, Trainer trainer, IPhase phase) {
        super(hp, id, name, attacks, trainer, phase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attack(Attack attack) {
        this.getTrainer().getOpponent().getActivePokemon().receiveFireAttack(attack);
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveGrassAttack(Attack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveFireAttack(Attack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveWaterAttack(Attack attack) {
        this.receiveWeaknessDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveElectricAttack(Attack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveFightingAttack(Attack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receivePsychicAttack(Attack attack) {
        this.receiveDamage(attack.getDamage());
    }
}
