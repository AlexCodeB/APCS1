import greenfoot.*;

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor {
    private int speed;
    private int hunger;
    private final GreenfootImage origImg;
    private final int MAX_HUNGER = 1000;
    private final int HUNGRY = 500;
    private final int FOOD_VAL = 100;
    
    public Creature () {
        speed = 4;
        hunger = 0;
        origImg = getImage();
    }
    
    public Creature (int speed) {
        this.speed = speed;
        hunger = 0;
        origImg = getImage();
    }
    
    public void act() {
        if (isHungry() && canEat()) {
            prepFood();
            eat();
        } else {
            turn();
            move();
            edgeLoop();
        }
        increaseHunger();
        updateHungerBar();
    }
    
    public void prepFood() {
        // subclasses may override this
    }
    
    public void move() {
        move(speed);
    }
    
    public void turn() {
        turn(Greenfoot.getRandomNumber(7) - 3);
    }
    
    public void edgeLoop() {
        int ww = getWorld().getWidth();
        int wh = getWorld().getHeight();
        int x = getX();
        int y = getY();
        if (x < 0) {
            x = ww;
        } else if (x > ww) {
            x = 0;
        }
        
        if (y < 0) {
            y = wh;
        } else if (y > wh) {
            y = 0;
        }
        setLocation(x, y);
    }
    
    public boolean canEat() {
        return intersectingFood() != null;
    }
    
    public Food intersectingFood() {
        return (Food)getOneIntersectingObject(Food.class);
    }
    
    public void eat() {
        Food food = intersectingFood();
        if (food != null) {
            hunger -= FOOD_VAL;
            getWorld().removeObject(food);
        }
    }
    
    public boolean isHungry() {
        return hunger >= HUNGRY;
    }
    
    public void increaseHunger() {
        hunger++;
        if (hunger > MAX_HUNGER) {
            die();
        }
    }
    
    public void die() {
        dropItems();
        getWorld().removeObject(this);
    }
    
    public void dropItems() {
        // do nothing
    }
    
    public void updateHungerBar() {
        GreenfootImage img = new GreenfootImage(origImg);
        img.setColor(new Color(255, 0, 0, 100));
        img.fillRect(0, 0, hunger * img.getWidth() / MAX_HUNGER, img.getHeight());
        setImage(img);
    }
}
