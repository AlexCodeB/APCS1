public class Example {
    private int shoes;
    private int pants;
    private int shirts;

    private Example(int shoes, int pants, int shirts) {
        this.shoes = shoes;
        this.pants = pants;
        this.shirts = shirts;
    }

    private Example() {
        shoes = 5;
        pants = 10;
        shirts = 3;
    }

    public static void main(String[] args) {
        Example e1 = new Example(1, 2, 3);
        Example e2 = new Example();
    }
}
