import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.Arrays;

public class P6_Bruckhaus_Alexander_CommonList{
    private static void printList(ArrayList<Integer> ints){
        boolean first = true;
        System.out.print("[");
        for(Integer i: ints){
            if(!first){
                System.out.print(" ");
            }
            System.out.print(i);
            first = false;
        }
        System.out.println("]");
    }

    private static ArrayList<Integer> randomList(int n , int a , int b){
        ArrayList<Integer> l = new ArrayList<Integer>();
        Random r = new Random();
        for(int i = 0; i < n; i++){
            int num = r.nextInt((b - a) + 1) + a ;
            l.add(num);
        }
        return l;
    }

    private static void removeNegatives(ArrayList<Integer> nums){
        Iterator<Integer> i = nums.iterator();
        while(i.hasNext()){
            if(i.next() < 0){
                i.remove();
            }
        }
    }

    private static ArrayList<Integer> commonList(ArrayList<Integer> list1, ArrayList<Integer> list2 ){
        ArrayList<Integer> commonList = new ArrayList<Integer>();
        boolean found = false;
        for(int i = 0; i < list1.size(); i++){
            for(int j = 0; j < list2.size(); j++){
                if(list1.get(i) == list2.get(j)){
                    found = false;
                    for(int k = 0; k < commonList.size(); k++){
                        if(commonList.get(k) == list1.get(i)){
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    } else{
                        commonList.add(list1.get(i));
                        break;
                    }
                }
            }
        }
        return commonList;
    }

    public static void main(String[]args){        
        ArrayList<Integer> a = new ArrayList<Integer>();
        Random r = new Random();
        for(int i = 0; i < 25; i++){
            int random = r.nextInt(16) - 5;
            a.add(random);
        }
        
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int i = 0; i < 25; i++){
            int random = r.nextInt(16) - 5;
            b.add(random);
        }

        System.out.println("BEFORE: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
          
        System.out.println("AFTER REMOVING NEGATIVES: ");
        removeNegatives(a);
        removeNegatives(b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        System.out.println("COMMON LIST: ");
        printList(commonList(a, b));

    }
}

