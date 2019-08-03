package cc3002.tarea2.game.ability.attack.implemented_attacks.playing_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

public class ScratchAttack extends AbstractAttack {
    /**
     * Constructor of the attack
     *
     */
    public ScratchAttack() {
        super(10);
    }

    @Override
    public EnergySet getCost() {
        return new EnergySet();
    }

    @Override
    public String getName() {
        return "Scratch Attack";
    }

    @Override
    public String getDescription() {
        return "The pokemon scratches the enemy.";
    }
}
