package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.*;
import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.cards.trainer.IObjectCard;

import java.util.ArrayList;

/**
 * PokemonCard interface gives common methods to pokemons.
 *
 * @author Juan Urrutia
 */
public interface IPokemonCard extends Card {
    //TODO: public on all methods

    /**
     *
     * @return Returns the PokemonCard hp.
     */
    int getHp();

    /**
     *
     * @return Returns the PokemonCard id.
     */
    int getId();

    /**
     * {@inheritDoc}
     */
    @Override
    String getName();

    public Ability[] getAbilities();

    /**
     *
     * @param hp Sets the current hp of the pokemon to hp.
     */
    void setHp(int hp);

    /**
     * Makes the player play this pokemon card.
     * @param trainer The trainerCard that plays the card.
     */
    @Override
    boolean bePlayedBy(Trainer trainer);

    /**
     *
     * @return Returns the amount of abilities the PokemonCard has.
     */
    int getAbilitiesAmount();

    /**
     * {@inheritDoc}
     */
    @Override
    boolean isActivelySelectable();

    /**
     * Deals damage to the PokemonCard that receives the message.
     * @param damage Amount of damage received.
     */
    void receiveDamage(int damage);

    /**
     * Calls the receive damage method for the PokemonCard with twice the damage.
     * @param damage The damage that will be duplicated.
     */
    void receiveWeaknessDamage(int damage);

    /**
     * Calls the receive damage method for the PokemonCard with 30 points less of damage.
     * @param damage The damage that will be reduced.
     */
    void receiveResistantDamage(int damage);

    /**
     * PokemonCard that receives the message attacks the opponent's active PokemonCard with the corresponding attack
     * selected with attackNum.
     * @param attack Number of attack used, corresponds to the index plus one of the abilities array (1st, 2nd, 3rd or 4th).
     *
     */
    void attack(Attack attack);

    /**
     * PokemonCard receives a grass type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveGrassAttack(Attack attack);

    /**
     * PokemonCard receives a fire type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveFireAttack(Attack attack);

    /**
     * PokemonCard receives a water type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveWaterAttack(Attack attack);

    /**
     * PokemonCard receives an electric type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveElectricAttack(Attack attack);

    /**
     * PokemonCard receives a fighting type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receiveFightingAttack(Attack attack);

    /**
     * PokemonCard receives a psychic type attack.
     * @param attack The amount of damage received, will be adjusted according to resistance and weakness.
     */
    void receivePsychicAttack(Attack attack);

    /**
     * Gets the damage that deals a specified attack on the abilities array.
     * @param attackNum Represents the index plus one of the attack in the abilities array.
     * @return Returns the attack damage of the requested attack.
     */
    int getAttackDamage(int attackNum);

    /**
     *
     * @return Returns the PokemonCard trainer.
     */
    Trainer getTrainer();

    /**
     *
     * @return Returns the EnergyCard set of the PokemonCard.
     */
    EnergySet getEnergySet();

    /**
     * Checks if the PokemonCard has the energies required for the ability represented by abilityNum to be casted.
     * @param attack Index plus one of the ability to request for.
     * @return Returns true if the ability can be casted.
     */
    boolean checkEnergies(Attack attack);



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
