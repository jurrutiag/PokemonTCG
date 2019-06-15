package cc3002.tarea2.game.visitor.ability;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.events.AttackEvent;
import cc3002.tarea2.game.visitor.AbstractAbilityVisitor;

public class PerformAbilityVisitor extends AbstractAbilityVisitor {

    private IPokemonCard pokemon;

    public PerformAbilityVisitor(IPokemonCard pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void visitAttack(IAttack attack) {
        if (pokemon.getTrainer().getOpponent().benchSize() > 0 && pokemon.checkEnergies(attack)) {
            attack.executeEffect(pokemon);
            pokemon.attack(attack);
            pokemon.getTrainer().notifyEvent(new AttackEvent());
        }
    }

    @Override
    public void visitAbility(IAbility ability) {
        ability.executeEffect(pokemon);
        pokemon.getTrainer().notifyEvent(ability.getEvent());
    }

}
