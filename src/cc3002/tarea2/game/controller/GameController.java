package cc3002.tarea2.game.controller;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.ExpShareObject;
import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.NullStadiumCard;
import cc3002.tarea2.game.events.*;
import cc3002.tarea2.game.exceptions.AbilityException;
import cc3002.tarea2.game.exceptions.OnceATurnAbilityPlayedException;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.searching.methods.SearchObjectOwner;
import cc3002.tarea2.game.states.PlayerOneSetUp;
import cc3002.tarea2.game.states.State;
import cc3002.tarea2.game.view.IGUI;
import cc3002.tarea2.game.view.NullGUI;
import cc3002.tarea2.game.view.PlayingGUI;
import cc3002.tarea2.game.visitor.IEventVisitable;
import cc3002.tarea2.game.visitor.IEventVisitor;
import cc3002.tarea2.game.visitor.card.CanUseVisitor;
import cc3002.tarea2.game.visitor.card.PokemonSearch;
import cc3002.tarea2.game.visitor.stadium.PlayOnceATurnVisitor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Class representing the game controller, entity in charge of handling the game turns.
 *
 * @author Juan Urrutia
 */
public class GameController implements Observer, IEventVisitor {

    private IGUI playingGui = new NullGUI();

    private State state = new State();

    /**
     * A list of the trainers playing
     */
    private Trainer[] trainers;


    /**
     * The current stadium card being played.
     */
    private IStadiumCard stadiumCard;

    /**
     * Visitor used for allowing card plays.
     */
    private CanUseVisitor canUseVisitor;

    /**
     * Array of abilities that are executed once a turn.
     */
    private ArrayList<IAbility> onceATurnAbilitiesPlayed = new ArrayList<>();

    /**
     * Game Controller constructor.
     * @param trainers The trainers that will play.
     *
     */
    public GameController(Trainer[] trainers, State state) {
        trainers[0].setOpponent(trainers[1]);
        trainers[1].setOpponent(trainers[0]);
        this.trainers = trainers;
        for (Trainer trainer : this.trainers) {
            trainer.addObserver(this);
        }
        this.setState(state);

        this.stadiumCard = new NullStadiumCard();

        canUseVisitor = new CanUseVisitor();
    }

    public GameController(Trainer[] trainers) {
        this(trainers, new PlayerOneSetUp());
    }

    public GameController() {
        this(new Trainer[] {new Trainer(), new Trainer()});
    }

    public void setState(State state) {
        this.state.endState();
        this.state = state;
        this.state.setController(this);
        this.state.initialize();
    }

    public State getState() {
        return this.state;
    }

    public void setGUI(PlayingGUI playingGui) {
        this.playingGui = playingGui;
    }

    public IGUI getPlayingGui() {
        return this.playingGui;
    }

    public void handToDeck() {
        this.getTrainerPlaying().handToDeck();
    }

    /**
     *
     * @return Returns the current playing trainer.
     */
    public Trainer getTrainerPlaying() {
        return trainers[this.getTurn()];
    }

    /**
     *
     * @return Returns the current playing trainer's opponent.
     */
    public Trainer getOpponent() {
        return trainers[(this.getTurn() == 0 ? 1 : 0)];
    }

    public int getOpponentTurn() {
        return this.getTurn() == 0 ? 1 : 0;
    }

    /**
     *
     * @return Returns the visitor to allow card playing.
     */
    public CanUseVisitor getCanUseVisitor() {
        return canUseVisitor;
    }

    /**
     * Makes the playing trainer draw a card.
     */
    public void drawCard() {
        this.getTrainerPlaying().drawCard();
    }

    public void drawInitialCards() {
        this.getTrainerPlaying().drawTopCards(7);
    }

    /**
     * Makes the playing trainer select a card.
     * @param index The index in the hand of the card.
     */
    public void selectCard(int index) {
        this.getTrainerPlaying().selectHandCard(index);
    }

    /**
     * Makes the trainer play the selected card.
     */
    public void playCard() throws PlayCardException {
        //TODO: add try catch.
        this.getTrainerPlaying().getSelectedCard().accept(canUseVisitor);
        this.getTrainerPlaying().playCard();
    }

    /**
     * Discards the selected card from the trainer playing.
     */
    public void discardSelected() {
        this.getTrainerPlaying().discardSelectedFromHand();
    }

    /**
     *
     * @return Returns the player's hand.
     */
    public ArrayList<ICard> getPlayerHand() {
        return this.getTrainerPlaying().getHand();
    }

    /**
     *
     * @return Returns the player's bench.
     */
    public ArrayList<IPokemonCard> viewPlayerBench() {
        return this.getTrainerPlaying().getBench();
    }

