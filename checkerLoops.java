import gpdraw.*;
import java.awt.*;

public class checkerLoops{
    private static  SketchPad paper = new SketchPad(300, 300);
    private static  DrawingTool pen = new DrawingTool(paper);
    public static void print(){
        pen.up();
        pen.move(87.5);
        pen.turnLeft();
        pen.move(87.5);
        pen.turn(180);
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if((row + col) % 2 == 0){
                    pen.setColor(Color.RED);                    
                }else{
                    pen.setColor(Color.BLACK);
                }
                pen.down();
                pen.fillRect(25, 25);
                pen.up();
                pen.move(25);
                // move to next col (square in row)
            }
            pen.turnRight();
            pen.move(25);
            pen.turnRight();
            pen.move(25 * 8);
            pen.turn(180);
        }
    }

    public static void main (String[] args){
        print();
    }
}