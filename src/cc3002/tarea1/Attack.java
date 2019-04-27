package cc3002.tarea1;

/**
 * Attack interface gives all Attacks commond methods.
 */
public interface Attack extends Ability {

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
