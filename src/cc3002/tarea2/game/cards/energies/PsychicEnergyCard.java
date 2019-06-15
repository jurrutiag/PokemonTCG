package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.visitor.ICardVisitor;

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

    @Override
    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitPsychicEnergyCard(this);
    }
}
