package model;

public abstract class Treasure {

    //each card will have a value
    private int value;

    //constructor 
    public Treasure(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " (Value: " + value + ")";
    }

    public int getValue(){
        return this.value;
    }
}
