# Tarea 1 CC3002

This project consists in a Pokemon Trading Card game where a trainer faces another trainer each with cards consisting on energies and pokemons. Trainers can use their energy cards to allow their pokemons to cast their abilities on the opponent. The objective of the game is to beat the opponent's pokemons.

## Description

The game has a trainer class, which consists on one player who has a hand with unlimited size that can hold cards of two types, Pokemons and Abilities, and a bench that can hold up to 5 pokemons and 1 extra active pokemon that in this implementation will be considered as the first one on the bench. The trainer can bind energies to the pokemon to make it able to use it's abilities on the opponent, the energies are of 6 types:

```
1. Grass
2. Water
3. Fire
4. Fighting
5. Psychic
6. Electric
```

And they are put toghether in an EnergySet object that contains the count of each energy type and has methods for adding or removing Energies or EnergySets and comparing EnergySets. EnergySets and Energies both extend from IEnergy an interface created so that EnergySets and Energies could interact easier.

Each trainer has an opponent and is able to cast an ability in the ability set of his Pokemon. The abilities on any Pokemon are for now only attacks, they were implemented as an interface that inherits from the Ability interface. Each attack has an energy cost in the form of EnergySet, a description, a damage and a name, so with the attacks a trainer can deal damage to the active Pokemon of the opponent.

Each Pokemon has a type, and each type has a resistance and a weakness, so if the trainer decides to attack his opponent, the damage dealt to the active Pokemon of the opponent will depend on it's type resistance and weakness, if the Pokemon that receives the attack is resistant to the attacking pokemon's type, then it receives 30 points less damage than the actual attack damage. If the Pokemon that receives the attack is weak to the attacking Pokemon's type, then it receives twice the actual attack damage. The type table showing the resistances and weaknesses is the following one:

| Type | Weakness | Resistance |
| ---- |:--------:| ----------:|
| Grass | Fire | Water |
| Fire | Water |  |
| Water | Grass, Electric | Fighting |
| Electric | Fighting |  |
| Fighting | Psychic, Grass |  |
| Psychic | Psychic | Fighting |

To implement the attack resitances and weaknesses, double dispatch was used, then, each Pokemon type is responsible for the ammount of  damage it receives from each type, therefore, the weakness and resistance caracteristic of each type is inside these methods.

A Pokemon has an ammount of hp, an id, a name, an abilities array and a trainer. The hp represents the ammount of health left, if it reaches zero, then the Pokemon is dead and is eliminated from the bench. The id represents the unique identifier for each Pokemon. The name of the Pokemon can be repeated in different Pokemons (that is Pokemons with different id's). The abilities array can hold up to four abilities. Finally, the trainer is the owner of the Pokemon.

## Getting Started

Download the project files and build the whole project on java.


## Running the tests

To run the tests of the program, open the project on an IDE, then right click on the Test folder and click on run All Tests.

## Built With

* [Intellij](https://www.jetbrains.com/idea/) - The IDE used

## Author

* **Juan Urrutia** - [Jurrutiag](https://github.com/jurrutiag)
