package AnimalWorldStarterCode;

//AnimalWorld Reflection

//Alex Bruckhaus, Period 6, 11/26/2017
//This program took me 1 hour.
//This program was more enjoyable than previous assignments because it was fun to almost literally see my code come to life. In addition to enjoying
//it a little more than usual, I also continued to learn about inheritance, and in this case, a more visual example of it. 
//One issue I ran into during this assignment was an OutOfOBoundsException in the turn method when I wanted the bear to turn
//toward the pig or the food. To fix this, I made a condition that checks if the pig or food size is greater than 0. Other than
//that, I did not run into many issues during this assignment. Overall, this assignment was a fun way to continue my learning with inheritance.


import greenfoot.*;
import java.util.List;

public class Pig extends Creature {
    /** override the dropItems() method so a Meat object is added to the world at
     * the same location as this pig
     */
    public void dropItems(){
        getWorld().addObject(new Meat(), getX(), getY());
    }

    /**
     * Override the turn() method so the pig will turn toward nearby berries (within 100 cells)
     * if hungry.
     */
    public void turn(){
        List<Berry> berries = getObjectsInRange(100, Berry.class);
        if(super.isHungry() && berries.size() > 0){
            Berry berry = berries.get(0);
            turnTowards(berry.getX(), berry.getY());
        }else{
            super.turn();
        }
    }

    /**
     * Override the isHungry() method to make the pig always hungry.
     */
    public boolean isHungry() {
        return true;
    }
}
