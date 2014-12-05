import java.util.*;

public class FileStorage implements GameStorageAdapter, Observer {
    
    private ArrayList<GameMove> moves = new ArrayList<GameMove>();
    
    public void update(Observable source, Object value) {
        
        ObservableArgument arg = (ObservableArgument) value;
        
        if(arg.getName() == "update") {
            
            GameMove move = (GameMove) arg.getValue();
            moves.add(move);
        }
        else if(arg.getName() == "endGame") {
            
            saveGame();
            
        }
        
        System.out.println(moves.toString());
    }
    
    public void loadGame() {} 
    
    public void saveGame() {}

}
