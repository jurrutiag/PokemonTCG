package cc3002.tarea2.game.searching;

/**
 * Interface made for searching.
 *
 * @author Juan Urrutia
 */
public interface ISearchCardMethod<T> {
    /**
     * Matches an object according to a search method.
     * @param element The object to be matched.
     * @return Returns true if the object matched.
     */
    public boolean match(T element);
}
