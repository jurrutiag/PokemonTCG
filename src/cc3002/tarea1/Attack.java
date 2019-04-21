package cc3002.tarea1;

public interface Attack extends Ability {
    public int getDamage();
    public String getDescription();
    public EnergySet getCost();
}
