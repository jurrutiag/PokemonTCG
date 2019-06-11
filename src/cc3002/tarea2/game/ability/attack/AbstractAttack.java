package cc3002.tarea2.game.ability.attack;

import cc3002.tarea2.game.ability.AbstractAbility;
import cc3002.tarea2.game.visitor.IAbilityVisitor;

public abstract class AbstractAttack extends AbstractAbility implements IAttack {

//    /**
//     * Makes a pokemon attack the opponent.
//     * @param pokemon The AbstractPokemonCard that attacks.
//     */
//    @Override
//    public void isUsedBy(IPokemonCard pokemon) {
//        super.isUsedBy(pokemon);
//        if (pokemon.getTrainer().getOpponent().benchSize() > 0 && pokemon.checkEnergies(this)) {
//            pokemon.attack(this);
//        }
//        setChanged();
//        notifyObservers(this);
//    }

    @Override
    public void accept(IAbilityVisitor visitor) {
        visitor.visitAttack(this);
    }
}
