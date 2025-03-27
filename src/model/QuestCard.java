package model;

public abstract class QuestCard {
    protected String name;

    public QuestCard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean equals(QuestCard card){
        return this.name.equals(card.name);
    }
}
