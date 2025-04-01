package game;
import data.*;
import model.*;

public class Game {
    //Total number of rounds in our game
    private final int numberOfRounds = 5;
    //Game elements
    private Player player;
    private Box box;
    private Chest chest;

    //Create elements when the game starts
    public void initializeGameComponents(String name) {
        player = new Player(name);
        box = new Box();
        box.initializeBox(); //Fill the box
        chest = new Chest();
        chest.initializeChest(); //Fill the chest
    }

    //Add treasure cards from treasure box to tent
    public void claimTreasures(TreasureBox treasureBox) {
        while (!treasureBox.isEmpty()) {
            //Remove treasure card
            QuestCard card = treasureBox.remove();

            TreasureCard tCard = (TreasureCard) card;
            int count = tCard.getValue(); //How many treasures will be transferred
            String treasureType = tCard.getTreasure().getClass().getSimpleName();
    
            //Temporarily store matching treasures
            Treasure[] matched = new Treasure[count];
            int found = 0;
    
            //Store all chest contents temporarily
            int chestSize = chest.getCurrentSize();
            Treasure[] temp = new Treasure[chestSize];
            int tempIndex = 0;

            //Scan chest for matches
            while (!chest.isEmpty()) {
                Treasure treasure = chest.remove();
                if (treasure.getClass().getSimpleName().equals(treasureType) && found < count) {
                    matched[found++] = treasure;
                } else {
                    temp[tempIndex++] = treasure;
                }
            }
    
            //If enough treasures found, add to tent
            if (found == count) {
                for (int i = 0; i < count; i++) {
                    player.getTent().add(matched[i]);
                }
            }
    
            //Put back the rest of chest
            for (int i = 0; i < tempIndex; i++) {
                chest.add(temp[i]);
            }            
        }
    }
    //Start game
    public void play() {
    System.out.println("Game started for " + player.getName() + "\n");

    //Main game loop – 5 rounds
    for (int round = 1; round <= numberOfRounds; round++) {
        System.out.println("Round " + round);

        //Draw 3 cards for one round
        for (int x = 0; x < 3; x++) {
            //Random index based on current size
            int index = player.rollDice(box);
            //Remove the card from the box
            QuestCard card = box.removeByIndex(index); 

            //Add card to box
            if (card instanceof HazardCard) {
                player.getHazardBox().add(card);
                System.out.println("Drawn: " + card);
            } else if (card instanceof TreasureCard) {
                player.getTreasureBox().add(card);
                System.out.println("Drawn: " + card);
            }
        }

        System.out.println(); //Adds empty line between rounds
    }

    //Win or lose condition
    int hazards = player.getHazardBox().getCurrentSize();
    int treasures = player.getTreasureBox().getCurrentSize();

    if (hazards > treasures) {
        System.out.println("You lost " + player.getName());
    } else {
        System.out.println("You won " + player.getName());
        //Transfer treasures from treasureBox to tent
        claimTreasures(player.getTreasureBox()); 
    }

    //Calculate total score from tent
    int finalScore = player.calculateScore(); 
    System.out.println("Final score is: " + finalScore);
    }
}
