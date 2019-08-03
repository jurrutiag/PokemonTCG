package cc3002.tarea2.game.ability.attack;

import cc3002.tarea2.game.ability.AbstractAbility;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.exceptions.NotEnoughEnergiesForAbilityException;
import cc3002.tarea2.game.visitor.ability.IAbilityVisitor;

/**
 * Class that represents an AbstractAttack.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractAttack extends AbstractAbility implements IAttack {


    /**
     * The damage that the attack deals
     */
    private int damage;

    /**
     * Constructor of the attack
     * @param damage the damage that the attack deals.
     */
    public AbstractAttack(int damage) {
        this.damage = damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage() {
        return this.damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect(IPokemonCard pokemonCard) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IAbilityVisitor visitor) throws NotEnoughEnergiesForAbilityException {
        visitor.visitAttack(this);
    }
}
