package cc3002.tarea1.game.Abilities.Attacks;

import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.EnergySet;

public class WaterAttack implements Attack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Attack of water";
    }

    @Override
    public EnergySet getCost() {
        return new EnergySet(0, 0, 0, 0, 0, 2);
    }

    @Override
    public String getName() {
        return "WaterAttack";
    }
}