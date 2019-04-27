package cc3002.tarea1;

/**
 * Card interface gives common methods to cards.
 *
 * @author Juan Urrutia
 */
public interface Card {
    /**
     * Checks if the card can be used as an active pokemon, in this case,
     * the card is an Energy so the answer is always no.
     *
     * @return Boolean value that represents if the card is selectable as active pokemon.
     */
    public boolean isActivelySelectable();
}