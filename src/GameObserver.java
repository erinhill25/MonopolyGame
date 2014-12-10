import java.util.*;

public class GameObserver implements Observer {

    private ArrayList<GameMove> moves = new ArrayList<GameMove>();
    private GameStorageAdapter storage = FileStorageAdapter.getInstance();
    
    private static Observer gameObserver = new GameObserver(); 
    
    private GameObserver() {} 
    
    public static Observer getInstance() {
        return gameObserver;
    }
    
    public void update(Observable source, Object value) {
        
        ObservableArgument arg = (ObservableArgument) value;
        
        if(arg.getName() == "update") {
            
            GameMove move = (GameMove) arg.getValue();
            moves.add(move);
        }
        else if(arg.getName() == "loadGame") {
            
            moves.clear();
            ArrayList<HashMap<String, String>> values = storage.loadData();
            
            for(HashMap<String, String> valueMap : values) {
                GameMove newMove = new GameMove( (String) valueMap.get("player"), Integer.parseInt(valueMap.get("diceRoll")), 
                      Integer.parseInt(valueMap.get("startSquare")), Integer.parseInt(valueMap.get("endSquare")));
                moves.add(newMove);
            }
            
        }
        else if(arg.getName() == "saveGame") {
            
            ArrayList<HashMap<String, String>> values = new ArrayList<HashMap<String, String>>();
            for(GameMove move : moves) {
                
                HashMap<String, String> valueMap = new HashMap<String, String>();
                valueMap.put("player",      move.getPlayer());
                valueMap.put("diceRoll",    String.valueOf(move.getDiceRoll()));
                valueMap.put("startSquare", String.valueOf(move.getStartSquare()));
                valueMap.put("endSquare",   String.valueOf(move.getEndSquare()));
                
                values.add(valueMap);
            }
            
            storage.storeData(values);
            
        }
       
        System.out.println(moves.toString());
    }
}
