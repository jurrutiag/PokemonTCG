package cc3002.tarea2.game.cards.pokemon.types;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.AbstractPokemonCard;

/**
 * Class representing the psychic type of Pokemons.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractPsychicPokemon extends AbstractPokemonCard implements IPsychicPokemon {

    /**
     * Creates a psychic type AbstractPokemonCard.
     * @param hp The initial hp of the AbstractPokemonCard.
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer The trainer owner of the AbstractPokemonCard.
     */
    public AbstractPsychicPokemon(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attack(IAttack attack) {
        this.getTrainer().getOpponent().getActivePokemon().receivePsychicAttack(attack);
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveGrassAttack(IAttack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveFireAttack(IAttack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveWaterAttack(IAttack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveElectricAttack(IAttack attack) {
        this.receiveDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receiveFightingAttack(IAttack attack) {
        this.receiveResistantDamage(attack.getDamage());
    }

    /**
     * {@inheritDoc}
     * @param attack
     */
    @Override
    public void receivePsychicAttack(IAttack attack) {
        this.receiveWeaknessDamage(attack.getDamage());
    }

}