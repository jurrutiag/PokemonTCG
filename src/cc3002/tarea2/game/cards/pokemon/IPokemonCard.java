package cc3002.tarea2.game.cards.pokemon;

import cc3002.tarea2.game.*;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;

import java.util.ArrayList;

/**
 * AbstractPokemonCard interface gives common methods to implemented_pokemons.
 *
 * @author Juan Urrutia
 */
public interface IPokemonCard extends ICard {
    //TODO: public on all methods

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

    public IAbility[] getAbilities();

    /**
     *
     * @param hp Sets the current hp of the pokemon to hp.
     */
    void setHp(int hp);


    /**
     *
     * @return Returns the amount of abilities the AbstractPokemonCard has.
     */
    int getAbilitiesAmount();

    /**
     * {@inheritDoc}
     */
    @Override
    boolean isActivelySelectable();

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
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveGrassAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a fire type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveFireAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a water type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveWaterAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives an electric type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveElectricAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a fighting type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveFightingAttack(IAttack attack);

    /**
     * AbstractPokemonCard receives a psychic type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
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
     * Uses the selected ability.
     * @param index The index of the ability to use.
     */
    void useAbility(int index);

    void addElectricEnergy();

    void addFightingEnergy();

    void addFireEnergy();

    void addGrassEnergy();

    void addPsychicEnergy();

    void addWaterEnergy();

    boolean objectsFull();

    boolean associateObject(IObjectCard objectCard);

    void setEnergies(EnergySet preevolutionEnergySet);

    ArrayList<IObjectCard> getAssociatedObjects();

}
