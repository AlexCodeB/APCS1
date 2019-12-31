import java.util.Random;
import java.util.Scanner;

public class StringCraft {
    private static void play() {
        System.out.println("Welcome to String Craft");
        int length = getLength();
        String string = genString(length);
        int score = getScore(string);
        System.out.println(string + " is worth " + score + " points");
        int[] swapped;
        int moves = 1;
        while (hasMoves(string, score, moves)) {
            System.out.println("NOTE: " + string + " is worth " + score + " points");
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
        //System.out.println(getScore("AAAB"));
        play();

    }
}