package P6_Bruckhaus_Alexander_Solitaire_Act_1_To_3;

public class DeckTester{
    public static void main(String[] args){
        Deck deck = new Deck();
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for(int i = 0; i < values.length; i++){
            deck.add(symbols[i], values[i]);
        }
        System.out.println("Testing print deck: " + deck);
        System.out.println("Flipping deck");
        deck.flipUp();
        System.out.println("Testing print deck: " + deck);
        System.out.println("Shuffling deck");
        deck.shuffle();
        deck.flipUp();
        System.out.println("Testing print deck: " + deck);
        System.out.println("Flipping deck");
        deck.flipDown();
        System.out.println("Testing print deck: " + deck);

        for(int i = 0; i < 5; i++){
            deck.add(symbols[i], values[i]);
        }
        System.out.println("Testing print deck: " + deck);
        System.out.println("Flipping deck");
        deck.flipUp();
        System.out.println("Testing print deck: " + deck);
        System.out.println("Shuffling deck");
        deck.shuffle();
        deck.flipUp();
        System.out.println("Testing print deck: " + deck);
        System.out.println("Flipping deck");
        deck.flipDown();
        System.out.println("Testing print deck: " + deck);
    }
}