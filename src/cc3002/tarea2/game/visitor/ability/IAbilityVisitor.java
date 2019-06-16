package cc3002.tarea2.game.visitor.ability;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;

/**
 * Interface for classes that can visit ability visitables.
 *
 * @author Juan Urrutia
 */
public interface IAbilityVisitor {
    /**
     * Visits an attack.
     * @param attack the attack to be visited.
     */
    public void visitAttack(IAttack attack);

    /**
     * Visits an ability.
     * @param ability The ability to be visited.
     */
    public void visitAbility(IAbility ability);
}
