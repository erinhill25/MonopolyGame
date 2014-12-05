
public class GameMove {

    private String player;
    private int diceRoll, startSquare, endSquare;
    
    public GameMove(String player, int diceRoll, int startSquare, int endSquare) {
        this.player = player;
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.diceRoll = diceRoll; 
    }
    
    public String getPlayer() {
        return player;
    }
    
    public int getDiceRoll() {
        return diceRoll;
    }
    
    public int getStartSquare() {
        return startSquare;
    }
    
    public int getEndSquare() {
        return endSquare; 
    }
    
    public String toString() {
        return "Player: " + player + " Roll: " + diceRoll + " Start Square: " + startSquare + " End Square: " + endSquare;
    }
    
}
