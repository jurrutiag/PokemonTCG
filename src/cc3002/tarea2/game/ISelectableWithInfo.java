package cc3002.tarea2.game;

import cc3002.tarea2.game.exceptions.PlayCardException;

import java.util.ArrayList;

public interface ISelectableWithInfo {
    public ArrayList<String> getInfo() throws PlayCardException;
    public String getName();
}
