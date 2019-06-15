package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class AbstractNonInstantObject extends AbstractObjectCard implements INonInstantObject {

    @Override
    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitNonInstantObjectCard(this);
    }
}
