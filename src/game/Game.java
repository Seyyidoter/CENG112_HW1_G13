package game;
import data.*;
import model.*;

public class Game {
    //total number of rounds in our game
    private final int numberOfRounds = 5;
    //game elements
    private Player player;
    private Box box;
    private Chest chest;

    // create elements when the game starts
    public void initializeGameComponents(String name) {
        player = new Player(name);
        box = new Box();
        box.initializeBox(); //fill the box
        chest = new Chest();
        chest.initializeChest(); //fill the chest
    }

    // add treasure cards from treasure box to tent
    public void claimTreasures(TreasureBox treasureBox) {
        while (!treasureBox.isEmpty()) {
            //remove treasure card
            QuestCard card = treasureBox.remove();

            TreasureCard tCard = (TreasureCard) card;
            int count = tCard.getValue(); // how many treasures will be transferred
            Class<?> targetType = tCard.getTreasure().getClass();
    
            // temporarily store matching treasures
            Treasure[] matched = new Treasure[count];
            int found = 0;
    
            // store all chest contents temporarily
            int originalSize = chest.getCurrentSize();
            Treasure[] temp = new Treasure[originalSize];
            int tempIndex = 0;

            //scan chest for matches
            while (!chest.isEmpty()) {
                Treasure treasure = chest.remove();
                if (treasure.getClass().equals(targetType) && found < count) {
                    matched[found++] = treasure;
                } else {
                    temp[tempIndex++] = treasure;
                }
            }
    
            // if enough treasures found, add to tent
            if (found == count) {
                for (int i = 0; i < count; i++) {
                    player.getTent().add(matched[i]);
                }
            }
    
            // put back the rest of chest
            for (int i = 0; i < tempIndex; i++) {
                chest.add(temp[i]);
            }            
        }
    }
    //start game
    public void play() {
    System.out.println("Game started for " + player.getName() + "\n");

    // main game loop – 5 rounds
    for (int round = 1; round <= numberOfRounds; round++) {
        System.out.println("Round " + round);

        // draw 3 cards for one round
        for (int x = 0; x < 3; x++) {
            // Only roll within the current valid range
            int maxIndex = box.getCurrentSize() - 1;
            if (maxIndex < 0) {
                System.out.println("No more cards in the box!");
                break;
            }

            // Random index based on current size
            int index = (int)(Math.random() * (maxIndex + 1)); 
            // remove the card from the box
            QuestCard card = box.removeByIndex(index); 

            //add card to box
            if (card instanceof HazardCard) {
                player.getHazardBox().add(card);
                System.out.println("Drawn: " + card);
            } else if (card instanceof TreasureCard) {
                player.getTreasureBox().add(card);
                System.out.println("Drawn: " + card);
            }
        }

        System.out.println(); // adds empty line between rounds
    }

    // win or lose condition
    int hazards = player.getHazardBox().getCurrentSize();
    int treasures = player.getTreasureBox().getCurrentSize();

    if (hazards > treasures) {
        System.out.println("You lost");
    } else {
        System.out.println("You won");
        // transfer treasures from treasureBox to tent
        claimTreasures(player.getTreasureBox()); 
    }

    // calculate total score from tent
    int finalScore = player.calculateScore(); 
    System.out.println("Final score is: " + finalScore);
    }
}
