package cc3002.tarea1;

import java.io.PrintStream;

public interface Carta {
    public String getName();
    public boolean esSeleccionableActiva();

    void printCardInfo(PrintStream out);
}