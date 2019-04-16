package cc3002.tarea1.tipos;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Pokemon;

public abstract class Fuego extends Pokemon {
    public Fuego(int i, Attack[] attacks, Entrenador entrenador) {
        super(i, attacks, entrenador);
    }

    @Override
    public void attack(int attackNum, Entrenador contrincante) {
        contrincante.getPokemonActivo().recibeAtaqueFuego(this.getAttackDamage(attackNum));
    }
    public void recibeAtaquePlanta(int attackDamage) {
        this.bajarHpEn(attackDamage);
    }
    public void recibeAtaqueFuego(int attackDamage) {
        this.bajarHpEn(attackDamage);
    }
    public void recibeAtaqueAgua(int attackDamage) {
        this.bajarHpEn(attackDamage * 2);
    }
    public void recibeAtaqueRayo(int attackDamage) {
        this.bajarHpEn(attackDamage);
    }
    public void recibeAtaqueLucha(int attackDamage) {
        this.bajarHpEn(attackDamage);
    }
    public void recibeAtaquePsiquico(int attackDamage) {
        this.bajarHpEn(attackDamage);
    }
}
