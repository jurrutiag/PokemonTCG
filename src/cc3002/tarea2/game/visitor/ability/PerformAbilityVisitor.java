package cc3002.tarea2.game.visitor.ability;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.events.AttackEvent;

/**
 * Class that performs abilities of a pokemon using visitor pattern.
 *
 * @author Juan Urrutia
 */
public class PerformAbilityVisitor extends AbstractAbilityVisitor {

    /**
     * The pokemon that executes the ability.
     */
    private IPokemonCard pokemon;

    /**
     * The constructor for the visitor.
     * @param pokemon The pokemon that executes the ability.
     */
    public PerformAbilityVisitor(IPokemonCard pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitAttack(IAttack attack) {
        if (pokemon.getTrainer().getOpponent().benchSize() > 0 && pokemon.checkEnergies(attack)) {
            attack.executeEffect(pokemon);
            pokemon.attack(attack);
            pokemon.getTrainer().notifyEvent(new AttackEvent());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitAbility(IAbility ability) {
        ability.executeEffect(pokemon);
        pokemon.getTrainer().notifyEvent(ability.getEvent());
    }

}
