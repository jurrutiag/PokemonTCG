package cc3002.tarea2.game.ability;

import cc3002.tarea2.game.events.InstantAbilityPlayedEvent;
import cc3002.tarea2.game.visitor.IAbilityVisitor;
import cc3002.tarea2.game.visitor.IEventVisitable;

public abstract class AbstractAbility implements IAbility {
    public IEventVisitable getEvent() {
        return new InstantAbilityPlayedEvent();
    }

    @Override
    public void accept(IAbilityVisitor abilityVisitor) {
        abilityVisitor.visitAbility(this);
    }
}
