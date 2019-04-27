package cc3002.tarea1.game.Abilities.Attacks;

import cc3002.tarea1.game.EnergySet;
import cc3002.tarea1.game.Attack;

public class GrassAttack implements Attack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Attack of grass";
    }

    @Override
    public EnergySet getCost() {
        return new EnergySet(0, 0, 0, 2, 0, 0);
    }

    @Override
    public String getName() {
        return "GrassAttack";
    }
}