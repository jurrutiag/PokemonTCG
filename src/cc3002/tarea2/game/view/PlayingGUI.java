package cc3002.tarea2.game.view;

import cc3002.tarea2.game.ISelectableWithInfo;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.controller.GameController;
import cc3002.tarea2.game.events.*;
import cc3002.tarea2.game.exceptions.*;
import cc3002.tarea2.game.states.TurnState;
import cc3002.tarea2.game.view.FXMLControllers.PlayingView;
import cc3002.tarea2.game.view.FXMLControllers.SceneAlert;
import cc3002.tarea2.game.view.FXMLControllers.SelectElement;
import cc3002.tarea2.game.view.FXMLControllers.YesNoAlert;
import cc3002.tarea2.game.visitor.IEventVisitable;
import cc3002.tarea2.game.visitor.IEventVisitor;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;

public class PlayingGUI extends Observable implements IEventVisitor, Observer, IGUI {

    public static String pokemonWithoutPreevError = "You can't play a pokemon without it's preevolution. Select again...";


    private ListView<String> text;
    private boolean showDrawn = true;
    private GameController controller;
    private HBox buttons;
    private PlayingView playingView;

    public PlayingGUI(Stage primaryStage, GameController controller, PlayingView playingView) {

        this.playingView = playingView;

        this.controller = controller;

        controller.setGUI(this);
        playingView.setGUI(this);

        controller.getTrainerPlaying().addObserver(this);
        controller.getOpponent().addObserver(this);

    }

    public void start() {
        controller.startGame();
    }

    public Pane getButtonPane() {
        return this.playingView.getButtonPane();
    }

    public GameController getController() {
        return this.controller;
    }

