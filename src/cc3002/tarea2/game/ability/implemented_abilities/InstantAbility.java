package cc3002.tarea2.game.ability.implemented_abilities;

import cc3002.tarea2.game.ability.AbstractAbility;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;

public class InstantAbility extends AbstractAbility {
    @Override
    public String getName() {
        return "Instant Ability";
    }

    @Override
    public String getDescription() {
        return "An instant ability";
    }

    @Override
    public void executeEffect(IPokemonCard pokemonCard) {
        assert(false);
    }
}
