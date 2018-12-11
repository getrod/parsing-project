
package file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class HtmlFileParser {
    
    private ArrayList<Integer> posBeg = new ArrayList<>();
    private ArrayList<Integer> posEnd = new ArrayList<>();
    private FileParser input;
    private boolean result;
    
    public HtmlFileParser(){
    
    }
    
    private void htmlFileChecker(String file)throws FileNotFoundException, IOException{
        result = FileParser.stringSearch(file, "<!DOCTYPE html>");
    }
    
    private boolean isHtml(){
        return result;
    }
    
    public void nodePrinter(String file, String node)throws FileNotFoundException, IOException{
        
        htmlFileChecker(file);
        
        if (!isHtml()){
            System.out.println("This file is not in proper Html format.");
            return;
        }
        
        posBeg.clear();
        posEnd.clear();
        
        String open = "<"+node+">";
        String close = "</"+node+">";
        char[] openNode = open.toCharArray();
        char[] closeNode = close.toCharArray();
        
        input = new FileParser(file);
        input.resetPointer();
        
        int searchChar;
        int hold = input.read();
        int index;
        
        //search for end of beginning node ">"
        while (hold != -1){ 
            index = 0;
            for (int i = 0; i < openNode.length; i++){
                searchChar = (int)openNode[i];
                if (hold == searchChar){
                    hold = input.read();
                    index++;
                } else {
                    i = openNode.length;
                    hold = input.read();
                }
            }
            if (index >= openNode.length){
                posBeg.add(input.getPointer() - 1);
            }
        }
        
        //reset file and file pointer
        input = new FileParser(file);
        input.resetPointer();
        hold = input.read();
        
        //search for beginning of end node "<"
        while (hold != -1){
            index = 0;
            for (int i = 0; i < closeNode.length; i++){
                searchChar = (int)closeNode[i];
                if (hold == searchChar){
                    hold = input.read();
                    index++;
                } else {
                    i = closeNode.length;
                    hold = input.read();
                }
            }
            if (index >= closeNode.length){
                posEnd.add(input.getPointer() - closeNode.length);
            }
        }
        
        if (posEnd.isEmpty()){
            System.out.println("Html tag not found.");
            return;
        }
        printer(file, node);
        input.close();
    }
    
    private void printer(String file, String nodeId)throws FileNotFoundException, IOException, IndexOutOfBoundsException{
        
        int counter = 0;
        int hold;
        
        //Catch out of bounds and say there is a conflict with the label nameing
        for(int i = 0; i < posEnd.size(); i++){
            counter++;
            
            //reset file and file pointer
            System.out.println(counter + ". " + nodeId);
            input = new FileParser(file);
            input.resetPointer();
            hold = input.read();
            
            if (posBeg.isEmpty()){
                System.out.println("It's empty");
                throw new IndexOutOfBoundsException(); 
            }
            
            while (hold != -1){
                if (input.getPointer() > posBeg.get(i) && input.getPointer() < posEnd.get(i)){
                    if (hold != 9){
                        FileConsolPrinter.printChar(hold);   
                    }
                }
                hold = input.read();
            }
            System.out.println("");
        }//end for
        hold = 0;
    }
    
    
}
