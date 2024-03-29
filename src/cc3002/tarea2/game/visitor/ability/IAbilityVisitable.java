package cc3002.tarea2.game.visitor.ability;

import cc3002.tarea2.game.exceptions.NotEnoughEnergiesForAbilityException;

/**
 * Interface for classes that can be visited by ability visitors.
 *
 * @author Juan Urrutia
 */
public interface IAbilityVisitable {
    /**
     * Accepts the visitor.
     * @param abilityVisitor The visitor to be accepted.
     */
    public void accept(IAbilityVisitor abilityVisitor) throws NotEnoughEnergiesForAbilityException;
}
