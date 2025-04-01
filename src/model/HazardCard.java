package model;

//hazardcard is a kind of quest card
public class HazardCard extends QuestCard{

    //constructor
    public HazardCard(String name) {
        super(name); 
    }

    //to write card type and name
    @Override
    public String toString(){
        return "Hazard: " + super.toString();
    }
}
