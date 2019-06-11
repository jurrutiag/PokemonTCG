package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.trainer.ITrainerCard;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class TrainerCardPlayedEvent implements IEvent {

    private ITrainerCard trainerCard;

    public TrainerCardPlayedEvent(ITrainerCard trainerCard) {
        this.trainerCard = trainerCard;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitTrainerCardPlayedEvent(this);
    }

    public ITrainerCard getTrainerCard() {
        return this.trainerCard;
    }
}
