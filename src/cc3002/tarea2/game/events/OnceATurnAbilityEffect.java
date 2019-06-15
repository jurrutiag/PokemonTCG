package cc3002.tarea2.game.events;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class OnceATurnAbilityEffect extends AbstractEvent {
    private IAbility ability;

    public OnceATurnAbilityEffect(IAbility ability) {
        this.ability = ability;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitOnceATurnAbilityEffect(this);
    }

    public IAbility getAbility() {
        return this.ability;
    }
}