    public void notifyEvent(IEventVisitable event) {
        setChanged();
        notifyObservers(event);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof IEventVisitable) {
            ((IEventVisitable) arg).accept(this);
        }
    }

    public void addText(String str) {
        this.playingView.getMainView().getItems().add(str);
        this.playingView.getMainView().scrollTo(this.playingView.getMainView().getItems().size());
    }

    public void addTitleText(String str) {
        addSubtitleText(str);
        addText("");
    }

    public boolean alertNoPokemon(String playerName) {
        return yesNoAlert("Message for player " + playerName, playerName + ", your opponent didn't get any Pokemon card, do you want to draw a card?");
    }

    public boolean yesNoAlert(String title, String label) {
        YesNoAlert ynAlert = new YesNoAlert(title, label);
        ynAlert.execute();
        return ynAlert.getOption();
    }

    @Override
    public void visitAttackEvent(AttackEvent attackEvent) {
        this.addText("You Attacked.");
    }

    @Override
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent) {

    }

    @Override
    public void visitEnergyCardPlayedEvent(EnergyCardPlayedEvent energyCardPlayedEvent) {

    }

    @Override
    public void visitOnceATurnAbilityEffect(OnceATurnAbilityEffect onceATurnAbilityEffect) {

    }

    @Override
    public void visitInstantAbilityPlayedEvent(InstantAbilityPlayedEvent instantAbilityPlayedEvent) {

    }

    @Override
    public void visitStadiumCardPlayed(StadiumCardPlayedEvent stadiumCardPlayed) {

    }

    @Override
    public void visitSupportCardPlayed(SupportCardPlayedEvent supportCardPlayedEvent) {

    }


    @Override
    public void visitCardDrawnEvent(CardDrawnEvent cardDrawnEvent) {
        if (this.showDrawn) {
            this.addText(cardDrawnEvent.getTrainer().getName() + " Drew " + cardDrawnEvent.getCard().getName());
        }
    }

    @Override
    public void visitDamageReceivedEvent(DamageReceivedEvent damageReceivedEvent) {
        addText("Pokemon " + damageReceivedEvent.getPokemonCard().getName() + " of player " + damageReceivedEvent.getPokemonCard().getTrainer().getName() + " received " + damageReceivedEvent.getDamage() + " damage.");
    }

    @Override
    public void visitPokemonDiedEvent(PokemonDiedEvent pokemonDiedEvent) {
        addText("Pokemon " + pokemonDiedEvent.getPokemon() + " of player " + pokemonDiedEvent.getPokemon().getTrainer().getName() + " died.");
    }


    public void selectAbility() {
        try {
            IAbility selectedAbility = (IAbility) selectElement(this.getController().getAbilities(), "Select Ability", "Select an ability to use:");

            int index = this.getController().getAbilities().indexOf(selectedAbility);

            this.getController().selectActivePokemonAbility(index);
            this.getController().useActivePokemonAbility();
        } catch (NoElementChosenException e) {
            // Nothing is done.
        } catch (OnceATurnAbilityPlayedException e) {
            alertError("This ability was already used in this turn. Try another...");
            selectAbility();
        } catch (AbilityException e) {
            alertError("You don't have enough energies to perform the ability...");
        }
    }

    public ISelectableWithInfo selectElement(ArrayList<? extends ISelectableWithInfo> elements, String title, String label) throws NoElementChosenException {
        SelectElement selectElement = new SelectElement(elements, title, label);
        selectElement.execute();

        if (selectElement.wasClosed()) {
            throw new NoElementChosenException();
        }

        return selectElement.getElementSelected();
    }

    public void useCard() {
        try {
            ICard selectedCard = (ICard) selectElement(this.getController().getPlayerHand(), "Select a Card", "Select a card from your hand:");

            int index = this.getController().getPlayerHand().indexOf(selectedCard);
            this.getController().selectCard(index);
            this.getController().playCard();
        } catch (NoElementChosenException e) {
            // Nothing is done.
        } catch (EnergyCardAlreadyUsedException e) {
            alertError("Energy card already used in this turn, try another...");
            useCard();
        } catch (SupportCardAlreadyUsedException e) {
            alertError("Support card already used in this turn, try another...");
            useCard();
        } catch (PokemonWithoutPreevolutionPlayedException e) {
            alertError("You can't play a pokemon without it's preevolution. Select again...");
            useCard();
        } catch (PlayCardException e) {
            alertError("Can't play card, select another...");
            useCard();
        }
    }

    public void showBench(ArrayList<IPokemonCard> pokemonCards) {
        for (IPokemonCard pokemonCard : pokemonCards) {
            this.addText(tabbedText(pokemonInfo(pokemonCard), 1));
        }
    }

    public String pokemonInfo(IPokemonCard pokemonCard) {
        return "Name: " + pokemonCard.getName() + " -- HP: " + pokemonCard.getHp();
    }

    public void showInfo() {
        this.addSubtitleText("You are player " + this.controller.getPlayerName());
        this.addSubtitleText("Your hand is :");
        this.showHand();
        this.addSubtitleText("Your bench is :");
        this.showBench(this.controller.viewPlayerBench());
        this.addSubtitleText("Your opponent's bench is :");
        this.showBench(this.controller.viewOpponentBench());
        this.playingView.getMainView().getItems();
    }

    private void addSubtitleText(String s) {
        this.addText("-- " + s);
    }

    private void showHand() {
        for (ICard card : this.getController().getPlayerHand()) {
            this.addText(this.tabbedText(card.getName(), 1));
        }
    }

    private String tabbedText(String text, int i) {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < i; j++) {
            str.append("\t");
        }
        return str.toString() + text;
    }

    public void pass() {
        //this.addTitleText(this.controller.getPlayerName() + ", you passed...");
        this.controller.nextTurn();
    }


    public void startedPlaying(String playerName) {
        addTitleText(playerName + " is Playing:");

        //TODO: set start turn buttons.
    }

    public void hideBottomButtons() {
        this.playingView.hideAllButtons();
    }

    public void startTurnButtons() {
        this.playingView.showTurnButtons();
    }

    public void showDraw7CardsButton() {
        this.playingView.setSingleButton("Draw 7 cards.");
    }

    public void waitingState() {
        addSubtitleText("Waiting for " + this.getController().getPlayerName() + "...");
    }

    public void setShowDrawn(boolean toggle) {
        this.showDrawn = toggle;
    }

    public int getHPokemonMapIndex(HashMap<Integer, IPokemonCard> pokemons, IPokemonCard pokemon) {
        for (Map.Entry<Integer, IPokemonCard> entry : pokemons.entrySet()) {
            if (Objects.equals(pokemon, entry.getValue())) {
                return entry.getKey();
            }
        }

        return -1;
    }

    @Override
    public void selectPokemon(HashMap<Integer, IPokemonCard> pokemonCards) {
        try {
            IPokemonCard selectedCard = (IPokemonCard) selectElement(new ArrayList<ICard>(pokemonCards.values()), "Select Active Pokemon", "Select active pokemon from your hand:");
            ;
            this.controller.selectCard(getHPokemonMapIndex(pokemonCards, selectedCard));
            this.controller.playCard();
            this.controller.selectBenchPokemon(this.controller.viewPlayerBench().size() - 1);
            this.controller.changeActivePokemon();
            activePokemonSelected((IPokemonCard) selectedCard);

        } catch (NoElementChosenException e) {
            alertError("You have to select an active pokemon.");
            selectPokemon(pokemonCards);
        } catch (PokemonWithoutPreevolutionPlayedException e) {
            alertError(PlayingGUI.pokemonWithoutPreevError);
            selectPokemon(pokemonCards);
        } catch (PlayCardException e) {
            alertError("Error, can't select a non pokemon card. Report to creator...");
            selectPokemon(pokemonCards);
        }
    }

    @Override
    public void commandDraw() {
        addSubtitleText(this.getController().getPlayerName() + " please draw 7 cards...");
    }

    @Override
    public void askBenchPokemons(int n, HashMap<Integer, IPokemonCard> pokemons) {
        try {
            IPokemonCard selectedPokemon;
            selectedPokemon = (IPokemonCard) selectElement(new ArrayList<>(pokemons.values()), "Select bench pokemons.", n + " Pokemons left to select.");
            this.getController().selectCard(getHPokemonMapIndex(pokemons, selectedPokemon));
            this.getController().playCard();
            this.getController().getState().playerPlayed();
        } catch (NoElementChosenException e) {
            boolean answer = yesNoAlert("Are you sure?", "Are you sure that you don't want more pokemons on the bench?");
            if (!answer)
                askBenchPokemons(n, pokemons);
        } catch (PokemonWithoutPreevolutionPlayedException e) {
            alertError(PlayingGUI.pokemonWithoutPreevError);
            askBenchPokemons(n, pokemons);
        } catch (PlayCardException e) {

        }
    }

    @Override
    public void showSelectActiveButton() {
        this.playingView.setSingleButton("Select active pokemon");
    }

    @Override
    public void showSelectBenchPokemon(int i) {
        this.playingView.setSingleButton("Select Bench Pokemons (" + i + ") left");
        this.playingView.showCancelButton();
    }

    @Override
    public void showSelectPrizeCardsButton() {
        this.playingView.setSingleButton("Draw Prize Cards");
    }

    @Override
    public void noMoreBenchPokemons() {
        alertError("No more bench pokemons to select.");
    }

    @Override
    public void endTurn(TurnState turnState) {
        addTitleText(turnState.getController().getPlayerName() + " ended the turn");
    }

    private void alertError(String errorText) {
        SceneAlert alert = new SceneAlert("Alert", errorText);
        alert.execute();
    }

    public void activePokemonSelected(IPokemonCard pokemonCard) {
        addText(this.getController().getPlayerName() + " selected " + pokemonCard.getName() + " as active.");
    }
}
