package cc3002.tarea2.game.cards.pokemon.playing_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.implemented_attacks.playing_attacks.MegaKickAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.playing_attacks.ScratchAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.phase2.FirePhase2Pokemon;

public class Charizard extends FirePhase2Pokemon {
    /**
     * Creates a fire type phase 2 pokemon.
     *
     * @param hp        The initial hp of the AbstractPokemonCard.
     * @param id        The pokemon id
     * @param name      The pokemon name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer   The trainer owner of the AbstractPokemonCard.
     */
    public Charizard(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    public Charizard(Trainer trainer) {
        this(70, 6, "Charizard", new IAbility[] {new ScratchAttack(), new MegaKickAttack()}, trainer);
    }

    @Override
    public int getPreevolutionId() {
        return 5;
    }
}
