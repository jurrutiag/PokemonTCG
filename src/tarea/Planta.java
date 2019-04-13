package tarea;

public abstract class Planta extends Pokemon {

    public Planta(int i, Attack[] attacks) {
        super(i, attacks);
    }

    @Override
    public void attack(int attackNum, Pokemon pokemonContrario) {
        pokemonContrario.recibeAtaquePlanta(this.getAttackDamage(attackNum));
    }
    public void recibeAtaquePlanta(int attackDamage) {
        this.bajarHpEn(attackDamage);
    }
    public void recibeAtaqueFuego(int attackDamage) {
        this.bajarHpEn(attackDamage * 2);
    }
    public void recibeAtaqueAgua(int attackDamage) {
        this.bajarHpEn(attackDamage - 30);
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
