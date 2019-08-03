package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.Trainer;

/**
 * Interface for classes that can be visited by event visitors.
 *
 * @author Juan Urrutia
 */
public interface IEventVisitable {
    /**
     * Accepts a visitor.
     * @param eventVisitor The visitor to be accepted.
     */
    public void accept(IEventVisitor eventVisitor);

    public void setTrainer(Trainer trainer);

    public Trainer getTrainer();
}
