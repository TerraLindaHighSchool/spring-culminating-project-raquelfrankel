import greenfoot.*;

/**
 * A rock in space.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Pin extends SmoothMover
{
    /** Size of this asteroid */
    private int size;

    /** When the stability reaches 0 the asteroid will explode */
    private int stability;
    
    /**
     * Create an asteroid with default size and random direction of movement.
     */
    public Pin()
    {
        this(90);
    }
    
    /**
     * Create an asteroid with a given size and random direction of movement.
     */
    public Pin(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    private int m_Speed = 100;
    /**
     * Create an asteroid with a given size and direction of movement.
     */
    public Pin(int size, Vector velocity)
    {
        super(velocity);
        setSize(size);
    }
    
    public void act()
    {         
       move();       
       setLocation(getX()-1, getY()-2);

    
    }

    /**
     * Set the size of this asteroid. Note that stability is directly
     * related to size. Smaller asteroids are less stable.
     */
    public void setSize(int size) 
    {
        stability = size;
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }

    /**
     * Return the current stability of this asteroid. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
    
    /**
     * Hit this asteroid dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 5) 
        {
            breakUp();
        }
    }
    
    /**
     * Break up this asteroid. If we are still big enough, this will create two
     * smaller asteroids. If we are small already, just disappear.
     */
    private void breakUp() 
    {
        Greenfoot.playSound("Explosion.wav");
        
        if (size <= 16) {
            getWorld().removeObject(this);
        }
        else {
            int r = getVelocity().getDirection() + Greenfoot.getRandomNumber(45);
            double l = getVelocity().getLength();
            Vector speed1 = new Vector(r + 60, l * 1.2);
            Vector speed2 = new Vector(r - 60, l * 1.2);        
            Pin a1 = new Pin(size/2, speed1);
            Pin a2 = new Pin(size/2, speed2);
            getWorld().addObject(a1, getX(), getY());
            getWorld().addObject(a2, getX(), getY());        
            a1.move();
            a2.move();
        
            getWorld().removeObject(this);
        }
    }
    public static void setSpeed(int speed)
    {
      //speed - 2();
    
    }
}
