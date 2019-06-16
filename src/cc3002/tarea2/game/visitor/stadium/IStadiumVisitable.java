package cc3002.tarea2.game.visitor.stadium;

/**
 * Interface for classes that can be visited by stadium visitors.
 *
 * @author Juan Urrutia
 */
public interface IStadiumVisitable {
    /**
     * Method to accept a stadium visitor.
     * @param visitor The visitor to be accepted.
     */
    public void acceptStadiumVisitor(IStadiumVisitor visitor);
}
