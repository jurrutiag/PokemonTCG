package cc3002.tarea2.game.visitor.turn;

public interface EventVisitable {
    public void accept(EventVisitor visitor);
}
