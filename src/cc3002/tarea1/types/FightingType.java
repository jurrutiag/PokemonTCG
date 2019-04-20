package cc3002.tarea1.types;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Trainer;
import cc3002.tarea1.Pokemon;

public abstract class FightingType extends Pokemon {

    public FightingType(int hp, Attack[] attacks, Trainer trainer) {
        super(hp, attacks, trainer);
    }


    @Override
    public void attack(int attackNum, Trainer opponent) {
        opponent.getActivePokemon().receiveFightingAttack(this.getAttackDamage(attackNum));
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
        this.receiveDamage(attackDamage);
    }
    public void receiveFightingAttack(int attackDamage) {
        this.receiveDamage(attackDamage);
    }
    public void receivePsychicAttack(int attackDamage) {
        this.receiveDamage(attackDamage * 2);
    }

}