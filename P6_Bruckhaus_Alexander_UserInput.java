//UserInput Reflection

//Alex Bruckhaus, Period 6, 11/10/2017
//This program took me 1 hour and 30 minutes.
//In the beginning, I had very little knowledge of Try, Catch Throw, but as I learned from the lecture in class as well as notes on tinocs, I began to feel more comfortable. This lab also
//helped me greatly regarding my understanding of user input and exceptions. However, I did get stuck a couple of times when trying to figure out how to identify the first token, so I used the internet
//to find the split method, which identifies the first part of the input. Overall, this lab was difficult to begin with because of my lack of knowledge to error checking, but as I continued to use
//resources to help me, the program became easier to write. This assignment helped me extend my knowledge oferror checking as well as user input even more than before.

import java.util.Scanner;
public class P6_Bruckhaus_Alexander_UserInput{
    static final Scanner in = new Scanner(System.in);

    public static String readLine(String str){
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

    public static int readInt(String str){
        boolean valid = false;
        int input = -1;
        while(!valid){
            try{
                valid = true;        
                String line = readLine(str);
                String firstToken = line.split(" ")[0];
                input = Integer.parseInt(firstToken);
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Try again");
                valid = false;
            }        
        }
        return input;
    }

    public static double readDouble(String str){
        boolean valid = false;
        double input = -1.0;
        while(!valid){
            try{
                valid = true;        
                String line = readLine(str);
                String firstToken = line.split(" ")[0];
                input = Double.parseDouble(firstToken);
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Try again");
                valid = false;
            }        
        }
        return input;
    }

    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        str = str.toLowerCase();
        if(str.equals("true") || str.equals("yes") || str.equals("affirmative")){
            return true;
        }else if(str.equals("negative") || str.equals("no") || str.equals("false")){
            return false;
        }else{
            throw new IllegalArgumentException("Your input was not valid.");
        }
    }

    public static boolean readBoolean(String str){
        boolean valid = false;
        boolean input = false;
        while(!valid){
            try{
                valid = true;        
                String line = readLine(str);
                String firstToken = line.split(" ")[0];
                input = parseBoolean(firstToken);
            }catch (IllegalArgumentException e){
                System.out.println("Invalid input. Try again");
                valid = false;
            }        
        }
        return input;
    }

    public static void main(String[] args){
        String s = "s";
        while(!(s.equals("stop"))){
            s = readLine("Please enter a string or enter stop to stop: ");
            System.out.println("Your string is: " + s);
        }
        
        int i = 0;
        while(i != -1){
            i = readInt("Please enter an integer or enter -1 to stop: ");
            System.out.println("Your integer is: " + i);
        }

        double decimal = 0.0;
        while(decimal != -1.0){
            decimal = readDouble("Please enter a decimal or enter -1.0 to stop: ");
            System.out.println("Your decimal is: " + decimal);
        }

        try{
            boolean dumb = parseBoolean("Hello");
        }catch (IllegalArgumentException e){
            System.out.println("Found illegal argument" + e);
        }

        boolean b = true;
        while(b == true){
            b = readBoolean("Enter boolean or false to stop: ");
            System.out.println("Your boolean is: " + b);
        }

        while(b == false){
            b = readBoolean("Enter boolean or true to stop: ");
            System.out.println("Your boolean is: " + b);
        }
    }
}

/* 
readLine:
Please enter a string or enter stop to stop: hi
Your string is: hi
Please enter a string or enter stop to stop: hello
Your string is: hello
Please enter a string or enter stop to stop: goodbye
Your string is: goodbye
Please enter a string or enter stop to stop: bye
Your string is: bye
Please enter a string or enter stop to stop: stop
Your string is: stop


readInt:
Please enter an integer or enter -1 to stop: 5
Your integer is: 5
Please enter an integer or enter -1 to stop: 5.5
Invalid input. Try again
Please enter an integer or enter -1 to stop: apple
Invalid input. Try again
Please enter an integer or enter -1 to stop: 042
Your integer is: 42
Please enter an integer or enter -1 to stop: 5a
Invalid input. Try again
Please enter an integer or enter -1 to stop: 6 3
Your integer is: 6
Please enter an integer or enter -1 to stop: 6 J
Your integer is: 6
Please enter an integer or enter -1 to stop: -1
Your integer is: -1 

readDouble:

Please enter a decimal or enter -1.0 to stop: 5.5
Your decimal is: 5.5
Please enter a decimal or enter -1.0 to stop: 6.542
Your decimal is: 6.542
Please enter a decimal or enter -1.0 to stop: .65
Your decimal is: 0.65
Please enter a decimal or enter -1.0 to stop: apple.3
Invalid input. Try again
Please enter a decimal or enter -1.0 to stop: three
Invalid input. Try again
Please enter a decimal or enter -1.0 to stop: -1.0
Your decimal is: -1.0

parseBoolean:
Found illegal argumentjava.lang.IllegalArgumentException: Your input was not valid.

readBoolean:
Enter boolean or false to stop: u
Invalid input. Try again
Enter boolean or false to stop: true
Your boolean is: true
Enter boolean or false to stop: affirmative
Your boolean is: true
Enter boolean or false to stop: yes
Your boolean is: true
Enter boolean or false to stop: false
Your boolean is: false

Enter boolean or true to stop: false
Your boolean is: false
Enter boolean or true to stop: negative
Your boolean is: false
Enter boolean or true to stop: no
Your boolean is: false
Enter boolean or true to stop: true
Your boolean is: true
 */