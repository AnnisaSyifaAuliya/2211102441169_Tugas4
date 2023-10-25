import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    ScoreBoard scoreBoard;
    public ScoreBoard getScoreBoard(){
        return this.scoreBoard;
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(736, 414, 1);
        spawnPlayer();
        this.scoreBoard = new ScoreBoard();
        this.addObject(scoreBoard, 60, 30);
    }

    private void spawnPlayer(){
        Random rnd = new Random();
        Character p1 = new Character();
        p1.setRotation(270);
        this.addObject(p1, rnd.nextInt(getWidth() -30), this.getHeight()-30);
    }
    
    private void spawnEnemy(){
        Random rnd = new Random();
        for(int i= 0; i<rnd.nextInt(5); i++){
            Enemy en = new Enemy();
            this.addObject(en, rnd.nextInt(this.getWidth() - 30), 5);
        }
    }
    
    public void act(){
        List<Enemy> enemy = this.getObjects(Enemy.class);
        System.out.println(enemy.size());
        if(enemy.size()==0){
            spawnEnemy();
        }
    }
    
    
}