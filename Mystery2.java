class Mystery2{
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

    public static void main(String[] args){
        System.out.println(mysteryMethod2("JLNWXFDNKKF"));
        System.out.println(mysteryMethod2("OKJBD"));
        System.out.println(mysteryMethod2("APOLOGIZE"));
        
    }
}



//METHOD 1

/* score = sum of valid characters
 * valid = one's digit of ascii value
 * valid == i - 1 or i + 1 to special
 * special = (value = first or last char of string)
 * 
 * 
 * calcScore(String str)
 *    score = 0
 *    for(i from 0 to str length)
 *      if(valid(c))
 *        score = score + one digit of asci
 *      }
 *    }  
 * 
 *  oneDigit(String str, char c, int i)
 *     if(i = valid)
 *       v = str.charAt(i) % 10
 *     return v;
 *     
 *  valid(String str, char c, int i)
 *     if(str.charAt(i) == special + 1 or str.charAt(i) == special - 1)
 *       return true;
 *     else
 *       return false;
 *       
 *   special(char c, String str, int i)
 *      if(str.charAt(i) == str.charAt(0) or str.charAt(i) == str.charAt(str.length () - 1)
 *         return true
 *      else
 *         return false
 */






















//METHOD 2
/* score = sum of score of valid characters in string
 * valid character points = distance from end of string
 * valid = !special and special char at i + 1 or i + 2
 * special char = odd char
 * 
 * calcScore(String str)
 *   score = 0;
 *   for(i from 0 to str length)
 *     c = str.charAt(i);
 *     if(valid(c))
 *       increase score by value of c
 *     
 * value(char c, String str, int i )
 *   v = str length - i
 *   return v
 *  
 * valid(char c, String str, int i)
 *   if(special(c){
 *     return false
 *   }else if(special(char at (i + 1)) or special(char at i + 2))
 *     return true;
 *   return false;
 *        
 * special(char c)
 *   if(char at i % 2 is not 0)
 *     return true
 *   else
 *     return false  
 */

