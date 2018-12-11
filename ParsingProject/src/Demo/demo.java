//---------------------------------------------------------------------------
//  To be honest, I don't know what I'm doing lol.
//  Author: Kevin Louis - Jean
//  Date: 12/10/2018
//  Descrition: This program reads an HTML file to the console and
//              prints the individual Html nodes found in the file. I made 
//              this for fun. Play around and edit with this as you will.
//---------------------------------------------------------------------------


package Demo;

import file.FileConsolPrinter;
import file.HtmlFileParser;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo {
    
    public static void main(String[] args) {
        String file = "src\\Demo\\demo.html";
        String file2 = "src\\Demo\\break.txt";
        
        try {
            System.out.println("//----------------------------------------------------------------------");
            System.out.println("  Print the file \"demo.html\" located in the src folder:");
            System.out.println("//----------------------------------------------------------------------");
            FileConsolPrinter.printFile(file);
            
            System.out.println("//----------------------------------------------------------------------");
            System.out.println("  Print the contents of each node labeled \"body\" in the html file:");
            System.out.println("//----------------------------------------------------------------------");
            String node = "body";
            HtmlFileParser htmlParser = new HtmlFileParser();
            htmlParser.nodePrinter(file, node);
            
            System.out.println("//----------------------------------------------------------------------");
            System.out.println("  Print the contents of each node labeled \"h1\" in the html file:" );
            System.out.println("//----------------------------------------------------------------------");
            node = "h1";
            htmlParser.nodePrinter(file, node);
            
            System.out.println("//----------------------------------------------------------------------");
            System.out.println("  If search for the node \"h2\" which is not in the file");
            System.out.println("  It outputs: ");
            node = "h2";
            htmlParser.nodePrinter(file, node);
            
            System.out.println("//----------------------------------------------------------------------");
            System.out.println("  If the file is not of the type html, it will output an error");
            System.out.println("  First lets print a non-html file named \"break.txt\": ");
            System.out.println("//----------------------------------------------------------------------");
            FileConsolPrinter.printFile(file2);
            
            System.out.println("//----------------------------------------------------------------------");
            System.out.println("  If I try to search for the node \'p\' in file, it will output: " );
            System.out.println("//----------------------------------------------------------------------");
            htmlParser.nodePrinter(file2, "p");
            
        } catch (FileNotFoundException e){
            System.out.println("File is not Found");
        } catch (IOException e){
            System.out.println("IO Exception");
        }
        
    }
    
} //god bless. peace out.
