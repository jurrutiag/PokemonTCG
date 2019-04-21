package cc3002.tarea1;

import java.io.PrintStream;

public abstract class Energy implements Card {

    @Override
    public boolean isActivelySelectable() {
        return false;
    }

    public abstract void addTo(EnergySet energies);

}
