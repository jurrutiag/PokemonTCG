package cc3002.tarea2.game.ability;

import cc3002.tarea2.game.visitor.IAbilityVisitable;

/**
 * IAbility interface gives common methods to all abilities that a AbstractPokemonCard can have.
 *
 * @author Juan Urrutia
 */
public interface IAbility extends IAbilityVisitable {
    /**
     *
     * @return Returns the name of the ability.
     */
    public String getName();

}
