package cc3002.tarea2.game.visitor.stadium;

import cc3002.tarea2.game.cards.trainer.stadium.NullStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.implemented_stadium.LuckyStadium;

/**
 * Interface for classes that can visit stadium visitables.
 *
 * @author Juan Urrutia
 */
public interface IStadiumVisitor {

    /**
     * Visits a lucky stadium.
     * @param stadiumCard The lucky stadium to be visited.
     */
    public void visitLuckyStadium(LuckyStadium stadiumCard);

    /**
     * Visits a null stadium.
     * @param nullStadiumCard The stadium to be visited.
     */
    public void acceptNullStadium(NullStadiumCard nullStadiumCard);
}
