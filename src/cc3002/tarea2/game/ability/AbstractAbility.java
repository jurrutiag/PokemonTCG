package cc3002.tarea2.game.ability;

import cc3002.tarea2.game.events.InstantAbilityPlayedEvent;
import cc3002.tarea2.game.visitor.ability.IAbilityVisitor;
import cc3002.tarea2.game.visitor.IEventVisitable;

/**
 * Class that represents an AbstractAbility.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractAbility implements IAbility {
    /**
     * {@inheritDoc}
     */
    @Override
    public IEventVisitable getEvent() {
        return new InstantAbilityPlayedEvent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IAbilityVisitor abilityVisitor) {
        abilityVisitor.visitAbility(this);
    }
}
