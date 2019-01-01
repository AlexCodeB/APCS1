import gpdraw.*;

public class Drawing{
    public static void drawImage() {
        SketchPad pad = new SketchPad(800, 800);
        DrawingTool pen = new DrawingTool(pad);

        pen.forward(100);
        pen.turn(-60);
        pen.forward(100);
        
    }
}