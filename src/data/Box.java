package data;
import model.*;

public class Box extends Bag<QuestCard> {
    public void initializeBox() {
        for(int i = 0; i < 3; i++){
            add(new Snake());
            add(new Mummy());
            add(new Spider());
            add(new Fire());
            add(new Goblin());
        }

        add(new TreasureCard("Gold", new Gold(), 3));
        add(new TreasureCard("Gold", new Gold(), 6));
        add(new TreasureCard("Gold", new Gold(), 15));
        add(new TreasureCard("Gold", new Gold(), 12));
        add(new TreasureCard("Gold", new Gold(), 15));
        add(new TreasureCard("Turquoise", new Turquoise(), 33));
        add(new TreasureCard("Turquoise", new Turquoise(), 36));
        add(new TreasureCard("Turquoise", new Turquoise(), 39));
        add(new TreasureCard("Turquoise", new Turquoise(), 42));
        add(new TreasureCard("Turquoise", new Turquoise(), 45));
        add(new TreasureCard("Obsidian", new Obsidian(), 18));
        add(new TreasureCard("Obsidian", new Obsidian(), 21));
        add(new TreasureCard("Obsidian", new Obsidian(), 24));
        add(new TreasureCard("Obsidian", new Obsidian(), 27));
        add(new TreasureCard("Obsidian", new Obsidian(), 30));

    }
}
