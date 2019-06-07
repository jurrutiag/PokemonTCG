package cc3002.tarea2.game.Abilities;

import cc3002.tarea2.game.AbstractAbility;
import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.events.AttackEvent;
import cc3002.tarea2.game.visitor.turn.EventVisitor;

public abstract class AbstractAttack extends AbstractAbility implements Attack {

    /**
     * Makes a pokemon attack the opponent.
     * @param pokemon The PokemonCard that attacks.
     */
    @Override
    public void isUsedBy(IPokemonCard pokemon) {
        super.isUsedBy(pokemon);
        if (pokemon.getTrainer().getOpponent().benchSize() > 0 && pokemon.checkEnergies(this)) {
            pokemon.attack(this);
        }
        setChanged();
        notifyObservers(this);
    }

    @Override
    public void accept(EventVisitor visitor) {
        visitor.visitAttackEvent(new AttackEvent());
    }
}
