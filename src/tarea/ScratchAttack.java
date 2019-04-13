package tarea;

public class ScratchAttack implements Attack {

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getName() {
        return "ScratchAttack";
    }
}
