Incan Gold Game - Java Project
=======
Incan Gold Game - Java Project HW1
CENG112 - Data Structures
Izmir Institute of Technology (IZTECH) - Spring 2025

Seyyid Öter, Emir Kağan Yiğit

---------------------------------------
PROJECT DESCRIPTION
---------------------------------------

This project is a simplified Java simulation of the card-based adventure game "Incan Gold".

The game is played by a single player in 5 rounds. In each round, the player draws 3 cards from a deck.  
Cards can be either TreasureCards or HazardCards.

Goal: Collect as many treasures as possible while avoiding too many hazards.  
At the end of the game, the player's score is calculated based on the treasures safely moved to their tent.

---------------------------------------
PROJECT STRUCTURE
---------------------------------------

src/
├── data/         → Data structures (Bag, Box, Chest, Tent, etc.)
├── model/        → Model classes (TreasureCard, HazardCard, Gold, etc.)
└── game/         → Game logic (Game.java, Player.java, GameApp.java)

---------------------------------------
HOW TO COMPILE AND RUN
---------------------------------------

1. Open a terminal and navigate to the src/ directory.

2. Compile:
   javac data/*.java model/*.java game/*.java

3. Run the game:
   java game.GameApp

Note: Java 17 or newer is recommended.

---------------------------------------
MAIN CLASSES AND RESPONSIBILITIES
---------------------------------------

- Game:
  Controls the overall flow of the game (initialize, play, evaluate results).

- Player:
  Stores the player’s name, score, and manages their tent and temporary boxes.

- Box:
  Holds 30 QuestCards (15 hazards + 15 treasures) at the start of the game.

- Chest:
  Holds all 360 treasures (195 Turquoise, 120 Obsidian, 45 Gold).

- TreasureCard:
  Represents a card containing a specific type and quantity of treasure.

- HazardCard:
  Represents danger cards (Snake, Fire, Goblin, etc.).

---------------------------------------
GAME RULES
---------------------------------------

- The game has 5 rounds.
- In each round, 3 cards are drawn randomly from the Box.
- For each TreasureCard, the specified number of treasures are claimed from the Chest.
- If the number of HazardCards > TreasureCards → the player loses.
- Otherwise → the player wins and claims their treasures into the Tent.
- Final score is the sum of the value of all treasures in the Tent.

Example:
  A TreasureCard containing "Gold x30" means 30 gold treasures (each worth 10) → 300 points.

---------------------------------------
NOTES
---------------------------------------

- All classes and methods are implemented according to the official assignment PDF.
- The project follows object-oriented design principles.
- Can be compiled and executed using a standard Java development environment.
