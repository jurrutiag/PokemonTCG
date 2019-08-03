package cc3002.tarea2.game.states;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.PokemonSearch;

import java.util.HashMap;

public class WaitingForDraw7Cards extends WaitingState {

    HashMap<Integer, IPokemonCard> pokemons = new HashMap<>();

    public WaitingForDraw7Cards(State prevState) {
        super(prevState);
    }

    @Override
    public void singleButtonClick() throws PlayCardException {
        this.getController().drawInitialCards();

        PokemonSearch pokemonSearch = this.getController().getSearchPokemonOnHandVisitor();
        this.pokemons = pokemonSearch.getPokemons();

        if (pokemons.isEmpty() || !pokemonSearch.isAnyBasic()) {
            if (getController().getPlayingGui().alertNoPokemon(getController().getOpponent().getName())) {
                getController().getOpponent().drawCard();
            }
            getController().handToDeck();
            this.getController().getState().stopWaiting();
            this.getController().getState().waitPlayer();
        } else {
            this.getController().getState().playerPlayed();



//            this.getController().getPlayingGui().selectPokemon(pokemons);
//            askBenchPokemons();
//            drawPrizeCards();
//            this.getController().getState().stopWaiting();
//            this.getController().getState().nextTurn();
        }
    }

    @Override
    public void playerPlayed() {
        this.getController().setState(new WaitingForActivePokemonClick(this.getPrevState(), pokemons));
    }

    @Override
    public void initialize() {
        this.getController().getPlayingGui().showDraw7CardsButton();
        this.getController().getPlayingGui().commandDraw();
    }
}
