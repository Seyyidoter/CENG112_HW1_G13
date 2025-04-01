package game;
import data.HazardBox;
import data.TreasureBox;
import data.Tent;
import model.Treasure;


public class Player {

    //Player's features
    private String name; 
    private int score;
    private Tent tent;
    private TreasureBox treasureBox;
    private HazardBox hazardBox;

    //Constructor
    public Player(String name){
        this.name = name;
        this.score = 0;
        //Create an empty tent, treasureBox and hazardBox
        this.tent = new Tent();
        this.treasureBox = new TreasureBox(); 
        this.hazardBox = new HazardBox(); 
    }

    //Getter for player name
    public String getName(){
        return name;
    }

    //Getter for score
    public int getScore(){
        return score;
    }

    //This method gives a number from the interval of 0-29
    //We will use it to choose random card
    public int rollDice(){
        return (int) (Math.random() * 30);
    }

    //Calculate the score with considering items in tent
    public int calculateScore() {
        int totalScore = 0;

        //Until tent is empty pick every treasure and add its value to totalScore
        while (!tent.isEmpty()) {
            Treasure treasure = tent.remove();
            totalScore += treasure.getValue();
            }
            
        this.score = totalScore;
        return score;
    }

    @Override
    public String toString(){
        return "Player: " + name + " Score: " + score;
    }

    //Getter for tent, treasureBox, hazardBox
    public Tent getTent() {
        return tent;
    }
    
    public TreasureBox getTreasureBox() {
        return treasureBox;
    }
    
    public HazardBox getHazardBox() {
        return hazardBox;
    }
}
