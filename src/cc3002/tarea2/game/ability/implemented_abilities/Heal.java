package cc3002.tarea2.game.ability.implemented_abilities;

import cc3002.tarea2.game.ability.AbstractAbility;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.events.OnceATurnAbilityEffect;
import cc3002.tarea2.game.visitor.IEventVisitable;

/**
 * Heal ability, heals a pokemon on the bench.
 *
 * @author Juan Urrutia
 */
public class Heal extends AbstractAbility {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Heal";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Once per turn, you can throw a coin, if it lands heads you can remove one damage counter from one of your pokemons.";
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
        double coin = Math.random();
        if (coin < 0.5) {
            // In this implementation, the chosen pokemon is itself.
            pokemonCard.removeDamageCounters(1);
        }
    }
}
