package data;
import model.Gold;
import model.Treasure;

public class Tent extends Bag<Treasure>{
    public Tent(){
        super();
        initializeTent();
    }

    private void initializeTent(){
        add(new Gold());
    }
}
