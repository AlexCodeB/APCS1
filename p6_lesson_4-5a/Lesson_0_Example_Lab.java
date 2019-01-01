import gpdraw.*;

public class Lesson_0_Example_Lab {
  
  public static void main(String[] args) {

    SketchPad pad = new SketchPad(600, 600, 20);
    DrawingTool pen = new DrawingTool(pad);
  
    drawPyramid(8, 500, pen);   
  }

  public static void drawPyramid(int numRows, int totalHeight, DrawingTool pen) {

    // Add code here to center the drawing and compute side length 

    // Draw the pyramid.  You may use helper methods to make things easier
    
  }
  
  // You don't have to use this helper method...
  // but it's not such a bad idea.
  public static void drawTriangle(int sideLength, DrawingTool pen) {

  }
}