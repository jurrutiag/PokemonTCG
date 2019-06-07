package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.cards.IEnergyCard;
import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.cards.ITrainerCard;

public interface Visitor {
    public void visitPokemonCard(IPokemonCard pokemonCard);
    public void visitEnergyCard(IEnergyCard energyCard);
    public void visitTrainerCard(ITrainerCard trainerCard);
}
