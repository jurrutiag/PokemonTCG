package cc3002.tarea1;

/**
 * Class that represents a Pokemon, the fighting creatures.
 */
public abstract class Pokemon implements Card {

    /**
     * Ammount of health a Pokemon currently has, zero hp means the Pokemon is dead.
     */
    private int hp;
    /**
     * The trainer responsible for the Pokemon.
     */
    private Trainer trainer;
    /**
     * An array with the abilities the Pokemon has.
     */
    private Ability[] abilities;
    /**
     * An energy set that contains the energies assigned to the Pokemon.
     */
    private EnergySet energies;

    /**
     * Creates a Pokemon with a certain amount of hp, a set of abilities and an assigned trainer.
     * @param hp Current health of the Pokemon.
     * @param abilities Set of abilities that the pokemon has with a maximum length of 4.
     * @param trainer Trainer responsible for the Pokemon.
     */
    public Pokemon(int hp, Ability[] abilities, Trainer trainer) {
        this.hp = hp;
        this.abilities = abilities;
        this.trainer = trainer;

        energies = new EnergySet();
    }


    /**
     * @return Returns the current hp of the Pokemon.
     */
    public int getHp() {
        return hp;
    }

    /**
     *
     * @param hp Sets the current hp of the pokemon to hp.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     *
     * @return Returns the amount of abilities the Pokemon has.
     */
    public int getAbilitiesAmount() {
        return abilities.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActivelySelectable() {
        return this.hp != 0;
    }

    /**
     * Deals damage to the Pokemon that receives the message.
     * @param damage Amount of damage received.
     */
    public void receiveDamage(int damage) {
        if (damage > 0) {
            hp -= damage;
        }
        if (hp <= 0) {
            hp = 0;
            this.dead();
        }
    }

    /**
     * Calls the receive damage method for the Pokemon with twice the damage.
     * @param damage The damage that will be duplicated.
     */
    public void receiveWeaknessDamage(int damage) {
        this.receiveDamage(2 * damage);
    }

    /**
     * Calls the receive damage method for the Pokemon with 30 points less of damage.
     * @param damage The damage that will be reduced.
     */
    public void receiveResistantDamage(int damage) {
        this.receiveDamage(damage - 30);
    }

    /**
     * Pokemon that receives the message attacks the opponent's active Pokemon with the corresponding attack
     * selected with attackNum.
     * @param attackNum Number of attack used, corresponds to the index plus one of the abilities array.
     * @param opponent The opponent that is getting attacked.
     */
    public abstract void attack(int attackNum, Trainer opponent);

    /**
     *
     * @return Returns the id of the Pokemon.
     */
    public abstract int getId();

    /**
     *
     * @return Returns the name of the Pokemon.
     */
    public abstract String getName();

    /**
     * Pokemon receives a grass type attack.
     * @param attackDamage The amount of damage received, will be adjusted according to resistance and weakness.
     */
    public abstract void receiveGrassAttack(int attackDamage);
    /**
     * Pokemon receives a fire type attack.
     * @param attackDamage The amount of damage received, will be adjusted according to resistance and weakness.
     */
    public abstract void receiveFireAttack(int attackDamage);
    /**
     * Pokemon receives a water type attack.
     * @param attackDamage The amount of damage received, will be adjusted according to resistance and weakness.
     */
    public abstract void receiveWaterAttack(int attackDamage);
    /**
     * Pokemon receives an electric type attack.
     * @param attackDamage The amount of damage received, will be adjusted according to resistance and weakness.
     */
    public abstract void receiveElectricAttack(int attackDamage);
    /**
     * Pokemon receives a fighting type attack.
     * @param attackDamage The amount of damage received, will be adjusted according to resistance and weakness.
     */
    public abstract void receiveFightingAttack(int attackDamage);
    /**
     * Pokemon receives a psychic type attack.
     * @param attackDamage The amount of damage received, will be adjusted according to resistance and weakness.
     */
    public abstract void receivePsychicAttack(int attackDamage);

    /**
     * Gets the damage that deals a specified attack on the abilities array.
     * @param attackNum Represents the index plus one of the attack in the abilities array.
     * @return Returns the attack damage of the requested attack.
     * @throws ArrayIndexOutOfBoundsException
     */
    public int getAttackDamage(int attackNum) throws ArrayIndexOutOfBoundsException {
        return ((Attack) abilities[attackNum - 1]).getDamage();
    }

    /**
     * Method called when the Pokemon dies so the trainer swaps the active Pokemon.
     */
    public void dead() {
        getTrainer().swapNextNotDead();
    }

    /**
     *
     * @return Returns the Pokemon trainer.
     */
    public Trainer getTrainer() {
        return trainer;
    }

    /**
     * Binds an energy to the Pokemon adding it to the Energy set of the Pokemon.
     * @param energy Energy to be binded.
     */
    public void bindEnergy(IEnergy energy) {
        energies.addEnergy(energy);
    }

    /**
     *
     * @return Returns the Energy set of the Pokemon.
     */
    public EnergySet getEnergies() {
        return energies;
    }

    /**
     * Checks if the Pokemon has the energies required for the ability represented by abilityNum to be casted.
     * @param abilityNum Index plus one of the ability to request for.
     * @return Returns true if the ability can be casted.
     */
    public boolean checkEnergies(int abilityNum) {
        return this.energies.includesEnergies(((Attack) abilities[abilityNum - 1]).getCost());
    }
}
