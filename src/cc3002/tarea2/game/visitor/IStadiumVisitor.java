package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.NullStadiumCard;

public interface IStadiumVisitor {
    public void visitLuckyStadium(IStadiumCard stadiumCard);

    public void acceptNullStadium(NullStadiumCard nullStadiumCard);
}
