package model;

public abstract class Treasure {

    protected int value;

    public Treasure(int value){
        this.value = value;
    }

    public String toString(){
        return this.getClass().getSimpleName() + " (Value: " + value + ")";
    }

    public int getValue(){
        return this.value;
    }
}
