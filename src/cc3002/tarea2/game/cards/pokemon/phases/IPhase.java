package cc3002.tarea2.game.cards.pokemon.phases;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.IPokemonCard;

public interface IPhase {
    public IPokemonCard getPokemon();

    public void setPokemonCard(IPokemonCard pokemon);

    public boolean bePlayedBy(Trainer trainer);
}
