package model;

//QuestCard is all cards super class
public abstract class QuestCard {
    private String name;

    //Constructor, card name
    public QuestCard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //For card comparisons
    public boolean equals(QuestCard card){
        return this.name.equals(card.name);
    }

    public String getName(){
        return name;
    }
    
}
