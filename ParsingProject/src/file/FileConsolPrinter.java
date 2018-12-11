
package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileConsolPrinter {
    
    public FileConsolPrinter(){
        
    }
    
    public static void printFile (String file) throws FileNotFoundException, IOException{
        FileInputStream input = new FileInputStream(file);
        int hold = input.read();
        while (hold != -1){
            printChar(hold);
            hold = input.read();
        }
        System.out.println("");
        input.close();
    }
    
    public static void printChar (int hold){
        char c = (char)hold;
        if (c <= 126){
            System.out.print(c);   
        }
    }
}
