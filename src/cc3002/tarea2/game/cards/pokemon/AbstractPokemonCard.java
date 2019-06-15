package cc3002.tarea2.game.cards.pokemon;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.AbstractCard;
import cc3002.tarea2.game.cards.trainer.object.INonInstantObject;
import cc3002.tarea2.game.visitor.ICardVisitor;
import cc3002.tarea2.game.visitor.ability.PerformAbilityVisitor;

import java.util.ArrayList;

/**
 * Class that represents a AbstractPokemonCard, the fighting creatures.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractPokemonCard extends AbstractCard implements IPokemonCard {

    private int maxHp;
    /**
     * Ammount of health a AbstractPokemonCard currently has, zero hp means the AbstractPokemonCard is dead.
     */
    private int hp;
    /**
     * AbstractPokemonCard unique identificator.
     */
    private int id;
    /**
     * AbstractPokemonCard name, can be repeated on Pokemons with different ids.
     */
    private String name;
    /**
     * An array with the abilities the AbstractPokemonCard has.
     */
    //TODO: largo 4 abilities
    private ArrayList<IAbility> abilities = new ArrayList<>();
    /**
     * An energy set that contains the energies assigned to the AbstractPokemonCard.
     */
    private EnergySet energies;

    private ArrayList<INonInstantObject> objectCards;


    //TODO: Make evolutions

    /**
     * Creates a AbstractPokemonCard with a certain amount of hp, a set of abilities and an assigned trainer.
     * @param maxHp Current health of the AbstractPokemonCard.
     * @param id The AbstractPokemonCard identifier.
     * @param abilities Set of abilities that the pokemon has with a maximum length of 4.
     * @param trainer AbstractTrainerCard responsible for the AbstractPokemonCard.
     */
    public AbstractPokemonCard(int maxHp, int id, String name, IAbility[] abilities, Trainer trainer) {
        if (hp == 0) {
            hp = 1;
        }
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.id = id;
        this.name = name;
        this.setAbilities(abilities);
        this.setTrainer(trainer);
        this.objectCards = new ArrayList<>();
        energies = new EnergySet();
    }

    @Override
    public ArrayList<IAbility> getAbilities() {
        return this.abilities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHp(int hp) {
        this.hp = hp < 0 ? 0 : hp;
    }

//    /**
//     * {@inheritDoc}
//     * @param trainer
//     */
//    @Override
//    public boolean bePlayedBy(AbstractTrainerCard trainer) {
//        return trainer.addPokemonToBench(this);
//    }

    public void setAbilities(IAbility[] abilities) {
        for (int i = 0; i < 4 && i < abilities.length; i ++) {
            this.abilities.add(abilities[i]);
        }
    }

    @Override
    public int getDamageCounters() {
        return (this.maxHp - this.hp) / 10;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAbilitiesAmount() {
        return abilities.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActivelySelectable() {
        return this.hp != 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveDamage(int damage) {
        if (damage > 0) {
            hp -= damage;
        }
        if (hp <= 0) {
            hp = 0;
            this.died();
        }
    }

    public void died() {
        this.getTrainer().pokemonDied(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveWeaknessDamage(int damage) {
        this.receiveDamage(2 * damage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveResistantDamage(int damage) {
        this.receiveDamage(damage - 30);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAttackDamage(int attackNum) {
        return ((IAttack) abilities.get(attackNum - 1)).getDamage();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnergySet getEnergySet() {
        return energies;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkEnergies(IAttack attack) {
        return this.energies.includesEnergies(attack.getCost());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void useAbility(int index) {
        if (index < abilities.size()) {
            //abilities[index].isUsedBy(this);
            abilities.get(index).accept(new PerformAbilityVisitor(this));
        }
    }

    @Override
    public void addElectricEnergy() {
        energies.addElectricEnergy();
    }

    @Override
    public void addFightingEnergy() {
        energies.addFightingEnergy();
    }

    @Override
    public void addFireEnergy() {
        energies.addFireEnergy();
    }

    @Override
    public void addGrassEnergy() {
        energies.addGrassEnergy();
    }

    @Override
    public void addPsychicEnergy() {
        energies.addPsychicEnergy();
    }

    @Override
    public void addWaterEnergy() {
        energies.addWaterEnergy();
    }

    @Override
    public boolean objectsFull() {
        return objectCards.size() >= 1;
    }

    @Override
    public boolean associateObject(INonInstantObject objectCard) {
        if (!objectsFull()) {
            objectCard.setPokemon(this);
            this.objectCards.add(objectCard);
            return true;
        }
        return false;
    }

    @Override
    public void accept(ICardVisitor visitor) {
        visitor.visitPokemonCard(this);
    }

    @Override
    public void setEnergies(EnergySet energySet) {
        this.energies = energySet;
    }

    @Override
    public ArrayList<INonInstantObject> getAssociatedObjects() {
        return this.objectCards;
    }

    @Override
    public void executeObjectEffect() {
        this.getAssociatedObjects().get(0).executeEffect();
    }

    @Override
    public IAbility getAbility(int index) {
        return this.getAbilities().get(index);
    }
}
