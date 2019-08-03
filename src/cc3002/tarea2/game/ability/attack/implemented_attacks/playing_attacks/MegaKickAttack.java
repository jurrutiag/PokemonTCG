package cc3002.tarea2.game.ability.attack.implemented_attacks.playing_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

public class MegaKickAttack extends AbstractAttack {
    /**
     * Constructor of the attack
     *
     */
    public MegaKickAttack() {
        super(30);
    }

    @Override
    public EnergySet getCost() {
        EnergySet energySet = new EnergySet();
        energySet.addElectricEnergy();
        energySet.addWaterEnergy();
        energySet.addPsychicEnergy();
        energySet.addGrassEnergy();
        energySet.addFireEnergy();
        energySet.addFightingEnergy();
        return energySet;
    }

    @Override
    public String getName() {
        return "Mega Kick";
    }

    @Override
    public String getDescription() {
        return "Throws a very powerful kick to the opponent.";
    }
}
