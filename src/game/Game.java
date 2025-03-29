package game;

import data.Box;
import data.Chest;
import data.TreasureBox;
import model.HazardCard;
import model.QuestCard;
import model.Treasure;
import model.TreasureCard;

public class Game {
    private int numberOfRounds = 5;
    private Player player;
    private Box box;
    private Chest chest;

    // create elements when the game starts
    public void initializeGameComponents(String name) {
        player = new Player(name);
        box = new Box();
        box.initializeBox();
        chest = new Chest();
        chest.initializeChest();
    }

    // add treasure cards from treasure box to tent
    public void claimTreasures(TreasureBox treasureBox) {
        while (!treasureBox.isEmpty()) {
            QuestCard card = treasureBox.remove();
    
            if (card instanceof TreasureCard) {
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
                } else {
                    System.out.println(" Not enough " + targetType.getSimpleName() + " in chest. Skipped this card.");
                    // put back matched ones as well
                    for (int i = 0; i < found; i++) {
                        temp[tempIndex++] = matched[i];
                    }
                }
    
                // put back the rest of chest
                for (int i = 0; i < tempIndex; i++) {
                    chest.add(temp[i]);
                }
            }
        }
    }
    

    public void play() {
        System.out.println("Game started for " + player.getName() + "\n");

        // main game loop – 5 rounds
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("Round " + round);

            // draw 3 cards for one round
            for (int x = 0; x < 3; x++) {
                int index = player.rollDice(); // pick a card
                QuestCard card = box.removeByIndex(index); // remove the card from the box

                if (card instanceof HazardCard) {
                    player.getHazardBox().add(card);
                    System.out.println("Drawn: " + card);
                } else if (card instanceof TreasureCard) {
                    player.getTreasureBox().add(card);
                    System.out.println("Drawn: " + card);
                }
            }

            System.out.println(); // adds space between rounds
        }

        // win or lose condition
        int hazards = player.getHazardBox().getCurrentSize();
        int treasures = player.getTreasureBox().getCurrentSize();

        if (hazards > treasures) {
            System.out.println("You lost");
        } else {
            System.out.println("You won");
            claimTreasures(player.getTreasureBox()); // transfer treasures from treasureBox to tent
        }

        int finalScore = player.calculateScore(); // calculate total score from tent
        System.out.println("Final score is: " + finalScore);
    }
}
