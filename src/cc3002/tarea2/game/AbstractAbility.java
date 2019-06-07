package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.IPokemonCard;

import java.util.Observable;

public abstract class AbstractAbility extends Observable implements Ability {
    public void isUsedBy(IPokemonCard pokemon) {
        this.executeEffect(pokemon);
    }
}
