/**
 * Class to test reading of shape command files and displaying of information
 * about instances of AbstractShape that are created.
 *
 *   Created by Sally Goldin, 2 September 2017, for Exercise 4 CPE372
 *   Edited by Nonthakorn Sukprom 60070503435, 15 February 2020
 */
public class ShapeFileTester
{

    /**
     * instance of reader that knows how to parse the files 
     */
    private static ShapeReader reader;
    private static FigureViewer viewer;

    /**
     * main method which controls the reading and displays the results
     */
    static public void main(String args[])
    {
		if (args.length != 1)
		{
			System.out.println("Usage:   java ShapeFileTester [filetoread]\n");
			System.exit(0);
		}
		viewer = new FigureViewer();
		viewer.pack();
		viewer.setVisible(true);
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException ie)
		{
		}
		reader = new ShapeReader();
		System.out.print("Trying to open'" + args[0] + "' ... ");
		if (!reader.open(args[0]))
		{
			System.out.println("FAILED!\n\n");
			System.exit(1);
		}
		System.out.println("Success!\n");
		AbstractShape nextShape = reader.readShape();
		while (nextShape != null)
		{
			System.out.println("  readShape returned an object: " + nextShape.getClass().toString());
			System.out.println("      toString: " + nextShape.toString());
			nextShape.draw(viewer.getViewerGraphics());
			nextShape = reader.readShape();
		}
		reader.close();
		AbstractShape.drawAll(viewer.getViewerGraphics());
		System.out.println("\nClosing file and exiting...\n\n");
    }
}