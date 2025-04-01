package model;

//Abstract class for all treasures
public abstract class Treasure {

    //Each card will have a value
    private int value;

    //Constructor 
    public Treasure(int value){
        this.value = value;
    }

    //Returns the treasure type and its value 
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " (Value: " + value + ")";
    }

    //Getter for value
    public int getValue(){
        return this.value;
    }
}
