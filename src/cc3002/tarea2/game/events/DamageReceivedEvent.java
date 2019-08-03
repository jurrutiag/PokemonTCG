package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class DamageReceivedEvent extends AbstractEvent {

    private int damage;
    private IPokemonCard pokemonCard;

    public DamageReceivedEvent(int damage, IPokemonCard pokemonCard) {
        this.damage = damage;
        this.pokemonCard = pokemonCard;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitDamageReceivedEvent(this);
    }

    public int getDamage() {
        return damage;
    }

    public IPokemonCard getPokemonCard() {
        return pokemonCard;
    }
}
