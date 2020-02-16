import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  FigureViewer
 *
 *  Simple graphical application to display simple geometric figures
 *
 *  Created by Sally Goldin, 23 April 2013 for CPE 113
 *  Augmented for CPE372, 13 August 2017
 *  Modified for Exercise 2, CPE372 19 August 2017
 *     Removed the drawing completely, added function to return graphics
 *     Edited by Nonthakorn Sukprom 60070503435, 15 February 2020
 */
public class FigureViewer extends JFrame 
                                     implements ActionListener, MouseListener
{
   /* UI objects */
   private DrawingCanvas drawCanvas = null;
   private JButton clearButton = null;
   private JButton exitButton = null;
   private JButton drawAllButton = null;


   /**
    * Constructor creates the User Interface.
    */
   public FigureViewer()
   {
      super("Figure Viewer");
      buildUI();
   }

   /**
    * Create the visible part of the user interface. 
    */
   private void buildUI()
   {
      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.setBorder(new EmptyBorder(10,10,10,10));
      JPanel controlPanel = new JPanel(new FlowLayout());
      controlPanel.setBorder(new EtchedBorder());


      clearButton = new JButton("Clear");
      clearButton.addActionListener(this);
      controlPanel.add(clearButton);

      drawAllButton = new JButton("Draw All");
      drawAllButton.addActionListener(this);
      controlPanel.add(drawAllButton);

      exitButton = new JButton("Exit");
      exitButton.addActionListener(this);
      controlPanel.add(exitButton);
      mainPanel.add(controlPanel, BorderLayout.NORTH);
 
      drawCanvas = new DrawingCanvas(400,400);
      drawCanvas.setBorder(new EtchedBorder());
      drawCanvas.setBackground(Color.white);
      drawCanvas.addMouseListener(this);
      mainPanel.add(drawCanvas, BorderLayout.CENTER);
      getContentPane().add(mainPanel, BorderLayout.CENTER);
   }

   /** 
    * This is the method required for the ActionListener 
    * interface. It handles the necessary actions when 
    * buttons are pressed.
    */
   public void actionPerformed(ActionEvent e)
   {
       Object source = e.getSource();
       if (source == exitButton)
       {
          System.exit(0);
       }
       else if (source == clearButton)
       {
          drawCanvas.clear();
       }
       else if (source == drawAllButton)
       {
          AbstractShape.drawAll(getViewerGraphics());
       }
   }

   /** Clear the drawing panel.
    */
   public void clear()
   {
       drawCanvas.clear();
   }

   /**
    * Return the graphics context associated with
    * the panel used for drawing.
    @return  Graphics context
    */
   public Graphics2D getViewerGraphics()
   {
       return (Graphics2D) drawCanvas.getGraphics();
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
      System.out.println(" MOUSE CLICKED AT \n X: " + posX + " Y: " + posY + "\n");
      AbstractShape selectedShape = AbstractShape.inShape(posX,posY);
      if (selectedShape != null)
         selectedShape.draw(getViewerGraphics(),selectedShape.drawColor);
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





