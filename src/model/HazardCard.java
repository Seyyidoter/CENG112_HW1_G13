package model;

//Hazardcard is a kind of quest card
public class HazardCard extends QuestCard{

    //Constructor
    public HazardCard(String name) {
        super(name); 
    }

    //To write card type and name
    @Override
    public String toString(){
        return "Hazard: " + super.toString();
    }
}
