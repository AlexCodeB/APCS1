//Reverse_Palindrome Reflection

//Alex Bruckhaus, Period 6, 10/23/2017
//This program took me 1 hour and 30 minutes.
//Finding the stringReverseIterative solution did not take too much time and was fairly simple to complete. However, stringReverseRecursive took me a lot 
//longer to do and was more difficult to complete. It took me a while to find a solution to this problem, but after checking the lab hints, it
//helped me form a solution, while allowing me to understand the process. Finally, for isPalindrome, I used recursion to determine whether the 
//string was a palindrome as this was easier to understand for me. Although it took me a while to figure out, I eventually understood the process.
//I also used helper methods to test the methods for all the required inputs.
//This program helped me gain a better understanding of recursion, iteration, strings, and also developed my problem solving skills further.

public class P6_Bruckhaus_Alexander_Reverse_Palindrome{

    public static String stringReverseIterative(String str){
        String result = "";
        for(int i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i);
        }
        return result;
    }

    public static String stringReverseRecursive(String str){
        if(str.length() == 0){
            return str;
        }else{
            char a = str.charAt(str.length() - 1);
            String sp = str.substring(0, str.length() - 1);
            return a + stringReverseRecursive(sp);
        }
    }

    private static void testReverse(String str){
        System.out.println("input is : " + "["  + str + "]");
        System.out.println("output is : " + "[" + stringReverseIterative(str) + "] (iterative method)");
        System.out.println("output is : " + "[" + stringReverseRecursive(str) + "] (recursive method)");
    }

    public static boolean isPalindrome(String str){
        str = str.replaceAll("[,': !.*?&]","");
        str = str.toLowerCase();
        if(str.length() < 2){
            return true;
        }else{
            if(str.charAt(0) != str.charAt(str.length() - 1)){
                return false;
            }else{
                String next = (str.substring(1, str.length() - 1));
                return isPalindrome(next);
            }
        }
    }
    
    private static void testPalindrome(String str){
        System.out.println("input is: " + "[" + str + "]");
        System.out.println("  -> output is: " + isPalindrome(str));
    }
    
    public static void main(String[] args){
        //System.out.println(stringReverseRecursive("123456789"));
        testReverse("123456789");
        testReverse("12345678");
        testReverse("A");
        testReverse("empty string");
        testReverse("");
       
        testPalindrome("radar");
        testPalindrome("J");
        testPalindrome("Lewd did I live, & evil I did dwel.");
        testPalindrome("I like Java");
        testPalindrome("Straw? No, too stupid a fad, I put soot on warts.");
        testPalindrome("***Nurse!*** I spy gypsies....run!!!!!");
        testPalindrome("empty string");
        testPalindrome("");
    }
}