    /**
     *
     * @return Returns the opponent's bench.
     */
    public ArrayList<IPokemonCard> viewOpponentBench() {
        return this.getOpponent().getBench();
    }

    /**
     * Selects an ability for the active pokemon to use.
     * @param abilityIndex The ability index to be selected.
     */
    public void selectActivePokemonAbility(int abilityIndex) {
        this.getTrainerPlaying().selectAbility(abilityIndex);
    }

    /**
     * Makes the trainer use the active pokemon's selected ability.
     */
    public void useActivePokemonAbility() throws AbilityException {
        if (!this.onceATurnAbilitiesPlayed.contains(this.getTrainerPlaying().getSelectedAbility())) {
            this.getTrainerPlaying().useAbility();
        } else {
            throw new OnceATurnAbilityPlayedException();
        }
    }

    /**
     *
     * @return Returns the current stadium card.
     */
    public IStadiumCard getStadiumCard() {
        return this.stadiumCard;
    }

    /**
     * Skips to the next turn.
     */
    public void nextTurn() {
        this.state.nextTurn();
        this.canUseVisitor = new CanUseVisitor();
        this.onceATurnAbilitiesPlayed = new ArrayList<>();
        this.getState().startTurn();
    }

    public int getTurn() {
        return this.state.getTurn();
    }

    public String getPlayerName() {
        return this.getTrainerPlaying().getName();
    }

    /**
     * Starts a new turn.
     */
    public void startTurn() {
        getPlayingGui().startTurnButtons();
        this.getPlayingGui().startedPlaying(this.getPlayerName());
        this.stadiumCard.acceptStadiumVisitor(new PlayOnceATurnVisitor(this.getTrainerPlaying()));
        this.getState().waitPlayer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof IEventVisitable) {
            ((IEventVisitable) arg).accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnergyCardPlayedEvent(EnergyCardPlayedEvent energyCardPlayedEvent) {
        getCanUseVisitor().energyCardUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitOnceATurnAbilityEffect(OnceATurnAbilityEffect onceATurnAbilityEffect) {
        if (!onceATurnAbilitiesPlayed.contains(onceATurnAbilityEffect.getAbility())) {
            onceATurnAbilitiesPlayed.add(onceATurnAbilityEffect.getAbility());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitInstantAbilityPlayedEvent(InstantAbilityPlayedEvent instantAbilityPlayedEvent) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitStadiumCardPlayed(StadiumCardPlayedEvent stadiumCardPlayed) {
        this.stadiumCard = stadiumCardPlayed.getStadiumCard();
    }

    @Override
    public void visitSupportCardPlayed(SupportCardPlayedEvent supportCardPlayedEvent) {
        this.getCanUseVisitor().supportCardUsed();
    }


    public void startGame() {
        this.getState().waitPlayer();
    }



    @Override
    public void visitCardDrawnEvent(CardDrawnEvent cardDrawnEvent) {

    }

    @Override
    public void visitDamageReceivedEvent(DamageReceivedEvent damageReceivedEvent) {

    }

    @Override
    public void visitPokemonDiedEvent(PokemonDiedEvent pokemonDiedEvent) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitAttackEvent(AttackEvent attackEvent) {
        nextTurn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent) {
        ArrayList<IPokemonCard> pokemons = this.getTrainerPlaying().search(new SearchObjectOwner(new ExpShareObject()), this.getTrainerPlaying().getBench());
        executeObjects(pokemons);
    }

    /**
     * Executes objects' effect.
     * @param owners the owners of the objects to be executed.
     */
    private void executeObjects(ArrayList<IPokemonCard> owners) {
        for (IPokemonCard pokemon : owners) {
            pokemon.executeObjectEffect();
        }
    }

    /**
     * Makes the trainer select a bench pokemon.
     * @param i The index of the pokemon.
     */
    public void selectBenchPokemon(int i) {
        this.getTrainerPlaying().selectBenchPokemon(i);
    }

    /**
     * Changes the active pokemon for the one selected in the bench.
     */
    public void changeActivePokemon() {
        this.getTrainerPlaying().swapActivePokemon();
    }

    public ArrayList<IAbility> getAbilities() {
        return new ArrayList<>(this.getTrainerPlaying().getActivePokemon().getAbilities());
    }

    public PokemonSearch getSearchPokemonOnHandVisitor() throws PlayCardException {
        PokemonSearch pokVisitor = new PokemonSearch();

        for (ICard card : getPlayerHand()) {
            card.accept(pokVisitor);
        }

        return pokVisitor;
    }

    public void drawPrizeCards() {

    }
}
