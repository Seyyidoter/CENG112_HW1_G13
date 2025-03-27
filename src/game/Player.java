package game;
import data.HazardBox;
import data.TreasureBox;
import data.Tent;
import model.Treasure;


public class Player {
    private String name;
    private int score;

    private Tent tent;
    private TreasureBox treasureBox;
    private HazardBox hazardBox;

    public Player(String name){
        this.name = name;
        this.score = 0;
        this.treasureBox = new TreasureBox();
        this.hazardBox = new HazardBox();
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public int rollDice(){
        return (int) (Math.random() * 30);
    }

    public int calculateScore() {
        int totalScore = 0;

        while (!tent.isEmpty()) {
            Treasure treasure = tent.remove();

            if (treasure.getClass().getSimpleName().equals("Turquoise")) {
                totalScore += treasure.getValue();
            } else if (treasure.getClass().getSimpleName().equals("Obsidian")) {
                totalScore += treasure.getValue();
            } else if (treasure.getClass().getSimpleName().equals("Gold")) {
                totalScore += treasure.getValue();
            }
        }
        this.score = totalScore;
        return score;
    }

    public String toString(){
        return "Player: " + name + " Score: " + score;
    }
}
