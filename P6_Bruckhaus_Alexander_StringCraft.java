//StringCraft

//Alex Bruckhaus, Period 6, 11/12/2017
//This program took me 4 hours and 30 minutes.
//This program was the most time consuming lab so far this year. However, I did learn a lot during the process of completing this assignment. I found that using helper methods was extremely useful to help
//organize my work and code. It also helped me debug my code, which took about an hour to do. Using helper methods, I could identify where and why my code was not working with precision and resolve it.
//However, it was no simple task to complete this assignment as I got stuck in a couple of places. One of the most challenging areas for me was to complete the askUserSwap() and swapIndexString() method. 
//I used arrays to identify the tokens where an integer appeared and then swapped the tokens using substring. And from there I checked the edge cases and implemented try and catch if the user
//entered something that was invalid. My technique was to get down the basics of the game first, and then account for the little details such as printing "That was is illegal because..." in the end.
//Although this program took me several hours, I am satisfied with the outcome and the amount I learned from writing this program.

import java.util.Random;
import java.util.Scanner;

public class P6_Bruckhaus_Alexander_StringCraft {
    public static void play() {
        System.out.println("Welcome to String Craft");
        int length = getLength();
        String string = genString(length);
        int score = getScore(string);
        System.out.println(string + " is worth " + score + " points");
        int[] swapped;
        int moves = 1;
        while (hasMoves(string, score, moves)) {
            swapped = askUserSwap(length);
            String newString = swapIndexString(string, swapped[0], swapped[1]);
            int newScore = getScore(newString) - moves;
            if(newScore < score){
                System.out.println("That move is illegal because it would lower your score to " + newScore);
                continue;
            }
            score = newScore;
            string = newString;
            moves++;
            System.out.println(string + " is worth " + score + " points");
        }
        System.out.println("Game over! Your final score is: " + score + " points.");
    }

    private static int[] askUserSwap(int length) {
        Scanner in = new Scanner(System.in);
        int[] result = new int[2];
        while(true) {
            System.out.print("Enter two indexes separated by a space you wish to swap: ");
            String line = in.nextLine();
            String[] tokens = line.split(" ");
            try {
                result[0] = Integer.parseInt(tokens[0]);
                result[1] = Integer.parseInt(tokens[1]);
            }catch (NumberFormatException e){
                System.out.println("Please enter two valid swap indexes");
                continue;
            }
            if(result[0] < length && result[1] < length && result[0] >= 0 && result[1] >= 0){
                return result;
            }
        }
    }

    private static String swapIndexString(String str, int index1, int index2) {
        String result;
        char char1 = str.charAt(index1);
        char char2 = str.charAt(index2);
        result = str.substring(0, index1);
        result += char2;
        result += str.substring(index1 + 1, index2);
        result += char1;
        result += str.substring(index2 + 1, str.length());
        return result;
    }

    private static boolean hasMoves(String str, int score, int moves) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String newString = swapIndexString(str, i, j);
                int newScore = getScore(newString);
                if (newScore - moves >= score) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getScore(String str) {
        int score = 0;
        int prevValue = 0;
        int curValue;
        for (int i = 0; i < str.length(); i++) {
            if (isRepeat(str, i)) {
                curValue = prevValue + 2;
            } else if (isRun(str, i)) {
                curValue = prevValue + 1;
            } else {
                curValue = 1;
            }
            score += curValue;
            prevValue = curValue;
        }
        return score;
    }

    private static boolean isRepeat(String str, int i) {
        if (i - 1 >= 0 && str.charAt(i) == str.charAt(i - 1)) {
            return true;
        }
        return false;
    }

    private static boolean isRun(String str, int i) {
        if (i - 1 >= 0 &&
                (str.charAt(i) == str.charAt(i - 1) + 1 || (str.charAt(i) == 'A' && str.charAt(i - 1) == 'Z'))) {
            return true;
        }
        return false;
    }

    private static int getLength() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the string you would like to craft: ");
        return in.nextInt();
    }

    private static String genString(int length) {
        String str = "";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            int n = r.nextInt(26) + 65;
            str += (char) n;
        }
        return str;
    }

    public static void main(String[] args) {
        play();
    }
}