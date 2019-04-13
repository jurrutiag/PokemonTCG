package tarea;

public class Energia extends Carta {

    public Energia() {

    }

    public Energia(String name) {
        super(name);
    }

    @Override
    public boolean esSeleccionableActiva() {
        return false;
    }
}
