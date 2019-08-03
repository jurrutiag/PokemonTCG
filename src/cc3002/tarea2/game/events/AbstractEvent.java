package cc3002.tarea2.game.events;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.IEventVisitable;

/**
 * Class representing an Abstract Event.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractEvent implements IEventVisitable {

    private Trainer trainer;

    @Override
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public Trainer getTrainer() {
        return this.trainer;
    }
}
