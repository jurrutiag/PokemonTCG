package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;

import java.util.HashMap;

public class PokemonSearch extends AbstractCardVisitor {

    private HashMap<Integer, IPokemonCard> pokemons = new HashMap<>();
    private HashMap<Integer, IBasicPokemon> basicPokemons = new HashMap<>();
    private HashMap<Integer, IPhase1Pokemon> phase1Pokemons = new HashMap<>();
    private HashMap<Integer, IPhase2Pokemon> phase2Pokemons = new HashMap<>();
    private int index = -1;

    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {
        pokemons.put(index, pokemonCard);
    }

    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
        basicPokemons.put(index, basicPokemon);
    }

    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) {
        phase1Pokemons.put(index, phase1Pokemon);
    }

    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) {
        phase2Pokemons.put(index, phase2Pokemon);
    }

    @Override
    public void visitCard(ICard card) {
        this.index++;
    }

    public boolean isPokemon() {
        return !pokemons.isEmpty();
    }

    public boolean isAnyBasic() {
        return !basicPokemons.isEmpty();
    }

    public HashMap<Integer, IPokemonCard> getPokemons() {
        return this.pokemons;
    }
}
