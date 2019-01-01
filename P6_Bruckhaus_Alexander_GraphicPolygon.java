//GraphicPolygon Reflection

//Alex Bruckhaus, Period 6, 11/21/2017
//This program took me 1 hour.
//Overall, this program went fairly smooth, as I only ran into a couple of issues. I spent the majority of the time trying to figure out how to draw the polygon, but after several minutes of actually drawing it 
//with a pen and paper, it became easier and easier for me to accomplish. After figuring this out, the rest of the program came easy for me. From this program, I learned a lot more about inheritance and
//learned a little more about actual polygons while completing this assignment. This assignment cleared up prior confusion of super classes and subclasses for me as well.



import gpdraw.*;
public class P6_Bruckhaus_Alexander_GraphicPolygon{
    class RegularPolygon {
        private int myNumSides;         // # of sides
        private double mySideLength;    // length of side
        private double myR;             // radius of circumscribed circle
        private double myr;             // radius of inscribed circle
        // constructors
        public RegularPolygon() {       // default constructor
            myNumSides = 3;
            mySideLength = 100;
            calcR();
            calcr();
        }

        public RegularPolygon(int numSides, double sideLength) {
            myNumSides = numSides;
            mySideLength = sideLength;
            calcR();
            calcr();
        }
        // private methods
        private void calcr() {
            myr = mySideLength / (2*Math.tan(Math.PI/myNumSides));
        }

        private void calcR() {
            myR = mySideLength / (2*Math.sin(Math.PI/myNumSides));
        }
        // public methods
        public double vertexAngle() {
            return (myNumSides - 2) * 180 / myNumSides; // return value is in DEGREES
        }

        public double Perimeter() {
            return myNumSides * mySideLength;
        }

        public double Area() {
            return myNumSides * mySideLength * myr / 2;
        }

        public double getNumSide() {
            return myNumSides;
        }

        public double getSideLength() {
            return mySideLength;
        }

        public double getR() {
            return myR;
        }

        public double getr() {
            return myr;
        }
    }

    class GraphicPolygon extends RegularPolygon{
        private DrawingTool pen = new DrawingTool(new SketchPad(400, 400));
        private double xPosition, yPosition;

        // constructors

        // Initializes a polygon of numSides sides and sideLength
        // length in the superclass. The polygon is centered at
        // xPosition = yPosition = 0
        public GraphicPolygon(int numSides, double sideLength){
            super(numSides, sideLength);
            xPosition = 0;
            yPosition = 0;
        }

        // Initializes a polygon of numSides sides and sideLength
        // length in the superclass. The polygon is centered at
        // xPosition = x and yPosition = y
        public GraphicPolygon(int numSides, double sideLength, double x, double y){
            super(numSides, sideLength);
            xPosition = x;
            yPosition = y;
        }

        public void setX(double x){
            xPosition = x;
        }

        public void setY(double y){
            yPosition = y;
        }

        // public methods

        // Sets xPosition = x and yPosition = y to correspond to the new
        // center of the polygon
        public void moveTo(double x, double y){
            setX(x);
            setY(y);
        }

        // Draws the polygon about the center point (xPosition, yPosition).
        // Uses properties inherited from RegularPolygon to determine the
        // number and length of the sides, the radius of the inscribed circle,
        // and the vertex angle with which to draw the polygon
        public void draw(){
            double angle = 360 / getNumSide();
            pen.up();
            pen.move(xPosition, yPosition);
            pen.setDirection(0);
            pen.forward(getR());
            pen.turn(180);
            pen.turn(-vertexAngle() /2);
            pen.down();
            for(int i = 0; i < getNumSide(); i++){
                pen.forward(getSideLength());
                pen.turn(angle);
            }
        }
    }

    public static void main(String[] args){
        GraphicPolygon sPoly = new P6_Bruckhaus_Alexander_GraphicPolygon().new GraphicPolygon(4, 150);
        sPoly.draw();

        
        GraphicPolygon oPoly = new P6_Bruckhaus_Alexander_GraphicPolygon().new GraphicPolygon(8, 100);
        oPoly.draw();
        
        GraphicPolygon enPoly = new P6_Bruckhaus_Alexander_GraphicPolygon().new GraphicPolygon(19, 50);
        enPoly.draw();
        
        GraphicPolygon ennPoly = new P6_Bruckhaus_Alexander_GraphicPolygon().new GraphicPolygon(91, 10);
        ennPoly.draw();

    }

}