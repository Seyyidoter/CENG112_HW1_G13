package game;
import data.HazardBox;
import data.TreasureBox;
import data.Tent;
import model.Treasure;


public class Player {

    //player's features
    private String name; 
    private int score;
    private Tent tent;
    private TreasureBox treasureBox;
    private HazardBox hazardBox;

    //constructor
    public Player(String name){
        this.name = name;
        this.score = 0;
        // create an empty tent, tresureBox and hazardBox
        this.tent = new Tent();
        this.treasureBox = new TreasureBox(); 
        this.hazardBox = new HazardBox(); 
    }

    //getter for player name
    public String getName(){
        return name;
    }

    //getter for score
    public int getScore(){
        return score;
    }

    //this method gives a number from the interval of 0-29
    //we will use it to choose random card
    public int rollDice(){
        return (int) (Math.random() * 30);
    }

    //calculate the score with considering items in tent
    public int calculateScore() {
        int totalScore = 0;

        //until tent is empty pick every treasure and add its value to totalscore
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

    //getter for tent, treasurebox, hazardbox
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
