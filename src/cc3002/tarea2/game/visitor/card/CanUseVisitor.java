package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.cards.energies.IEnergyCard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;

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
     * The variable that says if the card can be used.
     */
    private boolean canUseCard;

    /**
     * Can use visitor constructor.
     */
    public CanUseVisitor() {
        this.energyCardsUsed = 0;
        this.canUseCard = true;
    }

    /**
     * Increments the amount of energy cards used.
     */
    public void energyCardUsed() {
        energyCardsUsed++;
    }

    /**
     *
     * @return Returns true if the card can be used.
     */
    public boolean canUseCard() {
        return canUseCard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {
        this.canUseCard = true;
    }

    /**
     * {@inheritDoc}
     * Can use an energy card if there is no energy card used already.
     */
    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {
        this.canUseCard = energyCardsUsed == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitTrainerCard(ITrainerCard trainerCard) {
        this.canUseCard = true;
    }

}
