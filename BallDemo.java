
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a demonstration showing animation with the 
 * Canvas class. In this demo, balls will reverbate within the four 
 * walls of the box. 
 *
 * @author Dhruba Dey
 * @version 2020-Feb-05
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500,Color.white);  	
    	   	
    }

    /**
     * Simulate three bouncing balls
     */
    public void bounce()
    {        
        
        /**
        *Random selection of initial point of xPosition. An array is created to
        *store the random position and later used in the parameter to get one of 
        *the random positions
        */
    	ArrayList<Integer>arrRandx = new ArrayList<Integer>();
    	Random randx = new Random();
      	int i = 1;
    	while (i < 5)
    	{i++;
        int x = randx.nextInt(500);
        if(x <50)
          {
        	x = x+50;
          }
          arrRandx.add(x);
        }
    	
        /**
        *Random selection of initial point of yPosition. An array is created to
        *store the random position and later used in the parameter to get one of 
        *the random positions
        */           
    	ArrayList<Integer>arrRandy = new ArrayList<Integer>();
    	Random randy = new Random();
    	int j = 1;
    	while (j < 5)
    	{j++;
        int y = randy.nextInt(450);
        if(y <50)
          {
        	y = y+50;
          }
          arrRandy.add(y);
        }   
    	    	
    	/**Created random colors using rgb. Three arrays are created to store random selection of
    	 * red, green and blue pixels. Then combine the random selection of pixels in random manner to generate 
    	 * random colors of the balls.  	 
    	 */
    	     // Random pixel for red
    	ArrayList<Integer>arrRed = new ArrayList<Integer>();
    	Random randRed = new Random();
      	int r = 1;
    	while (r < 5)
    	{r++;
        int a = randRed.nextInt(256);
          arrRed.add(a);
        }
    	   // Random pixel for green
    	ArrayList<Integer>arrGreen = new ArrayList<Integer>();
    	Random randGreen = new Random();
      	int g = 1;
    	while (g < 5)
    	{g++;
        int b = randx.nextInt(256);
           arrGreen.add(b);
        }
    	   // Random pixel for blue
    	ArrayList<Integer>arrBlue = new ArrayList<Integer>();
    	Random randBlue = new Random();
      	int l = 1;
    	while (l < 5)
    	{l++;
        int c = randx.nextInt(256);
           arrBlue.add(c);
        }
    	  //combined random pixels of rgb to generate three random colors        
    	Color color1 = new Color(arrRed.get(1), arrGreen.get(1), arrBlue.get(1));
    	Color color2 = new Color(arrRed.get(2), arrGreen.get(2), arrBlue.get(2));
    	Color color3 = new Color(arrRed.get(3), arrGreen.get(3), arrBlue.get(3));
    	
    	/**
    	 * Generated ball sizes between 10 and 25 pixels. Used an array to store
    	 * random size which is used in the parameter to have its effect. 
    	 */    	   	    	
    	   // Generate random ball size
    	ArrayList<Integer>arrBallSize = new ArrayList<Integer>();
    	Random ballSize = new Random();
    	int k = 10;
    	while (k < 25)
    	{k++;
        int z = ballSize.nextInt(25);
        if(z <10)
          {
        	z = z+10;
          }
          arrBallSize.add(z);
        }   
    	
    	 // set the canvas visible    	 	                
    	myCanvas.setVisible(true);  
    	
    	/**
    	 * Created an effect of rectangle box using four rectangle along the sides of the canvas
    	 */      
         // Set foreground color to grey to draw the box
        myCanvas.setForegroundColor(Color.gray);        
        
         // draw rectangle along the sides of the canvas to create an effect
        myCanvas.fillRectangle(0,0,600,50);        
        myCanvas.fillRectangle(0,0,50,500);
        myCanvas.fillRectangle(50,450,550,50);        
        myCanvas.fillRectangle(550,50,50,450);
         
         // set the boundaries for the box
        int bottom = 450;
        int ceiling = 50;
        int leftWall = 50;
        int rightWall = 550;
        
         // crate and show the balls
        BallBox ball = new BallBox(arrRandx.get(1),arrRandy.get(1), arrBallSize.get(1),color1,bottom, ceiling, leftWall, rightWall, myCanvas);
        ball.draw();
        BallBox ball2 = new BallBox(arrRandx.get(2),arrRandy.get(2),arrBallSize.get(2),color2,bottom, ceiling, leftWall, rightWall, myCanvas);
        ball2.draw();
        BallBox ball3 = new BallBox(arrRandx.get(3),arrRandy.get(3),arrBallSize.get(3),color3,bottom, ceiling, leftWall, rightWall, myCanvas);
        ball3.draw();
        
        //make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();            
            ball3.move();  
            
            }
    }   
    
}
