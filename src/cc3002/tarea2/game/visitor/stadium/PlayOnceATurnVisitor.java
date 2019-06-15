package cc3002.tarea2.game.visitor.stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.NullStadiumCard;
import cc3002.tarea2.game.visitor.IStadiumVisitor;

public class PlayOnceATurnVisitor implements IStadiumVisitor {

    private Trainer trainer;

    public PlayOnceATurnVisitor(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public void visitLuckyStadium(IStadiumCard stadiumCard) {
        stadiumCard.executeEffect(trainer);
    }

    @Override
    public void acceptNullStadium(NullStadiumCard nullStadiumCard) {

    }
}
