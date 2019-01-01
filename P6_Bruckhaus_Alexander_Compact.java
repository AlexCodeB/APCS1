import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class P6_Bruckhaus_Alexander_Compact{
    public static int[] compactArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                int from = i + 1;
                int to = i;
                while(from < arr.length && to < arr.length){
                    if(arr[from] != 0){
                        arr[to] = arr[from];
                        arr[from] = 0;
                        from++;
                        to++;    
                    }else{
                        from++;
                    }
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> compactArrayList(ArrayList<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == 0){
                arr.remove(i);
                i--;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner in = null;

        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[100];
        int i = 0;
        try{
            in = new Scanner(new File("/Users/family/APCS1/compact.txt"));
            while(in.hasNextLine()){
                int o = in.nextInt();
                list.add(o);
                arr[i] = o;
                i++;
            }
            in.close();
        }catch (IOException e){
            System.out.println("Error: could not read from file.");
        }
        System.out.println("Array:     " + Arrays.toString(arr));
        System.out.println("ArrayList: " + list);

        System.out.println(Arrays.toString(compactArray(arr)));
        System.out.println(compactArrayList(list));
    }
}