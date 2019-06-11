package cc3002.tarea2.game.cards.energies;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.ICardVisitor;

/**
 * Class representing a grass energy for the Pokemons to be binded allowing them to cast abilities.
 *
 * @author Juan Urrutia
 */
public class GrassEnergyCard extends AbstractEnergyCard {


    public GrassEnergyCard(Trainer trainer) {
        super(trainer);
    }

    public GrassEnergyCard() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "GrassEnergyCard";
    }

    @Override
    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitGrassEnergyCard(this);
    }
}
