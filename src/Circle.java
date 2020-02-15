import java.awt.*;

/**
 * Simple class representing a circle object. 
 *
 *   Created 26 Aug 2017 for Lecture 4
 *  Edited by Nonthakorn Sukprom 60070503435, 15 February 2020
 */
public class Circle extends AbstractShape
{
    
    /**
     * keep radius
     */
    private int radius;


    /**
     * Constructor creates a new circle by specifying an x,y 
     * for the center of the circle, plus a radius value.
     * @param     x        X coord of center point
     * @param     y        Y coord of centerpoint
     * @param     radius   Radius length   
     */
    public Circle(int x, int y, int radius)
    {
       super();
       anchor = new Point(x,y);
       vertices.add(anchor);
       this.radius = radius;
       calBoundBox();
    }

    /**
     * Calculate the perimeter of this circle
     * This is 2*PI*radius.
     * @return perimeter value
     */
    public double calcPerimeter()
    {
	return (double) Math.PI * 2.0 * radius;
    }

    /**
     * Calculate the area of this circle
     * This is PI times the radius squared
     * @return area value
     */
    public double calcArea()
    {
        return (double) Math.PI * Math.pow(radius,2);
    }

    /**
     * Draw the shape on canvas
     * @param  graphics    Graphics context for drawing
     */
    public void draw(Graphics2D graphics)
    {	
       graphics.setPaint(drawColor);
       /* drawOval takes center plus width and height */
       graphics.drawOval(anchor.x,anchor.y,2*radius,2*radius);
       /* label it near the anchor point */
       int labelx = anchor.x + 5;
       int labely = anchor.y - 5;
       graphics.drawString(new String(" " + shapeId),labelx,labely);
    }

    /**
     * Draw the shape with color
     * @param  graphics    Graphics context for drawing
     * @param  fillColor   Color to use for filling.
     */
    public void draw(Graphics2D graphics, Color fillColor)
    {
        draw(graphics);
        graphics.setPaint(fillColor);
        graphics.fillOval(anchor.x,anchor.y,2*radius,2*radius);
    }

    /**
     * Override toString to give more informative information
     */
    public String toString()
    {
	    String value = "Circle: center at (" + anchor.x+","+anchor.y+") with radius " + radius
                + "\n with bounding X: " + lowestX + " - " + highestX + " Y : " + lowestY + "-" +highestY;
        return value;
    }

    /**
     * Calculate bounding box of shape
     * by find highest and lowest value of X and Y in shape
     * then assign to member in object
     */
    @Override
    protected void calBoundBox()
    {
        highestX = anchor.x + (radius * 2) ;
        lowestX = anchor.x;
        highestY = anchor.y + (radius * 2);         // highest in numerical context
        lowestY = anchor.y;                         // lowest in numerical context
    }
}
