public class Example{

    public void doThis(int num){
        System.out.println(num);
    }

    public static void main(String[] args){
        Example ex = new Example();
        //ex.doThis();
        ex.doThis(5);
        //doThis();
        //doThis(5);    
    }
}
