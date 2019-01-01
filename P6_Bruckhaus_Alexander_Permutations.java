//Permutations Reflection

//Alex Bruckhaus, Period 6, 11/16/2017
//This program took me 40 minutes.
//Overall, this program was not too difficult after I wrote the psuedocode. The only difficult part of this program was getting familiar with the lesson 15 concepts of arraylists. To do this lab,
//I had to look back at the notes a little bit to figure out how to add and remove from an array. The problem solving aspect of this program was not too difficult, but took me a little while
//to come up with. From this lab, I learned more about ArrayList and its importance and value in java. 
import java.util.ArrayList;
import java.util.Random;

/* fill second array with numbers from 1 - 10
 * loop until second array is empty
 *      max = length of second array
 *      generate random number r between 1 and max
 *      find rth element e from second array
 *      add e to result
 *      remove e from first array
 * return resul
 */

public class P6_Bruckhaus_Alexander_Permutations{
    public static ArrayList<Integer> nextPermutation(){
        ArrayList<Integer> numbers = new ArrayList();       
        ArrayList<Integer> result = new ArrayList();
        int max = 10;
        for(int i = 1; i <= max; i++){
            numbers.add(i);
        }
        Random random = new Random();
        int r;
        int e;
        for(int i = 1; i <= max; i++){
            r = random.nextInt(numbers.size());
            e = numbers.get(r);
            numbers.remove(r);
            result.add(e);
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList permutation;
        for(int i = 1; i <= 10; i++){
            permutation = nextPermutation();
            System.out.println("List " + i + ": " + permutation);
        }
    }
}