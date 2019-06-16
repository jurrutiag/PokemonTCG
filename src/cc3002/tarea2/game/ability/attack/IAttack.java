package cc3002.tarea2.game.ability.attack;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.IAbility;

/**
 * IAttack interface gives all attack commond methods.
 *
 * @author Juan Urrutia
 */
public interface IAttack extends IAbility {

    /**
     *
     * @return Returns the damage of the attack.
     */
    public int getDamage();

    /**
     * Sets the damage of the attack
     * @param damage the damage to set.
     */
    public void setDamage(int damage);



    /**
     *
     * @return Returns the cost in energies of the attack in an EnergySet.
     */
    public EnergySet getCost();
}
