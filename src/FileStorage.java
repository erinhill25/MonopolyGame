import java.util.*;
import java.io.*;

public class FileStorage implements GameStorageAdapter {
    

    private static GameStorageAdapter myInstance = new FileStorage();
    private String fileName = "gameData.txt";
    
    private FileStorage() {
        
    }
    
    public static GameStorageAdapter getInstance() {
        return myInstance;
    }
   
    public ArrayList<HashMap<String, String>> loadData() {
        
        ArrayList<HashMap<String, String>> values = new ArrayList<HashMap<String, String>>();

        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            
            while ((text = reader.readLine()) != null) {
                
                if(text.equals("")) break;
                
                HashMap<String, String> valueMap = new HashMap<String, String>();

                String[] items = text.split(",");
                
                for(int i=0;i<items.length;i++) {
                    
                    String[] valuePair = items[i].trim().split(":");
                    valueMap.put(valuePair[0], valuePair[1]); 
                    
                }
                
                values.add(valueMap);
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

        return values;
    } 
    
    public void storeData(ArrayList<HashMap<String, String>> values) {
        
        PrintWriter writer = null; 
        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        String line = "";
        for(HashMap<String, String> valueMap : values) {
            for(Map.Entry<String, String> entry : valueMap.entrySet()) {
                
                line += entry.getKey() + ":" + entry.getValue() + ",";
                
            }
            line = line.substring(0, line.length()-1);
            line += "\n";
        }
      
        writer.write(line);
        writer.close();
    }
    


}
