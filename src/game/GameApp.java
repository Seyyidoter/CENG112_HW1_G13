package game;

//gameapp starts the game
public class GameApp {
    public static void main(String[] args) {
        //create new game object
        Game game = new Game();
        //initialize the game with name
        game.initializeGameComponents("Seyyid");
        //start the game
        game.play();
    }
}
