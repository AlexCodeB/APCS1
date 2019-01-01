public class Plot {
    public static int multiplyThis(int x, int y) {
        return x * y;
    }

    public static int multiplyThis(int x, int y, int z) {
        return x * y * z;
    }

    public static void main(String[] args){
        int product1 = multiplyThis(4, 6);
        int product2 = multiplyThis(7, 2, 5);

        System.out.println("Product 1: "+product1);
        System.out.println("Product 2: "+product2);
    }
}
