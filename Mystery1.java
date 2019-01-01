
class Mystery1{
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

    public static void main(String[] args){
        System.out.println(mysteryMethod1("+hijnp+hqrnr"));
        System.out.println(mysteryMethod1("MANOMANNERS"));
        System.out.println(mysteryMethod1("OK"));
    }
}