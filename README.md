# Pokemon TCG

This project consists in a Pokemon Trading Card game where a trainer faces another trainer each with cards consisting on energies and pokemons. Trainers can use their energy cards to allow their pokemons to cast their abilities on the opponent. The objective of the game is to beat the opponent's pokemons. The creation of the game started as a homework for CC3002 at Universidad de Chile.

## Description

The game has a trainer class, which consists on one player who has a hand with unlimited size that can hold cards of two types, Pokemons and Abilities, a bench that can hold up to 5 pokemons and 1 extra active pokemon that in this implementation will be considered as the first one on the bench, and a prize stack which can hold up to 6 prize cards. The cards are in the trainer's deck. The deck starts with 60 cards and the trainer can draw top or bottom cards to add to the hand or to the prizes stack. The trainer also has a discard pile, a place where all cards that are not used anymore go. The trainer can bind energies to the bench pokemons to make them able to use their abilities on the opponent, the energies are of 6 types:

```
1. Grass
2. Water
3. Fire
4. Fighting
5. Psychic
6. Electric
```

And they are put toghether in an EnergySet object that contains the count of each energy type and has methods for adding or removing Energies or EnergySets and comparing EnergySets.

Each trainer has an opponent and is able to cast an ability in the ability set of his Pokemon. Pokemon abilities can be activated by the player or by a special reason. An attack is a special type of ability, one that has a base damage appart from having a possible effect. Each attack has an energy cost in the form of EnergySet, a description, a damage and a name, so with the attacks a trainer can deal damage to the active Pokemon of the opponent.

Each Pokemon has a type, and each type has a resistance and a weakness, so if the trainer decides to attack his opponent, the damage dealt to the active Pokemon of the opponent will depend on it's type resistance and weakness, if the Pokemon that receives the attack is resistant to the attacking pokemon's type, then it receives 30 points less damage than the actual attack damage. If the Pokemon that receives the attack is weak to the attacking Pokemon's type, then it receives twice the actual attack damage. The type table showing the resistances and weaknesses is the following one:

| Type | Weakness | Resistance |
| ---- |:--------:| ----------:|
| Grass | Fire | Water |
| Fire | Water |  |
| Water | Grass, Electric | Fighting |
| Electric | Fighting |  |
| Fighting | Psychic, Grass |  |
| Psychic | Psychic | Fighting |

To implement the attack resistances and weaknesses, double dispatch was used, then, each Pokemon type is responsible for the ammount of  damage it receives from each type, therefore, the weakness and resistance caracteristic of each type is inside these methods.

Pokemons also have an evolution phase, they can be basic, phase 1 or phase 2, so in order to play a phase 1 or phase 2 pokemon, their preevolution has to be in the bench, only the basic pokemon can be played directly. The preevolution is identified by the id.

A Pokemon has an ammount of hp (and max hp), an id, a name, an abilities array, an object placeholder and a trainer. The hp represents the ammount of health left, if it reaches zero, then the Pokemon is dead and is eliminated from the bench, also hp damage counters are defined as 10 points less on the pokemon's health. The id represents the unique identifier for each Pokemon. The name of the Pokemon can be repeated in different Pokemons (that is Pokemons with different id's). The abilities array can hold up to four abilities. The trainer is the owner of the Pokemon.

There are also what is called trainer cards. 3 types of cards that can be played by the trainer. The 3 types are:

```
1. Object cards
2. Stadium cards
3. Support cards
```

Object cards can be played by the trainer on any pokemon and they can have an instant effect or be binded to the pokemon. If an object card is binded to the pokemon, then there can be no other object card binded after the first.

Stadium cards have an effect on the game. They affect every card on the game and there can be only one played at a time. 

Support cards are instant effect cards, they are played and discarded. Support cards testing is in the TrainerCardTest. 

The controller is the entity that has the logic of turns and rules regarding turns in the game. The controller was implemented as an observer visitor, who receives events (notifications) from the trainer and using visitor pattern executes different actions. The testing regarding controller is in the GameControllerTest class.

Implemented abilities and trainer cards are the following:

Pokemon abilities implemented were Heal and Wing Buzz, both tested on the AbilityTest class and on GameControllerTest tested the functionality. The implemented attack was Electric Shock, tested on AttackTest class.

The tests for object cards are on the class TrainerCardTest of the package cc3002.tarea2.test, in this class, only effects were tested. There are two object cards implemented: Exp. Share and Potion. The tests regarding turns and overall functionality of objects are in the GameControllerTest class.

The tests for stadium cards are on TrainerCardTest also, and there is only Lucky Stadium card implemented. There is also testing on functionality with turns on the GameControllerTest class.

The implemented support cards are Professor Cozmo Discovery and Professor Juniper both tested in TrainerCardTest class. The functionality regarding turns is tested on the GameControllerTest.

## Getting Started

Download the project files and build the whole project on java and build the artifacts, then run the jar file on the out/artifacts/cc3002_tarea2_jar directory.


## Running the tests

To run the tests of the program, open the project on an IDE, then right click on the Test folder and click on run All Tests.

## Built With

* [Intellij](https://www.jetbrains.com/idea/) - The IDE used

## Author

* **Juan Urrutia** - [Jurrutiag](https://github.com/jurrutiag)
