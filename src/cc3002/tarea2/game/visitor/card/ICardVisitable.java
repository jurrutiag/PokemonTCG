package cc3002.tarea2.game.visitor.card;

/**
 * Interface for classes that can be visited by card visitors.
 *
 * @author Juan Urrutia
 */
public interface ICardVisitable {
    /**
     * Accepts a card visitor.
     * @param visitor The visitor to be accepted.
     */
    public void accept(ICardVisitor visitor);
}
