
package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileParser {
    
    private static int pointer = 0;
    private FileInputStream input;
    
    public FileParser(String file) throws FileNotFoundException{
        input = new FileInputStream(file);
    }
    
    public int read()throws IOException{
        pointer++;
        return input.read();
    }
    
    
    public void close() throws IOException{
        input.close();
    }
    
    public int getPointer(){
        return pointer;
    }
    
    public void resetPointer(){
        pointer = 0;
    }
    
    public static boolean stringSearch (String file, String search) throws FileNotFoundException, IOException{
        
        char[] characters = search.toCharArray();
        boolean result = false;
        
        try (FileInputStream input = new FileInputStream(file)) {
            int searchChar;
            int hold = input.read();
            int index;
            
            while (hold != -1){
                index = 0;
                for (int i = 0; i < characters.length; i++){
                    searchChar = (int)characters[i];
                    if (hold == searchChar){
                        hold = input.read();
                        index++;
                    } else {
                        i = characters.length;
                        hold = input.read();
                    }
                }
                if (index >= characters.length){
                    result  = true;
                }
            }
        }
        return result;
    }
    
}
