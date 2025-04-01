package game;

//Gameapp starts the game
public class GameApp {
    public static void main(String[] args) {
        //Create new game object
        Game game = new Game();
        //Initialize the game with name
        game.initializeGameComponents("Seyyid");
        //Start the game
        game.play();
    }
}
