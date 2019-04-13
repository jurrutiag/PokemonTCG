package tarea;

import java.io.PrintStream;

public abstract class Pokemon implements Carta {

    private int hp;
    private Attack[] attacks = new Attack[4];

    public Pokemon(int hp, Attack[] attacks) {
        this.hp = hp;
        this.attacks = attacks;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public boolean esSeleccionableActiva() {
        return true;
    }

    public void printPokemonInfo(int hp, int id, String name, PrintStream out) {
        out.printf("Nombre: %s, id: %d, Vida: %d\n", name, id, hp);
    }

    public void bajarHpEn(int damage) {
        if (damage > 0) {
            hp -= damage;
        }
    }

    public abstract void attack(int attackNum, Pokemon pokemonContrario);

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

    public void listarAtaques(PrintStream out) {
        for (int i = 0; i < attacks.length; i++) {
            out.printf("%d -- %s\n", i + 1, attacks[i].getName());
        }
    }
}
