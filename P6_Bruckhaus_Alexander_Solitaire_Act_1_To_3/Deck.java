package P6_Bruckhaus_Alexander_Solitaire_Act_1_To_3;

import java.util.ArrayList;
import java.util.Random;


/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Deck{
    private ArrayList<Card> cards;
    private int count = 0;
    /**4
     * Constructor for objects of class Deck
     */
    public Deck(){
        cards = new ArrayList<Card>();
    }

    public void add(String symbol, int value){
        Card card = new Card(symbol, value);
        cards.add(card);
        count++;
    }
    
    public boolean isEmpty(){
        return cards.size() < 1;
    }
    
    public void add(Card card){
        Card newCard = new Card(card.getSymbol(), card.getValue());
        cards.add(newCard);
        count++;
    }
    
    public Card get(int i){
        return cards.get(i);
    }
    
    public Card getTop(){
        if(cards == null || cards.size() == 0){
            return null;
        }
        return cards.get(cards.size() - 1);
    }
    
    public int size(){
        return cards.size();
    }
    
    public void removeCards(){
        cards = new ArrayList<Card>();
        count = 0;
    }
    
    public void remove(int i){
        cards.remove(i);
        count--;
    }
    
    public Card pop(){
        if(cards == null || size() < 1){
            return null;
        }
        Card card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        count--;
        return card;
    }

    public void shuffle(){
        Random r = new Random();
        Card temp;
        for(int i = 0; i < count; i++){
            int j = r.nextInt(count);
            temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public void flipUp(){
        for(int i = 0; i < cards.size(); i++){
            Card card = cards.get(i);
            card.setFaceUp(true);
        }
    }

    public void flipDown(){
        for(int i = 0; i < cards.size(); i++){
            Card card = cards.get(i);
            card.setFaceUp(false);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < cards.size(); i++){
            result += cards.get(i).toString() + ", ";
        }
        return result;
    }
}

