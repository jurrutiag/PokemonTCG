package cc3002.tarea2.game.ability.attack.implemented_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;

/**
 * Electric Shock attack.
 *
 * @author Juan Urrutia
 */
public class ElectricShock extends AbstractAttack {

    /**
     * Constructor of electric shock, it assigns the damage of the attack to 10.
     */
    public ElectricShock() {
        super(10);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Throw a coin, if it is tails, this pokemon receives 10 damage.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnergySet getCost() {
        EnergySet cost = new EnergySet();
        cost.setElectricEnergies(2);
        return cost;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Electric Shock";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect(IPokemonCard pokemonCard) {
        double coin = Math.random();
        if (coin < 0.5) {
            pokemonCard.receiveDamage(10);
        }
    }
}
