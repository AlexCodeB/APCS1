import greenfoot.*;

/**
 * Write a description of class Earth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Earth extends World {
    public Earth()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        addObject(new Bear(), getWidth() / 2, getHeight() / 2);
    }
    
    public void act() {
        if (Greenfoot.getRandomNumber(1000) <= 7) {
            addObject(new Pig(), getWidth() / 2, getHeight() / 2);
        } else if (Greenfoot.getRandomNumber(1000) <= 1) {
            addObject(new Bear(), getWidth() / 2, getHeight() / 2);
        } else if (Greenfoot.getRandomNumber(1000) <= 4) {
            addObject(new Berry(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        } 
    }
}
