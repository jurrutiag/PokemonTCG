package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;
import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class AbstractObjectCard extends AbstractTrainerCard implements IObjectCard {

    private IPokemonCard pokemonCard;

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IObjectCard) && ((IObjectCard) obj).getDescription().equals(this.getDescription()) && ((IObjectCard) obj).getName().equals(this.getName());
    }

    @Override
    public void setPokemon(IPokemonCard pokemonCard) {
        this.pokemonCard = pokemonCard;
    }

    @Override
    public IPokemonCard getPokemon() {
        return this.pokemonCard;
    }

    @Override
    public void accept(ICardVisitor visitor) {
        visitor.visitObjectCard(this);
    }

}
