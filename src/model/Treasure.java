package model;

//abstract class for all treasures
public abstract class Treasure {

    //each card will have a value
    private int value;

    //constructor 
    public Treasure(int value){
        this.value = value;
    }

    // returns the treasure type and its value 
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " (Value: " + value + ")";
    }

    // getter for value
    public int getValue(){
        return this.value;
    }
}
