package model;

//treasure card is a kind of quest card
public class TreasureCard extends QuestCard{
    private Treasure treasure; //which treasure
    private int value; //its value

    //constructor for treasure cards
    public TreasureCard(String name, Treasure treasure, int value){
        super(name);
        this.treasure = treasure;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Treasure: " + treasure.getClass().getSimpleName() + " x" + value + " (Unit value: " + treasure.getValue() + ")";
    }

    //getter for value
    public int getValue(){
        return value;
    }

    //getter for treasure type
    public Treasure getTreasure() {
        return treasure;
    }
}
