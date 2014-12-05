import java.util.*;
import java.io.*;

public class FileStorage implements GameStorageAdapter, Observer {
    
    private ArrayList<GameMove> moves = new ArrayList<GameMove>();
    
    private static GameStorageAdapter myInstance = new FileStorage();
    
    private FileStorage() {
        
    }
    
    public static GameStorageAdapter getInstance() {
        return myInstance;
    }
    
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
    
    public void loadGame() {
        
        File file = new File("gameData.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            
            while ((text = reader.readLine()) != null) {
                
                if(text.equals("")) break;

                String[] items = text.split(",");
                
                for(int i=0;i<items.length;i++) {
                    
                    items[i] = items[i].trim();
                    
                }
  
                GameMove move = new GameMove((String) items[0], Integer.parseInt(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
                moves.add(move);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        System.out.println(moves.toString());
    } 
    
    public void saveGame() {
        PrintWriter writer = null; 
        try {
            writer = new PrintWriter("gameData.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        for(GameMove move : moves) {
            writer.write(move.getPlayer()+","+move.getDiceRoll()+","+move.getStartSquare()+","+move.getEndSquare()+"\n");
        }
        
        writer.close();
    }

}
