//Unsqueeze Reflection

//Alex Bruckhaus, Period 6, 11/16/2017
//This program took me 45 minutes.
//This program seemed challenging at first, but after writing psuedocode, I had a much better idea of what to do. I realized that I had to use parseInt from the Integer class in order
//to convert the string to an integer. I also made plenty of helper methods to help me complete this assignment successfuly and smoothly. Breaking the code into multiple parts helped me better
//understand what was happening at each part of the program. In the end, this program ended up taking a while to complete because of all the different parts I used. However,
//it helped me in the long run, giving me a better understanding of IO in java.


import java.util.Scanner;
import java.io.*;

public class P6_Bruckhaus_Alexander_Unsqueeze{
    private static int getTabCount(String str){
        String numStr;
        numStr = str.substring(0, str.indexOf(" ")); 
        int n = Integer.parseInt(numStr);
        return n;
    }

    private static String getRestOfLine(String str){
        return str.substring(str.indexOf(" "));
    }

    private static void outputTabs(FileWriter f, int n){
        for(int i = 0; i < n; i++){
            try{
                f.write("\t");
                System.out.print("\t");
            }catch (IOException e){
                System.out.println("Could not write to file");
            }
        }
    }

    private static void outputLine(FileWriter f, String str){
        try{
            f.write(str + "\n");
            System.out.println(str);
        }catch (IOException e){
            System.out.println("Could not write to file");
        }
    }

    private static FileWriter getOutFile(){
        FileWriter out = null;
        try{
            out = new FileWriter("UnSqueeze.txt");
        }catch (IOException e){
            System.out.println("Error: could not write to file.");
        }
        return out;
    }

    public static void main(String[] args){
        int tabCount;
        String line;
        String restOfLine;
        Scanner in = null;
        String str = "";
        FileWriter out;

        try{
            in = new Scanner(new File("P6_Bruckhaus_Alexander_Squeeze_Output.txt"));
            out = getOutFile();
            while(in.hasNextLine()){
                line = in.nextLine();
                tabCount = getTabCount(line);
                restOfLine = getRestOfLine(line);
                outputTabs(out, tabCount);
                outputLine(out, restOfLine);
            }
            in.close();
            out.close();
        }catch (IOException e){
            System.out.println("Error: could not read from file.");
        }
    }
}
