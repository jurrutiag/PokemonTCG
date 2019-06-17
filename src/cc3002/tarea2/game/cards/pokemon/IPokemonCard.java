package cc3002.tarea2.game.cards.pokemon;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.trainer.object.INonInstantObject;

import java.util.ArrayList;

/**
 * IPokemonCard interface gives common methods to testing_pokemons.
 *
 * @author Juan Urrutia
 */
public interface IPokemonCard extends ICard {

    /**
     *
     * @return Returns the AbstractPokemonCard hp.
     */
    int getHp();

    /**
     *
     * @return Returns the AbstractPokemonCard id.
     */
    int getId();

    /**
     * {@inheritDoc}
     */
    @Override
    String getName();

    /**
     *
     * @return Returns all the pokemon's abilities
     */
    public ArrayList<IAbility> getAbilities();

    /**
     *
     * @param hp Sets the current hp of the pokemon to hp.
     */
    void setHp(int hp);

    /**
     *
     * @return Returns the damage counters on the pokemon (10 damage per counter)
     */
    public int getDamageCounters();

    /**
     *
     * @return Returns the amount of abilities the AbstractPokemonCard has.
     */
    int getAbilitiesAmount();


    /**
     * Deals damage to the AbstractPokemonCard that receives the message.
     * @param damage Amount of damage received.
     */
    void receiveDamage(int damage);

    /**
     * Calls the receive damage method for the AbstractPokemonCard with twice the damage.
     * @param damage The damage that will be duplicated.
     */
    void receiveWeaknessDamage(int damage);

    /**
     * Calls the receive damage method for the AbstractPokemonCard with 30 points less of damage.
     * @param damage The damage that will be reduced.
     */
    void receiveResistantDamage(int damage);

    /**
     * AbstractPokemonCard that receives the message attacks the opponent's active AbstractPokemonCard with the corresponding attack
     * selected with attackNum.
     * @param attack Number of attack used, corresponds to the index plus one of the abilities array (1st, 2nd, 3rd or 4th).
     *
     */
    void attack(IAttack attack);

    /**
     * AbstractPokemonCard receives a grass type attack.
     * @param attack The attack received.
     */
    void receiveGrassAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a fire type attack.
     * @param attack The attack received.
     */
    void receiveFireAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a water type attack.
     * @param attack The attack received.
     */
    void receiveWaterAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives an electric type attack.
     * @param attack The attack received.
     */
    void receiveElectricAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a fighting type attack.
     * @param attack The attack received.
     */
    void receiveFightingAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a psychic type attack.
     * @param attack The attack received.
     */
    void receivePsychicAttack(IAttack attack);

    /**
     * Gets the damage that deals a specified attack on the abilities array.
     * @param attackNum Represents the index plus one of the attack in the abilities array.
     * @return Returns the attack damage of the requested attack.
     */
    int getAttackDamage(int attackNum);

    /**
     *
     * @return Returns the AbstractPokemonCard trainer.
     */
    Trainer getTrainer();

    /**
     *
     * @return Returns the AbstractEnergyCard set of the AbstractPokemonCard.
     */
    EnergySet getEnergySet();

    /**
     * Checks if the AbstractPokemonCard has the energies required for the ability represented by abilityNum to be casted.
     * @param attack Index plus one of the ability to request for.
     * @return Returns true if the ability can be casted.
     */
    boolean checkEnergies(IAttack attack);

    /**
     *
     * @return Returns the maximum hp.
     */
    public int getMaxHp();


    /**
     * Uses the selected ability.
     * @param index The index of the ability to use.
     */
    void useAbility(int index);

    /**
     * Adds an electric energy to the set.
     */
    void addElectricEnergy();

    /**
     * Adds a fighting energy to the set.
     */
    void addFightingEnergy();

    /**
     * Adds a fire energy to the set.
     */
    void addFireEnergy();

    /**
     * Adds a grass energy to the set.
     */
    void addGrassEnergy();

    /**
     * Adds a psychic energy to the set.
     */
    void addPsychicEnergy();

    /**
     * Adds a water energy to the set.
     */
    void addWaterEnergy();

    /**
     *
     * @return Returns true if the pokemon cannot have more objects.
     */
    boolean objectsFull();

    /**
     * Associates an object to the pokemon.
     * @param objectCard the object to be associated.
     * @return Returns true if successful.
     */
    boolean associateObject(INonInstantObject objectCard);

    /**
     * Sets the energies of the pokemon
     * @param preevolutionEnergySet the energy set that will be copied.
     */
    void setEnergies(EnergySet preevolutionEnergySet);

    /**
     *
     * @return Returns all associated objects (1 max for now)
     */
    ArrayList<INonInstantObject> getAssociatedObjects();

    /**
     * Executes the associated object effect.
     */
    void executeObjectEffect();

    /**
     * Returns the selected ability
     * @param abilityIndex the index of the ability
     * @return returns the ability.
     */
    IAbility getAbility(int abilityIndex);

    /**
     * Sets the abilities
     * @param abilities the ability array to be set to.
     */
    public void setAbilities(IAbility[] abilities);

    /**
     * Removes i damage counters (10 hp each).
     * @param i The number of damage counters to be removed.
     */
    public void removeDamageCounters(int i);
}
