package cc3002.tarea2.game.cards.pokemon.phases;

import cc3002.tarea2.game.Trainer;

public class BasicPhase extends AbstractPhase {

    @Override
    public boolean bePlayedBy(Trainer trainer) {
        return trainer.playBasePokemon(this);
    }
}
