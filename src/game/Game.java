package game;
import data.Box;
import data.Chest;
import data.TreasureBox;

public class Game {
    private int numberOfRounds = 5;
    private Player player;
    private Box box;
    private Chest chest;

    public void initializeGameComponents(){
        player = new Player("Seyyid");
        box = new Box();
        box.initializeBox();
        chest = new Chest();
        chest.initializeChest();
    }
    public void claimTreasures(TreasureBox treasureBox){
        //will be coded.
    }
    public void play(){
        //will be coded.
    }
}
