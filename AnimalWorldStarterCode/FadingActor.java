import greenfoot.*;

/**
 * Write a description of class FadingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FadingActor extends Actor {
    public void act() {
        getImage().setTransparency(getImage().getTransparency() - 1);
        if (getImage().getTransparency() == 0) {
            getWorld().removeObject(this);
        }
    } 
}
