package data;
import model.Gold;
import model.Obsidian;
import model.Treasure;
import model.Turquoise;

//Chest holds treasure objects
public class Chest extends Bag<Treasure>{
    public Chest() {
        super(); //Bag's constructor
        //All treasures must be in the chest at first
        initializeChest();
    }
    //Constructor
    public void initializeChest(){
        //Fill the chest with treasures
        //195 Turquoise
        for (int i = 0; i < 195; i++){
            add(new Turquoise());
        }
        //120 Obsidian
        for (int i = 0; i < 120; i++){
            add(new Obsidian());
        }
        //45 Gold
        for (int i = 0; i < 45; i++){
            add(new Gold());
        }
    }
}
