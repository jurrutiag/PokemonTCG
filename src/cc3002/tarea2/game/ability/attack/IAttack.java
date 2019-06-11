package cc3002.tarea2.game.ability.attack;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.EnergySet;

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
     *
     * @return Returns the description of the attack.
     */
    public String getDescription();

    /**
     *
     * @return Returns the cost in energies of the attack in an EnergySet.
     */
    public EnergySet getCost();
}
