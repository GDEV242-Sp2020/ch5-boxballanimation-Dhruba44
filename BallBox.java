import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BallBox - a graphical ball that observes the effect of constant speed of 7 in all direction. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will move up and down, and sidewise with a constant speed, and bounce to sides of the boxwalls to change 
 * direction of its movement. 
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 * @version 05.22.2016
 * 
 * @author Dhruba Dey
 * @version 02.05.2020
 */

public class BallBox
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int bottomPosition;      // y position of ground
    private int ceilingPosition;		// y position of ceiling of the box
    private int leftWall; 			// x position of left wall
    private int rightWall;			// x position of right wall
    private Canvas canvas;
    private int ySpeed = 7;                // initial downward speed
    private int xSpeed = 7;                // initial horizontal speed    

    /**
     * Constructor for objects of class B
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param boxBottom  the position of the box bottom
     * @param boxTop  the position of the box bottom
     * @param boxRightWall  the position of the box bottom
     * @param boxLeftWall  the position of the box bottom
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BallBox(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int boxBottom, int boxTop, int boxLeftWall, int boxRightWall, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        bottomPosition = boxBottom;
        ceilingPosition = boxTop;
        leftWall = boxLeftWall;
        rightWall = boxRightWall;
        canvas = drawingCanvas;
    }
    
    /**
     * Draw this ball at its current position onto the canvas.
    **/
    public void draw()
    {
    	canvas.setForegroundColor(color);
    	canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
       canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position                  
          yPosition += ySpeed;
          xPosition +=xSpeed;
          
        // change the direction when the ball hits the bottom, ceiling, and side walls
        if(yPosition >= (bottomPosition - diameter))      
        {   yPosition = (int)(bottomPosition - diameter);
           ySpeed = -ySpeed ; 
        } else if (yPosition <= (ceilingPosition)) {         
            yPosition = (int)(ceilingPosition);
            ySpeed = -ySpeed;
        } else if (xPosition <= (leftWall)) {
            xPosition = (int)(leftWall);
            xSpeed = -xSpeed; 
        } else if (xPosition >= (rightWall - diameter)) {
        	xPosition = (int)(rightWall - diameter);
            xSpeed = -xSpeed;
        }
        
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
