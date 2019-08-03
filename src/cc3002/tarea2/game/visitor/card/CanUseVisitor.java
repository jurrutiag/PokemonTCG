package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.cards.energies.IEnergyCard;
import cc3002.tarea2.game.cards.trainer.support.ISupportCard;
import cc3002.tarea2.game.exceptions.EnergyCardAlreadyUsedException;
import cc3002.tarea2.game.exceptions.SupportCardAlreadyUsedException;

/**
 * Class that checks if a card can be used using visitor pattern.
 *
 * @author Juan Urrutia
 */
public class CanUseVisitor extends AbstractCardVisitor {

    /**
     * The energy cards used on a turn.
     */
    private int energyCardsUsed;

    /**
     * The support cards used on a turn.
     */
    private int supportCardsUsed;


    /**
     * Can use visitor constructor.
     */
    public CanUseVisitor() {
        this.energyCardsUsed = 0;
    }

    /**
     * Increments the amount of energy cards used.
     */
    public void energyCardUsed() {
        energyCardsUsed++;
    }

    /**
     * Increments the amount of support cards used.
     */
    public void supportCardUsed() {
        supportCardsUsed++;
    }

    /**
     * {@inheritDoc}
     * Can use an energy card if there is no energy card used already.
     */
    @Override
    public void visitEnergyCard(IEnergyCard energyCard) throws EnergyCardAlreadyUsedException {
        if (energyCardsUsed != 0) {
            throw new EnergyCardAlreadyUsedException();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitSupportCard(ISupportCard supportCard) throws SupportCardAlreadyUsedException {
        if (supportCardsUsed != 0) {
            throw new SupportCardAlreadyUsedException();
        }
    }

}
