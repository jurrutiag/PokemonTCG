package cc3002.tarea2.game.cards.pokemon.phases;

import cc3002.tarea2.game.Trainer;

public class EvolvedPhase extends AbstractPhase {

    private int preevolutionId;

    public EvolvedPhase(int preevolutionId) {
        this.preevolutionId = preevolutionId;
    }

    @Override
    public boolean bePlayedBy(Trainer trainer) {
        return trainer.playPhasePokemon(this);
    }

    public int getPreevolutionId() {
        return preevolutionId;
    }
}
