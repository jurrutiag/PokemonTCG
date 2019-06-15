package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;

public interface IObjectCard extends ITrainerCard {
    public void executeEffect();
    public void setPokemon(IPokemonCard pokemonCard);
    public IPokemonCard getPokemon();
}
