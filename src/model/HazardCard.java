package model;

public class HazardCard extends QuestCard{

    public HazardCard(String name) {
        super(name);
    }

    //to write card type and name
    @Override
    public String toString(){
        return "Hazard: " + super.toString();
    }
}
