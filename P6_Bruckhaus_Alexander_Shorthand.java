//Shorthand Reflection

//Alex Bruckhaus, Period 6, 29 October 2017
//This program took me 4 hours.
//This lab was the most time consuming and difficult assignment of the year so far. However, I learned a lot about strings and loops while completing this lab. Originally, the base problem of
//replacing the special words and removing vowels was fairly simple, but figuring out how to account for the special conditions is what was difficult. I began to write down different
//scenarios on paper and psuedocode, which helped me very much visualize my errors and progress through out the assignment. I also created multiple helper methods to help organize my work,
//making everything easier to follow and debug. Overall, this assignment helped me tremendously with my understanding of loops, strings, and java syntax in general.

public class P6_Bruckhaus_Alexander_Shorthand{
    public static String translateToShorthand(String str){
        System.out.println("Original: " + str);
        str = replaceWords(str);
        str = replaceVowels(str);
        System.out.println("Shorthand: " + str);
        return str;
    }

    public static String replaceWords(String str){
        for(int i = 0; i < str.length(); i++){
            str = replaceWord(str, i, "and", "&");
            str = replaceWord(str, i, "to", "2");
            str = replaceWord(str, i, "you", "u");
            str = replaceWord(str, i, "for", "4");
        }
        return str;
    }

    public static String replaceWord(String str, int i, String word, String replaced){
        if(i > str.length() - word.length()){
            return str;
        }
        if(!str.substring(i, i + word.length()).equalsIgnoreCase(word)){
            return str;
        }
        if(i + word.length() < str.length() && Character.isLetterOrDigit(str.charAt(i + word.length()))){
            return str;
        }
        if(i > 0 && Character.isLetterOrDigit(str.charAt(i - 1))){
            return str;
        }
        return str.substring(0, i) + replaced + str.substring(i + word.length(), str.length());
    }

    public static String replaceVowels(String str){
        int i = 0;
        while(i < str.length()){
            int length = str.length();
            str = replaceVowel(str, i, 'a');
            str = replaceVowel(str, i, 'e');
            str = replaceVowel(str, i, 'i');
            str = replaceVowel(str, i, 'o');
            str = replaceVowel(str, i, 'u');
            if(str.length() == length){
                i++;
            }
        }
        return str;
    }

    public static String replaceVowel(String str, int i, char vowel){
        if(i < str.length() && !vowelAlone(str, i) && Character.toLowerCase(str.charAt(i)) == vowel){
            str = str.substring(0, i); 
            if (i + 1 < str.length()){
                str += str.substring(i + 1, str.length());
            }
        }
        return str;
    }

    public static  boolean vowelAlone(String str, int i){
        if((i > 0 && Character.isLetterOrDigit(str.charAt(i - 1))) || ((i < str.length() && Character.isLetterOrDigit(str.charAt(i + 1))))){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        translateToShorthand("!!aNd!! !tO? ****yOu***foR** fork toward young fo");
        translateToShorthand("And...nOW back $!to** you-->Andy.I.--aNd--Sandy.A. FoR tHe WEaTHer...fORtune...a");
        translateToShorthand("A truck");
        translateToShorthand("Me AND YOU forever!");
        translateToShorthand("To Bill and Ted: Are you going to be EXCELLENT to towtrucks too???");
        translateToShorthand("Look, here's a 3.14159 I made for you! And? How's it taste?");
        translateToShorthand("MY mAmA aLWaYs said, \"LIFe iS like a box of chocolates...you never know what you're gonna get!\"");
        translateToShorthand("!!aNd!! !tO? ****yOu***foR** fork toward young fo");
    }
}