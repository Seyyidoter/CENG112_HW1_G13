package model;

public class TreasureCard extends QuestCard{
    private Treasure treasure; //which treasure
    private int value; //its value

    public TreasureCard(String name, Treasure treasure, int value){
        super(name);
        this.treasure = treasure;
        this.value = value;
    }

    public String toString(){
        return treasure.toString();
    }

    public int getValue(){
        return value;
    }
}
