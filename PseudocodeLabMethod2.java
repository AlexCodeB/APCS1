//MysteryMethod2

//This pseudocode was difficult to understand because it failed to use helper methods to simplify the code. 
//It is hard to review specific parts of the code because everything is jumbled together in 2 if statements rather
//than seperated in helper methods. To fix this code, the author should resolve the edge cases because it throws an out of bounds execption.
//Instead of saying " i + 2 <= y.length()" it should have said "i + 2 < length()" 
//After fixing the bug, the code worked correctly for all three cases.
//The author also used messy handwriting, which made it more difficult to understand.

public class PseudocodeLabMethod2{
    public static int method2(String y){
        int add = 0;
        for(int i = 0; i < y.length() - 1; i++){
            if(y.charAt(i) % 2 == 0){
                if((i + 2 <= y.length() && y.charAt(i + 2) % 2 != 0) || ((i + 1) <= y.length() 
                    && y.charAt(i + 1) % 2 != 0)){
                    add += (y.substring(i, y.length() - 1)).length();
                }
            }
        }
        return add;
    }

    public static void main(String[] args){
        System.out.println(method2("JLNWXFDNKKF"));
        System.out.println(method2("APOLOGIZE"));
        System.out.println(method2("OKJBD"));   
    }
}