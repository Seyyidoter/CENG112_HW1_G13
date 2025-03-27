package game;
import data.HazardBox;
import data.TreasureBox;
import data.Tent;

public class Player {
    private String name;
    private int score;

    private Tent tent;
    private TreasureBox treasureBox;
    private HazardBox hazardBox;

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public int rollDice(){
        return 0; // will be coded.
    }

    public int calculateScore(){
        return 0; // will be coded.
    }

    public String toString(){
        return "Player: " + name + " Score: " + score;
    }
}
