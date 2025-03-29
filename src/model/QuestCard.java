package model;

//Questcard is all cards's super class
public abstract class QuestCard {
    private String name;

    //constructor, card name
    public QuestCard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //for card comparasions
    public boolean equals(QuestCard card){
        return this.name.equals(card.name);
    }

    public String getName(){
        return name;
    }
    
}
