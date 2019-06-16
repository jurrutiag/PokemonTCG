package cc3002.tarea2.game.ability.implemented_abilities;

import cc3002.tarea2.game.ability.AbstractAbility;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.events.OnceATurnAbilityEffect;
import cc3002.tarea2.game.visitor.IEventVisitable;

/**
 * Wing Buzz ability, an ability that is not discarded automatically, it binds to the pokemon.
 *
 * @author Juan Urrutia
 */
public class WingBuzz extends AbstractAbility {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Wing Buzz";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Once per turn, if this pokemon is active, you can discard one card from your hand, if you do, discard the top card of your opponent's deck";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IEventVisitable getEvent() {
        return new OnceATurnAbilityEffect(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect(IPokemonCard pokemonCard) {
        if (pokemonCard.equals(pokemonCard.getTrainer().getActivePokemon())) {
            pokemonCard.getTrainer().selectHandCard(0);
            pokemonCard.getTrainer().discardSelectedFromHand();
            pokemonCard.getTrainer().getOpponent().discard(pokemonCard.getTrainer().getOpponent().getDeck().drawTopCards(1).get(0));
        }
    }

}
