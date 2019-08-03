package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Abstract object class containing common methods for objects.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractObjectCard extends AbstractTrainerCard implements IObjectCard {

    /**
     * The pokemon that executes the object or holds this card.
     */
    private IPokemonCard pokemonCard;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IObjectCard) && ((IObjectCard) obj).getDescription().equals(this.getDescription()) && ((IObjectCard) obj).getName().equals(this.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPokemon(IPokemonCard pokemonCard) {
        this.pokemonCard = pokemonCard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IPokemonCard getPokemon() {
        return this.pokemonCard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitObjectCard(this);
    }

}
