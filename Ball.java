import greenfoot.*;

/**
 * A ball that can hit trial2s.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Ball extends SmoothMover
{
    /** The damage this ball will deal */
    private static final int damage = 10;
    /** A ball looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    private static int pointsToAdd = 5;
    private GreenfootImage Ball = new GreenfootImage("Ball.png"); 
    /**
     * Default constructor for testing.
     */
    public Ball()
    {
        Ball.scale(30 , 30);
        setImage(Ball);
    }
    
    /**
     * Create a ball with given speed and direction of movement.
     */
    public Ball(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        //Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The ball will damage trial2s if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();           
            collision();
        }
    }

    public void collision()
    {if(isTouching(trial2.class))
        
        {
            removeTouching(trial2.class);
            pointsToAdd = pointsToAdd + 12;
            //GreenfootSound au = new GreenfootSound("bite.mp3");
            //au.play();
        }
    }
}
