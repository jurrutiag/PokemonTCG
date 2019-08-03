package cc3002.tarea2.game.ability;

import cc3002.tarea2.game.events.InstantAbilityPlayedEvent;
import cc3002.tarea2.game.exceptions.NotEnoughEnergiesForAbilityException;
import cc3002.tarea2.game.visitor.IEventVisitable;
import cc3002.tarea2.game.visitor.ability.AbilityInfoVisitor;
import cc3002.tarea2.game.visitor.ability.IAbilityVisitor;

import java.util.ArrayList;

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
    public void accept(IAbilityVisitor abilityVisitor) throws NotEnoughEnergiesForAbilityException {
        abilityVisitor.visitAbility(this);
    }

    @Override
    public ArrayList<String> getInfo() {
        AbilityInfoVisitor abilityInfoVisitor = new AbilityInfoVisitor();
        try {
            this.accept(abilityInfoVisitor);
        } catch (NotEnoughEnergiesForAbilityException e) {
            // empty on purpouse
        }

        return abilityInfoVisitor.getStrings();
    }
}
