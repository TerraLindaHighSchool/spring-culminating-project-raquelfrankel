import greenfoot.*;

/**
 * Space. Something for Astronauts to fly in.
 * 
 * @author raquel frankel
 * @version 1.1
 */
public class Space extends World
{
    //public GreenfootImage Space = new GreenfootImage("newSpace.jpg");
    private Counter scoreCounter;
    private int starttrialtrial2s = 3;
    private int score;
    private int target;
    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {      
        super(700, 700, 1);
        Astronaut Astronaut = new Astronaut();
        addObject(Astronaut, getWidth()/2 + 1, getHeight()/2);

        addtrialtrial2s(starttrialtrial2s);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        //Explosion.initializeImages();
        //ProtonWave.initializeImages();

        addtrialtrial2s(starttrialtrial2s);
        paintStars(300);
        prepare();
    }

    /**
     * Add a given number of trialtrial2s to our world. trialtrial2s are only added into
     * the left half of the world.
     */
    private void addtrialtrial2s(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Pin(), x, y);
        }
    }

    /**
     * adds varrying stars to background of world
     */
    private void paintStars(int count)
    {
        //loop from zero to count
        {
            GreenfootImage background = getBackground();
            for(int i = 0; i < count; i++)
            {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());

                int deltaRed = Greenfoot.getRandomNumber(80) - 40;
                int deltaGreen = Greenfoot.getRandomNumber(80) - 40;
                int deltaBlue = Greenfoot.getRandomNumber(80) - 40;

                int starBrightness = Greenfoot.getRandomNumber(120) + 80;

                Color StarColor = new Color(starBrightness + deltaRed, starBrightness + deltaGreen, starBrightness + deltaBlue);

                int starSize = Greenfoot.getRandomNumber(3) + 1;

                background.setColor(StarColor);
                background.fillOval(x, y, starSize, starSize);
            }

        }
    }

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        int x = getWidth() / 2;
        int y = getHeight() / 2;
         int currentScore = scoreCounter.getValue();
        addObject(new ScoreBoard(currentScore), x ,y); 
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }

    public void updateScore(int addToScore)
    {
      scoreCounter.add(addToScore);
      target += score;
    }
    
    public void act()
    {
     if (Greenfoot.getRandomNumber(100) < 3)
        {
            switch(Greenfoot.getRandomNumber (100))
            {
               case 0: addObject(new shootingStar(), 9, Greenfoot.getRandomNumber(100)); break;
              // case 1: addObject(new trial2(), 90, Greenfoot.getRandomNumber(100)); break;              
            }
        }
    }
}