package cc3002.tarea1.types;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Trainer;
import cc3002.tarea1.Pokemon;

public abstract class WaterType extends Pokemon {

    public WaterType(int hp, Attack[] attacks, Trainer trainer) {
        super(hp, attacks, trainer);
    }


    @Override
    public void attack(int attackNum, Trainer opponent) {
        this.checkEnergies(attackNum);
        opponent.getActivePokemon().receiveWaterAttack(this.getAttackDamage(attackNum));
    }
    public void receiveGrassAttack(int attackDamage) {
        this.receiveDamage(attackDamage * 2);
    }
    public void receiveFireAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }
    public void receiveWaterAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }
    public void receiveElectricAttack(int attackDamage) {
        this.receiveDamage(attackDamage * 2);
    }
    public void receiveFightingAttack(int attackDamage) {
        this.receiveDamage(attackDamage - 30);
    }
    public void receivePsychicAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }

}