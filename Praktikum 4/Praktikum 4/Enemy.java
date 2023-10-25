import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Characters
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemy(){
        setImage("pumpkin 3.png");
    }
    
    public void act(){
        this.move(6);
        World wrld = this.getWorld();
        
        List<Character> pls =this.getNeighbours(300, true, Character.class);
        if(pls.size()>0){
            this.turnTowards(pls.get(0).getX(),pls.get(0).getY());
        }
        
        if(this.isTouching(Bullet.class)){
            ScoreBoard scoreBoard = wrld.getObjects(ScoreBoard.class).get(0);
            scoreBoard.addScore(1);
            this.removeTouching(Bullet.class);
            wrld.removeObject(this);
            return;
        }
        
        if(this.getY() == wrld.getHeight()-1){
            wrld.removeObject(this);
        }
    }
}
