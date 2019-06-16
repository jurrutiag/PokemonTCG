package cc3002.tarea2.game.ability.implemented_abilities;

import cc3002.tarea2.game.ability.AbstractAbility;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;

/**
 * Instant Ability represents an ability that is played and discarded automatically.
 *
 * @author Juan Urrutia
 */
public class InstantAbility extends AbstractAbility {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Instant Ability";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "An instant ability";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect(IPokemonCard pokemonCard) {
        assert(false);
    }
}
