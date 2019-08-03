package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.exceptions.PokemonWithoutPreevolutionPlayedException;

public class PhaseVisitor extends AbstractCardVisitor {

    private String phase;

    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
        phase = "Basic";
    }

    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) throws PokemonWithoutPreevolutionPlayedException {
        phase = "Phase 1";
    }

    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) throws PokemonWithoutPreevolutionPlayedException {
        phase = "Phase 2";
    }

    public String getPhase() {
        return this.phase;
    }
}
