package data;
import model.Gold;
import model.Obsidian;
import model.Treasure;
import model.Turquoise;

public class Chest extends Bag<Treasure>{
    public Chest() {
        super();
        initializeChest();
    }
    private void initializeChest(){
        for (int i = 0; i < 195; i++){
            add(new Turquoise());
        }
        for (int i = 0; i < 120; i++){
            add(new Obsidian());
        }
        for (int i = 0; i < 45; i++){
            add(new Gold());
        }
    }
}
