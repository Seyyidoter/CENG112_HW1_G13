package model;

public class TreasureCard extends QuestCard{
    private Treasure treasure; //which treasure
    private int value; //its value

    public TreasureCard(String name, Treasure treasure, int value){
        super(name);
        this.treasure = treasure;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Treasure: " + treasure.getClass().getSimpleName() + " x" + value;
    }

    public int getValue(){
        return value;
    }

    public Treasure getTreasure() {
        return treasure;
    }
}
