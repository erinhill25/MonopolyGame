import java.util.ArrayList;
import java.util.HashMap;


public interface GameStorageAdapter {

    public ArrayList<HashMap<String, String>> loadData();
    
    public void storeData(ArrayList<HashMap<String, String>> values); 
    
}
