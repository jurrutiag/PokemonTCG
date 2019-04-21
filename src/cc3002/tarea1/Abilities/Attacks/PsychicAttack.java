package cc3002.tarea1.Abilities.Attacks;

import cc3002.tarea1.Attack;
import cc3002.tarea1.EnergySet;

public class PsychicAttack implements Attack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Attack of psyche";
    }

    @Override
    public EnergySet getCost() {
        return new EnergySet(0, 0, 0, 0, 2, 0);
    }

    @Override
    public String getName() {
        return "PsychicAttack";
    }
}