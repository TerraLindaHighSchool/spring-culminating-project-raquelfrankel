 
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shootingStar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class shootingStar extends Actor
{ private GreenfootImage shootingStar = new GreenfootImage("star.png");
    
    /**
     * Constructor: Set up the starting objects.
     */
    public shootingStar()
    {    
        shootingStar.scale(30 , 30);
        setImage(shootingStar);
    }   
    private int m_Speed = 9;
    /**
     * Act - do whatever the shootingStar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        setLocation(getX() - m_Speed, getY());       
    if(getX() == 0)
    {
        getWorld().removeObject(this);
    }
    }          
}   
