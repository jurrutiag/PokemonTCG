package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.Ability;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.phases.IPhase;
import cc3002.tarea2.game.cards.trainer.IObjectCard;
import cc3002.tarea2.game.visitor.Visitor;

import java.util.ArrayList;

/**
 * Class that represents a PokemonCard, the fighting creatures.
 *
 * @author Juan Urrutia
 */
public abstract class PokemonCard implements IPokemonCard {

    /**
     * Ammount of health a PokemonCard currently has, zero hp means the PokemonCard is dead.
     */
    private int hp;
    /**
     * PokemonCard unique identificator.
     */
    private int id;
    /**
     * PokemonCard name, can be repeated on Pokemons with different ids.
     */
    private String name;
    /**
     * The trainer responsible for the PokemonCard.
     */
    private Trainer trainer;
    /**
     * An array with the abilities the PokemonCard has.
     */
    //TODO: largo 4 abilities
    private Ability[] abilities;
    /**
     * An energy set that contains the energies assigned to the PokemonCard.
     */
    private EnergySet energies;

    private ArrayList<IObjectCard> objectCards;

    private IPhase phase;

    //TODO: Make evolutions

    /**
     * Creates a PokemonCard with a certain amount of hp, a set of abilities and an assigned trainer.
     * @param hp Current health of the PokemonCard.
     * @param id The PokemonCard identifier.
     * @param abilities Set of abilities that the pokemon has with a maximum length of 4.
     * @param trainer TrainerCard responsible for the PokemonCard.
     * @param phase The pokemon phase.
     */
    public PokemonCard(int hp, int id, String name, Ability[] abilities, Trainer trainer, IPhase phase) {
        if (hp == 0) {
            hp = 1;
        }
        this.hp = hp;
        this.id = id;
        this.name = name;
        this.abilities = abilities;
        this.trainer = trainer;
        phase.setPokemonCard(this);
        this.phase = phase;

        this.objectCards = new ArrayList<>();
        energies = new EnergySet();
    }

    @Override
    public Ability[] getAbilities() {
        return this.abilities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHp() {
        return this.hp;
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
//    public boolean bePlayedBy(TrainerCard trainer) {
//        return trainer.addPokemonToBench(this);
//    }

    @Override
    public boolean bePlayedBy(Trainer trainer) {
        return this.phase.bePlayedBy(trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
        this.trainer.pokemonDied(this);
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
        return ((Attack) abilities[attackNum - 1]).getDamage();

    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Trainer getTrainer() {
        return trainer;
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
    public boolean checkEnergies(Attack attack) {
        return this.energies.includesEnergies(attack.getCost());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void useAbility(int index) {
        if (index < abilities.length) {
            abilities[index].isUsedBy(this);
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
    public boolean associateObject(IObjectCard objectCard) {
        if (!objectsFull()) {
            this.objectCards.add(objectCard);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "PokemonCard: " + this.getName() + ", hp: " + this.getHp() + ", id: " + this.getId();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPokemonCard(this);
    }

    @Override
    public void setEnergies(EnergySet energySet) {
        this.energies = energySet;
    }

    @Override
    public ArrayList<IObjectCard> getAssociatedObjects() {
        return this.objectCards;
    }
}
