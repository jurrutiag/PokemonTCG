package cc3002.tarea2.game.states;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;

import java.util.HashMap;

public class WaitingForActivePokemonClick extends WaitingState {

    private HashMap<Integer, IPokemonCard> pokemons;

    public WaitingForActivePokemonClick(State prevState, HashMap<Integer, IPokemonCard> pokemons) {
        super(prevState);
        this.pokemons = pokemons;
    }

    @Override
    public void singleButtonClick() {
        this.getController().getPlayingGui().selectPokemon(pokemons);
        this.getController().getState().playerPlayed();
    }

    @Override
    public void playerPlayed() {
        this.getController().setState(new WaitingForBenchSelection(this.getPrevState(), 5));
    }

    @Override
    public void initialize() {
        this.getController().getPlayingGui().showSelectActiveButton();
    }

}
