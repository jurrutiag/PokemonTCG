package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;

public interface IAbilityVisitor {
    public void visitAttack(IAttack attack);
    public void visitAbility(IAbility ability);
}
