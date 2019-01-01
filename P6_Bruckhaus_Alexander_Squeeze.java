//Squeeze Reflection

//Alex Bruckhaus, Period 6, 11/14/2017
//This program took me 50 minutes.
//At first, I was perplexed by this assignment, not really knowing what to do. However, after completing the "Average" assignment, it helped me begin my program. The only challenging part after that was
//finding a way to replace the tabs with a blank space, so I googled the replaceFirst() method to find that I could replace all instances of tab ("\t") with "". After this, I implemented a helper method
//countTab() to use in order to write output to the file. From this assignment, I learned how to compress a Java source code file and further developed my IO skills.

import java.io.*;
import java.util.Scanner;
public class P6_Bruckhaus_Alexander_Squeeze{
    public static String countTab(String str){
        int count = -1;
        String str1 = str;
        String str2 = "";
        while(str2 != str1){
            count++;
            str2 = str1;
            str1 = str2.replaceFirst("\\t","");
            
        }
        return count + " " + str2 + "\n";
    }

    public static void main(String[] args){
        Scanner in = null;
        String str = "";
        FileWriter out;

        try{
            in = new Scanner(new File("/Users/family/Desktop/LeetSpeak.java"));
            while(in.hasNextLine()){
                str += countTab(in.nextLine());
            }
            in.close();
        }catch (IOException e){
            System.out.println("Error: could not read from file.");
        }

        String result = countTab(str);
        System.out.println(result + "\n");

        try{
            out = new FileWriter("P6_Bruckhaus_Alexander_Squeeze_Output.txt");
            out.write(result + "\n");
            out.close();
        }catch (IOException e){
            System.out.println("Error: could not write to file.");
        }
    }
}
