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

public class Bear extends Creature {
    /**
     * Make a constructor that initializes speed to 5. To do this you will need
     * to call the correct super constructor.
     */
    public Bear(){
        super(5);
    }

    /** override the prepFood() method so it gets an intersecting pig and kills it if there is one
     */
    public void prepFood(){
        Pig pig = (Pig)getOneIntersectingObject(Pig.class);
        if(pig != null){
            pig.die();  
        }
    }

    /** Override canEat() so it will return true if the super class method
     * would have returned true, but also returns true if touching a pig.
     * Otherwise it should return false.
     * */

    public boolean canEat(){
        if(super.canEat() || isTouching(Pig.class)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Override the turn() method so that it will turn toward nearby pigs or food
     * if the bear is hungry. Lets say nearby means within 100 cells.
     * If there are no pigs or food in range, this method should do the same as the
     * super class method.
     */
    public void turn(){
        List<Pig> pigs = getObjectsInRange(100, Pig.class);
        List<Food> foods = getObjectsInRange(100, Food.class);
        boolean foodInRange = (pigs.size() > 0) || (foods.size() > 0);
        if(super.isHungry() && foodInRange){
            if(pigs.size() > 0){
                Pig pig = pigs.get(0);
                turnTowards(pig.getX(), pig.getY());
            }else{
                Food food = foods.get(0);
                turnTowards(food.getX(), food.getY());
            }
        }else{
            super.turn();
        }
    }

    /** override the dropItems() method so a DeadBear object is added to the world at
     * the same location as this bear
     */
    public void dropItems(){
        getWorld().addObject(new DeadBear(), getX(), getY());
    }
}
