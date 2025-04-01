package model;

//Treasure card is a kind of quest card
public class TreasureCard extends QuestCard{
    private Treasure treasure; //Which treasure
    private int value; //Its value

    //Constructor for treasure cards
    public TreasureCard(String name, Treasure treasure, int value){
        super(name);
        this.treasure = treasure;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Treasure: " + treasure.getClass().getSimpleName() + " x" + value + " (Unit value: " + treasure.getValue() + ")";
    }

    //Getter for value
    public int getValue(){
        return value;
    }

    //Getter for treasure type
    public Treasure getTreasure() {
        return treasure;
    }
}
