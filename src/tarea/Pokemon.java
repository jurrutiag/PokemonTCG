package tarea;

import java.io.PrintStream;

public abstract class Pokemon implements Carta {

    private int hp;
    private Entrenador entrenador;
    private Attack[] attacks = new Attack[4];

    public Pokemon(int hp, Attack[] attacks, Entrenador entrenador) {
        this.hp = hp;
        this.attacks = attacks;
        this.entrenador = entrenador;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public boolean esSeleccionableActiva() {
        return true;
    }

    public void printCardInfo(PrintStream out) {
        out.printf("Nombre: %s, id: %d, Vida: %d\n", this.getName(), this.getId(), this.getHp());
    }

    public void bajarHpEn(int damage) {
        if (damage > 0) {
            hp -= damage;
        }
        if (hp <= 0) {
            hp = 0;
            this.dead();
        }
    }

    public abstract void attack(int attackNum, Entrenador contrincante);

    public abstract int getId();

    public abstract void recibeAtaquePlanta(int attackDamage);
    public abstract void recibeAtaqueFuego(int attackDamage);
    public abstract void recibeAtaqueAgua(int attackDamage);
    public abstract void recibeAtaqueRayo(int attackDamage);
    public abstract void recibeAtaqueLucha(int attackDamage);
    public abstract void recibeAtaquePsiquico(int attackDamage);


    public int getAttackDamage(int attackNum) {
        return attacks[attackNum].getDamage();
    }

    public void listarAtaques(PrintStream out, String format) {
        for (int i = 0; i < attacks.length; i++) {
            out.printf(format, String.format("%d -- %s\n", i + 1, attacks[i].getName()));
        }
    }

    public void dead() {
        getEntrenador().getJuego().getOutput().printf("\t%s de P%s ha muerto...\n", this.getName(), this.getEntrenador().getJuego().getTurno());
    }

    private Entrenador getEntrenador() {
        return entrenador;
    }
}
