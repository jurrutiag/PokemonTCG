package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Class representing a psychic energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class PsychicEnergyCard extends AbstractEnergyCard {


    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "PsychicEnergyCard";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitPsychicEnergyCard(this);
    }
}
