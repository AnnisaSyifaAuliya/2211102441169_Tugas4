import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Characters
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int speed = 10;
    int bulletspeed= 10;
    int cooldown= 20;
    int lastShotTimer= 0;
    public Character(){
        setImage("images/IDLE/1_IDLE_0000.png");
    }
    
    private void tembak(){
        World wrld = this.getWorld();
        Bullet bullet = new Bullet(bulletspeed);
        bullet.setRotation(this.getRotation());
        wrld.addObject(bullet, this.getX(), this.getY());
    }
    
    public void act()
    {
        this.move(1);
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
            setRotation(0);
        }
        
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
            setRotation(0); 
        }
        
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
            setRotation(180); 
        }
        
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + speed, getY());
            setRotation(0); 
        }
        
        if(lastShotTimer < cooldown && lastShotTimer > 0){
            lastShotTimer ++;
        }
        
        if(Greenfoot.isKeyDown("space") && lastShotTimer == 0){
            tembak();
            lastShotTimer++;
        } 
        
        if(lastShotTimer == cooldown){
            lastShotTimer = 0;
        }
        
        if(this.isTouching(Enemy.class)){
            World wrld = this.getWorld();
            Died d = new Died();
            wrld.addObject(d, this.getX(), this.getY());
            wrld.removeObject(this);
        }
    }
}