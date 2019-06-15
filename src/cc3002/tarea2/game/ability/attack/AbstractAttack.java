package cc3002.tarea2.game.ability.attack;

import cc3002.tarea2.game.ability.AbstractAbility;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.visitor.IAbilityVisitor;

public abstract class AbstractAttack extends AbstractAbility implements IAttack {


    private int damage;

    public AbstractAttack(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    @Override
    public void executeEffect(IPokemonCard pokemonCard) {

    }

    @Override
    public void accept(IAbilityVisitor visitor) {
        visitor.visitAttack(this);
    }
}
