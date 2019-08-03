package cc3002.tarea2.game.cards.pokemon.playing_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.implemented_attacks.playing_attacks.MegaKickAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.playing_attacks.ScratchAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.GrassPhase2Pokemon;

public class Venusaur extends GrassPhase2Pokemon {
    /**
     * Creates a grass type phase 2 pokemon.
     *
     * @param hp        The initial hp of the AbstractPokemonCard.
     * @param id        The pokemon id
     * @param name      The pokemon name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer   The trainer owner of the AbstractPokemonCard.
     */
    public Venusaur(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    public Venusaur(Trainer trainer) {
        this(80, 3, "Venusaur", new IAbility[] {new ScratchAttack(), new MegaKickAttack()}, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 2;
    }
}
