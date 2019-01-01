public class P6_Bruckhaus_Alexander_MysteryMethods{
    
    //METHOD 1
    public static int mysteryMethod1(String str){
        int score = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(isValid(str, i)){
                score += onesDigit(str, c, i);
            }
        }
        return score;
    }

    private static int onesDigit(String str, char c, int i){
        int v = 0;
        if(isValid(str, i)){
            v = str.charAt(i) % 10;
        }
        return v;
    }

    private static boolean isValid(String str, int i){
        if((i + 1 < str.length() && isSpecial(str, i + 1) || (i - 1 >= 0 && isSpecial(str, i - 1)))){
            return true;
        }
        return false;
    }

    private static boolean isSpecial(String str, int i){
        if(str.charAt(i) == str.charAt(0) || str.charAt(i) == str.charAt(str.length() - 1)){
            return true;
        }
        return false;
    }
    
    
    //METHOD 2
    public static int mysteryMethod2(String str){
        int score = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(isValid(c, str, i)){
                score += calcValue(str, i);
            }
        }
        return score;
    }

    private static int calcValue(String str, int i){
        int v = str.length() - i - 1;
        return v;
    }

    private static boolean isValid(char c, String str, int i){
        if(isSpecial(c)){
            return false;
        }else if((i + 1 < str.length() && isSpecial(str.charAt(i + 1))) || 
        (i + 2 < str.length() && isSpecial(str.charAt(i + 2)))){
            return true;
        }
        return false;
    }

    private static boolean isSpecial(char c){
        if(c % 2 != 0){
            return true;
        }
        return false;
    }
    
    
    //METHOD 3
    public static int mysteryMethod3(String str){
        int score = 0;
        for(int i = 0; i < str.length(); i++){
            if(isUpper(str, i)){
                score = score + str.charAt(i)  + 32;
            }else if(isLower(str, i)){
                score = score + str.charAt(i) - 32;
            }else{
                score = score + str.charAt(i) + 3;
            }
        }
        return score;
    }

    private static boolean isNonAlpha(String str, int i){
        return (str.charAt(i) < 65 || str.charAt(i) > 122) || (str.charAt(i) >= 91 || str.charAt(i) <= 96);
    }

    private static boolean isUpper(String str, int i){
        return str.charAt(i) >= 65 && str.charAt(i) <= 90;
    }

    private static boolean isLower(String str, int i){
        return str.charAt(i) >= 97 && str.charAt(i) <= 122;
    }

    public static void main(String[] args){
        System.out.println(mysteryMethod1("+hijnp+hqrnr"));
        System.out.println(mysteryMethod1("MANOMANNERS"));
        System.out.println(mysteryMethod1("OK"));

        System.out.println(mysteryMethod2("APOLOGIZE"));
        System.out.println(mysteryMethod2("JLNWXFDNKKF"));
        System.out.println(mysteryMethod2("OKJBD"));

        System.out.println(mysteryMethod3("ab"));
        System.out.println(mysteryMethod3("aBc 123"));
        System.out.println(mysteryMethod3("@YaY!"));
    }

}