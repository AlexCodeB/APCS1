//Average Reflection
 
//Alex Bruckhaus, Period 6, 11/13/2017
//This program took me 35 minutes.
//In the beginning, this program seemed difficult to code, but after being introduced to it in class and reading the notes, it became a lot more understandable. This was the first time
//I encountered reading files and writing to files, so it took me a little while to get familiar with this topic. Nonetheless, the problem solving aspect of this assignment was not
//too difficult, but I felt like it gave me a good introduction to reading from a file and writing to a file. Overall, this lab greatly helped me develop my programming skills regarding
//lesson 13.

import java.util.Scanner;
import java.io.*;
public class P6_Bruckhaus_Alexander_Average{
    public static void main(String[] args){
        Scanner in = null;
        double sum = 0.0;
        double count = 0.0;
        
        try{
            in = new Scanner(new File("/Users/family/Desktop/numbers.txt"));
            while(in.hasNextInt()){
                sum += in.nextInt();
                count++;
            }
            in.close();
        }catch (IOException e){
            System.out.println("Error: could not read from file.");
        }
        
        double average = sum / count;
        String result = String.format("Average = %.2f", average);
        System.out.printf(result);
        
        FileWriter out;
        try{
            out = new FileWriter("output.txt");
            out.write(result, 0, result.length());
            out.close();
        }catch (IOException e){
            System.out.println("Error: could not write to file.");
        }
    }
}
