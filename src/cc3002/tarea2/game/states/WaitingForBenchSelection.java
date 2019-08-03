package cc3002.tarea2.game.states;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.PokemonSearch;

import java.util.HashMap;

public class WaitingForBenchSelection extends WaitingState {

    private int pokNum;
    private HashMap<Integer, IPokemonCard> pokemons;

    public WaitingForBenchSelection(State prevState, int pokNum) {
        super(prevState);
        this.pokNum = pokNum;
    }

    @Override
    public void singleButtonClick() {
        this.getController().getPlayingGui().askBenchPokemons(pokNum, this.pokemons);
    }

    @Override
    public void playerPlayed() {
        if (pokNum > 0)
            this.getController().setState(new WaitingForBenchSelection(this.getPrevState(), pokNum - 1));
        else
            this.getController().setState(new WaitingForDrawPrizeCard(this.getPrevState()));
    }

    @Override
    public void noMoreOptions() {
        this.getController().getPlayingGui().noMoreBenchPokemons();
        this.getController().setState(new WaitingForDrawPrizeCard(this.getPrevState()));
    }

    @Override
    public void cancelButtonClick() {
        this.getController().setState(new WaitingForDrawPrizeCard(this.getPrevState()));
    }

    @Override
    public void initialize() {
        try {
            PokemonSearch pokemonVisitor;
            pokemonVisitor = this.getController().getSearchPokemonOnHandVisitor();
            pokemons = pokemonVisitor.getPokemons();
            if (pokemons.isEmpty() || !pokemonVisitor.isAnyBasic()) {
                this.getController().getState().noMoreOptions();
                return;
            }
            this.getController().getPlayingGui().showSelectBenchPokemon(pokNum);
        } catch (PlayCardException e) {

        }
    }

}
