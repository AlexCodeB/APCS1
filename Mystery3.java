class Mystery3{
    
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
        System.out.println(mysteryMethod3("ab"));
        System.out.println(mysteryMethod3("aBc 123"));
        System.out.println(mysteryMethod3("@YaY!"));
        
    }
}


//METHOD 3

/* 
 * 
 * calcScore(String str)
 *    score = 0
 *    for(i from 0 to str length)
 *      if(char at i is not A - Z or a - z)
 *         score = ASCII value of char + 3
 *      else if(char at i is A -Z but not a - z)
 *         score = ASCII value minus 32
 *      else
 *          score = ASCII value plus 32
 *      return score;
 *  
 * 
 * 
 * 
 */



