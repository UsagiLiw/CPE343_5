/*
 *  DrawingCanvas
 *
 *  Simple class to act as a place to draw vectors.
 *
 *  Created by Sally Goldin, 23 June 2005
 *  Updated 30 December 2011
 *
 *    Edited by Nonthakorn Sukprom 60070503435, 15 February 2020
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Simple subclass of JPanel that allows us to set the size of
 * a drawing area, also to clear it.
 *
 *    Edited by Nonthakorn Sukprom 60070503435, 15 February 2020
 *
 */
public class DrawingCanvas extends JPanel implements MouseListener
{
    /* Preferred size */
   private Dimension desiredSize = null;

   /**
    * Constructor sets desired size.
    * @param width   Desired width
    * @param height  Desired height
    */
   public DrawingCanvas(int width, int height)
   {
       desiredSize = new Dimension(width,height);
       addMouseListener(this);
   }
 
   /**
    * Override so that we can control the size.
    */
   public Dimension getPreferredSize()
   {
       return desiredSize;
   } 

   /**
    * Clear the panel to background color.
    */
   public void clear()
   {
	updateUI();
   }

   /**
    * Invoked when the mouse button has been clicked (pressed
    * and released) on a component.
    *
    * @param e
    */
   @Override
   public void mouseClicked(MouseEvent e)
   {
      int posX = e.getX();
      int posY = e.getY();
      ArrayList<AbstractShape> selectedShapes = new ArrayList<AbstractShape>();
      System.out.println(" MOUSE CLICKED AT \n X: " + posX + " Y: " + posY + "\n");
      Iterator iterator = AbstractShape.allFigures.iterator();
      while (iterator.hasNext())
      {
         AbstractShape currentShape = (AbstractShape) iterator.next();
         if (currentShape.inShape(posX, posY))
         {
            currentShape.draw((Graphics2D) getGraphics(),currentShape.drawColor);
            break;
         }
      }
   }

   /**
    * Invoked when a mouse button has been pressed on a component.
    *
    * @param e
    */
   @Override
   public void mousePressed(MouseEvent e)
   {
   }

   /**
    * Invoked when a mouse button has been released on a component.
    *
    * @param e
    */
   @Override
   public void mouseReleased(MouseEvent e)
   {
   }

   /**
    * Invoked when the mouse enters a component.
    *
    * @param e
    */
   @Override
   public void mouseEntered(MouseEvent e)
   {
   }

   /**
    * Invoked when the mouse exits a component.
    *
    * @param e
    */
   @Override
   public void mouseExited(MouseEvent e)
   {
   }

}
