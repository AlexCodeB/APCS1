public class starPyramidLoops{
    public static void print(int n){
        for(int i = 0; i <= (2 * n) - 1; i++){
            int spaces = Math.abs(n - 1 - i);
            int stars = (2 * n) - 1 - (2 * spaces);
            for(int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= stars; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        print(10);
    }
}