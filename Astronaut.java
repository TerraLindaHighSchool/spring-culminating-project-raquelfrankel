import greenfoot.*;

/**
 * A Astronaut that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Astronaut extends SmoothMover
{
    private static final int gunReloadTime = 50;         // The minimum delay between firing the gun.

    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private Vector acceleration;
    private GreenfootImage actor1 = new GreenfootImage("Astro.png");    
    //private GreenfootImage AstronautWithThrust = new GreenfootImage("AstronautWithThrust.png");
    /**
     * Initialise this Astronaut.
     */
    public Astronaut()
    {
        reloadDelayCount = 0;
        addToVelocity(new Vector(150,.5));
        acceleration = (new Vector(0, 0.3));
        addToVelocity(new Vector(13, 0.3));
        actor1.scale(90 ,110);
          setImage(actor1);
    }

     /**
     * Do what a Astronaut's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
     public void act()
    {
        move();
        checkKeyPress();
        reloadDelayCount++;
        checkCollision();
    }
    
      /**
    * Check whether there are any key pressed and react to them.
     */
   private void checkKeyPress()
    {        
       if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-4);
        }
        if (Greenfoot.isKeyDown("right")) 
       {
            setLocation(getX()+4, getY());
       }       
            if (Greenfoot.isKeyDown("left")) 
       {
            setLocation(getX()-4, getY());
       }
           if (Greenfoot.isKeyDown("down")) 
       {
            setLocation(getX(), getY()+4);
       }      
       if (Greenfoot.isKeyDown("space")) 
       {
            fire();
       }
    }   
    
    private void ignite(boolean boosterOn)
    {
        if (boosterOn) 
        {
            //setImage(AstronautWithThrust);
            acceleration.setDirection(getRotation());
            addToVelocity(acceleration);
        }
        else
        {
            setImage("Astro.png");
        }
    }
    
    /**
     * Fire a Ball if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Ball Ball = new Ball (getVelocity(), getRotation());
            getWorld().addObject (Ball, getX(), getY());
            Ball.move ();
            reloadDelayCount = 0;
        }
    }
    private void checkCollision()
    {
      if( getOneIntersectingObject(Pin.class) != null) 
      { Space space = (Space) getWorld();
        //space.addObject(new Explosion(),getX(), getY());
        space.removeObject(this);
        space.gameOver();
      }
    }

}

