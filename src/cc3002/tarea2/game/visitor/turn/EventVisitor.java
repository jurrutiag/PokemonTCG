package cc3002.tarea2.game.visitor.turn;

import cc3002.tarea2.game.events.ActivePokemonDiedEvent;
import cc3002.tarea2.game.events.AttackEvent;
import cc3002.tarea2.game.visitor.Visitor;

public interface EventVisitor extends Visitor {
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent);
    public void visitAttackEvent(AttackEvent attackEvent);
}
