package cc3002.tarea1;

import java.io.PrintStream;

public abstract class Pokemon implements Card {

    private int hp;
    private Trainer trainer;
    private Attack[] attacks = new Attack[4];

    public Pokemon(int hp, Attack[] attacks, Trainer trainer) {
        this.hp = hp;
        this.attacks = attacks;
        this.trainer = trainer;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttacksAmount() {
        return attacks.length;
    }

    @Override
    public boolean isActivelySelectable() {
        return true;
    }

    public void receiveDamage(int damage) {
        if (damage > 0) {
            hp -= damage;
        }
        if (hp <= 0) {
            hp = 0;
            this.dead();
        }
    }

    public abstract void attack(int attackNum, Trainer opponent);

    public abstract int getId();

    public abstract void receiveGrassAttack(int attackDamage);
    public abstract void receiveFireAttack(int attackDamage);
    public abstract void receiveWaterAttack(int attackDamage);
    public abstract void receiveElectricAttack(int attackDamage);
    public abstract void receiveFightingAttack(int attackDamage);
    public abstract void receivePsychicAttack(int attackDamage);


    public int getAttackDamage(int attackNum) throws ArrayIndexOutOfBoundsException {
        return attacks[attackNum - 1].getDamage();
    }

    public void dead() {
        getTrainer().swapNextNotDead();
    }

    public Trainer getTrainer() {
        return trainer;
    }
}
