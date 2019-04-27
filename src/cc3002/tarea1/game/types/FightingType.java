package cc3002.tarea1.game.types;

import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.Pokemon;

/**
 * Class representing the fighting type of Pokemons.
 *
 * @author Juan Urrutia
 */
public class FightingType extends Pokemon {

    /**
     * Creates a fighting type Pokemon.
     * @param hp The initial hp of the Pokemon.
     * @param attacks An array with the attacks of the Pokemon.
     * @param trainer The trainer owner of the Pokemon.
     */
    public FightingType(int hp, int id, String name, Attack[] attacks, Trainer trainer) {
        super(hp, id, name, attacks, trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attack(int attackNum, Trainer opponent) {
        if (!this.checkEnergies(attackNum))
            return;
        opponent.getActivePokemon().receiveFightingAttack(this.getAttackDamage(attackNum));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveGrassAttack(int attackDamage) {
        this.receiveWeaknessDamage(attackDamage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveFireAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveWaterAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveElectricAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveFightingAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receivePsychicAttack(int attackDamage) {
        this.receiveWeaknessDamage(attackDamage);
    }

}