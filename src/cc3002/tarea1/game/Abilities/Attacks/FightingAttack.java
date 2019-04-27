package cc3002.tarea1.game.Abilities.Attacks;

import cc3002.tarea1.game.EnergySet;
import cc3002.tarea1.game.Attack;

public class FightingAttack implements Attack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Physical attack";
    }

    @Override
    public EnergySet getCost() {
        return new EnergySet(0, 2, 0, 0, 0, 0);
    }

    @Override
    public String getName() {
        return "FightingAttack";
    }
}