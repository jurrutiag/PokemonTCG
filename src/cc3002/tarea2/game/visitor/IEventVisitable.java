package cc3002.tarea2.game.visitor;

public interface IEventVisitable {
    public void accept(IEventVisitor eventVisitor);
}
