
public class GameMove {

    private String player;
    private int diceRoll;
    private Square startSquare;
    private Square endSquare;
    
    public GameMove(String player, int diceRoll, Square startSquare, Square endSquare) {
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
    
    public Square getStartSquare() {
        return startSquare;
    }
    
    public Square getEndSquare() {
        return endSquare; 
    }
    
    public String toString() {
        return "Player: " + player + " Roll: " + diceRoll + " Start Square: " + startSquare.getIndex() + " End Square: " + endSquare.getIndex();
    }
    
}
