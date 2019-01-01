public class Passing {
    private static void subtractOneInt(int i) {
        i--;
    }

    public static void subtractOneInteger(Integer i) {
        i--;
    }

    public static void main(String[] args) {
        int j = 7;
        System.out.println("j before: " + j);
        subtractOneInt(j);
        System.out.println("j after: " + j);

        Integer k = 7;
        System.out.println("k before: " + k);
        subtractOneInteger(k);
        System.out.println("k after: " + k);
    }
}
