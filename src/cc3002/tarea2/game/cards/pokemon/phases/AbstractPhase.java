package cc3002.tarea2.game.cards.pokemon.phases;

import cc3002.tarea2.game.cards.IPokemonCard;

public abstract class AbstractPhase implements IPhase {
    private IPokemonCard pokemon;

    @Override
    public void setPokemonCard(IPokemonCard pokemon) {
        this.pokemon = pokemon;
    }

    public IPokemonCard getPokemon() {
        return pokemon;
    }

}
