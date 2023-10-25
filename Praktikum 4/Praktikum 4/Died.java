import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Died here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Died extends Props
{
    int size=60;
    public void act()
    {
        setImage("images/DIE/7_DIE_0111.png");
        size--;
        
        if(size <=0){
            World wrld = this.getWorld();
            wrld.removeObject(this);
            Greenfoot.stop();
        }
    }
}
