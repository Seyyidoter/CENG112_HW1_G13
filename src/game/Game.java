package game;
import data.Box;
import data.Chest;
import data.TreasureBox;
import model.HazardCard;
import model.QuestCard;
import model.TreasureCard;

public class Game {
    private int numberOfRounds = 5;
    private Player player;
    private Box box;
    private Chest chest;

    //create elements when the game starts
    public void initializeGameComponents(){
        player = new Player("Seyyid");
        box = new Box();
        box.initializeBox();
        chest = new Chest();
        chest.initializeChest();
    }

    //add treasure cards from treasure box to tent
    public void claimTreasures(TreasureBox treasureBox){

        //until treasure box be empty
        while (!treasureBox.isEmpty()) {
            QuestCard card = treasureBox.remove();

            if (card instanceof TreasureCard){
                TreasureCard tCard = (TreasureCard) card;
                int count = tCard.getValue(); //how many treasure will carry

                for (int i=0; i < count; i++){
                    if (!chest.isEmpty()){
                        player.getTent().add(chest.remove()); //carry it from chest to tent
                    }
                }
            }
            
        }
    }
    public void play(){
        System.out.println("Game started for "+ player.getName() + "\n");

        //main game loop 5 rounds 
        for (int round=1; round <= numberOfRounds; round++){
            System.err.println("Round" + round);

            //pick 3 cards for one round
            for(int x=0; x<3; x++){
                int index = player.rollDice(); //pick a card 
                QuestCard card = box.removeByIndex(index); //remove that card

                //card type condition
                if (card instanceof HazardCard) {
                    player.getHazardBox().add(card);
                    System.out.println("Drawn: " + card);
                } 
                
                else if (card instanceof TreasureCard) {
                    player.getTreasureBox().add(card);
                    System.out.println("Drawn: " + card);
                }
            }

            System.out.println(); //adds space between rounds
            }

        //win or lose
        int hazards = player.getHazardBox().getCurrentSize();
        int treasures = player.getTreasureBox().getCurrentSize();

        if (hazards>treasures){
            System.out.println("You lost");
        }
        else {
            System.out.println("You won");
            claimTreasures(player.getTreasureBox()); //send treasures to tent
        }

        int finalScore = player.calculateScore(); //calculate points
        System.out.println("final score is: "+finalScore);
        }
    }
