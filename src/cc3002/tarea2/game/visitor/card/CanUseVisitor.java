package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.cards.IEnergyCard;
import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.cards.ITrainerCard;
import cc3002.tarea2.game.visitor.Visitor;

public class CanUseVisitor implements Visitor {

    private int energyCardsUsed;
    private boolean canUseCard;

    public CanUseVisitor() {
        this.energyCardsUsed = 0;
        this.canUseCard = true;
    }

    public int getEnergyCardsUsed() {
        return energyCardsUsed;
    }

    public void energyCardUsed() {
        energyCardsUsed++;
    }

    public boolean canUseCard() {
        return canUseCard;
    }

    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {
        this.canUseCard = true;
    }

    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {
        this.canUseCard = energyCardsUsed == 0;
    }

    @Override
    public void visitTrainerCard(ITrainerCard trainerCard) {
        this.canUseCard = true;
    }

}
