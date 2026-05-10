//KIT107 Assignment 3
/**
 *	Graphical User Interface and MazeSolver
 *
 *	@author Julian Dermoudy
 *	@version May 5th 2026
 *
 *	This file holds the paint(), actionPerformed(), and
 *	other related routines.  The class is a Frame that
 *	contains the graphical user interface.
 *	
 *	This file is complete.
*/


import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class MazeSolver extends Frame implements MazeSolverInterface, ActionListener
{
	// final variables
	protected final String FILENAME="maze.txt";	// the file containing the maze
	protected final boolean TRACING=false;		// display trace output?

	// non-final variables
	// Required ADTs
   	protected GameTree paintMe;			// the game tree with the 'current' maze as the root node
   	protected Grid maze;				// the game tree used for the solution
   	protected Stack dfst;				// an intermediate stack used for the depth-first search
   	protected Queue bfst;				// an intermediate queue used for the breadth-first search
   	protected Display window;			// the Display variable used for display

	// operational variables
	protected BufferedReader input;		// the file variable used to refer within the program to the maze text file
    protected int goal;					// the square number of the stop square
   	protected boolean started;			// used to indicate if the frame has been initialised
   	protected boolean solvable;			// used to indicate whether the maze can be solved
   	protected boolean solved;			// used to indicate whether the solution has been found

	// GUI widgets
	protected Button dfs;				// a button to initiate depth-first search
   	protected Button bfs;				// a button to initiate breadth-first search


   	/**
	 * 	MazeSolver
	 *	Constructor method.
	 *	Pre-condition: the given String value contains the name
	 *				   for the frame (window) being created
	 *	Post-condition: a frame is created showing two buttons
	 *					and the maze to be solved (read from a
	 *					file)
	 *	Informally: construct the window for displaying the
	 *				maze solution, read the maze from the file,
	 *				and display it
	 *
	 * 	@param a String which holds the title for the window
	*/
   	public MazeSolver(String a)
	{
		trace("MazeSolver: Constructor starts");

      	window=new Display();

      	// create frame and window listener
      	setLayout(new FlowLayout());
      	setTitle(a);
      	setVisible(true);
      	addWindowListener(
      		new WindowAdapter()
      		{
      			public void windowClosing(WindowEvent e)
      			{
      				dispose();
      				System.exit(0);
      			}
      		}
      	);
     	setSize(300,400);

     	// create buttons
      	dfs=new Button("Solve Depth-First");
      	add(dfs);
      	dfs.addActionListener(this);
      	bfs=new Button("Solve Breadth-First");
      	add(bfs);
      	bfs.addActionListener(this);

		// construct the maze from its text file representation
      	openFile();
      	maze=readMaze();
      	closeFile();

      	// initialise the initial state of the program
      	solvable=true;
      	paintMe=new GameTree(maze);
      	started=true;
      	solved=false;

		// show the unsolved maze within the frame
      	setVisible(true);
      	window.setGraphics(getGraphics());
      	repaint();

		trace("MazeSolver: Constructor ends");
   	}


	/**
	 * 	paint
	 * 	Update the GUI screen
	 *	Pre-condition: the given Graphics value is a valid
	 *				   graphics context and corresponds to the
	 *				   context stored within the "window"
	 *				   instance variable
	 *	Post-condition: the maze at the root of the tree
	 *					referred to by the "paintMe" instance
	 *					variable is displayed, together with a
	 *					count of the squares investigated thus
	 *					far if the maze has been solved.  
	 *	Informally: display the 'current' maze and the summary
	 *				if applicable
	 *
	 * 	@param g Graphics context for display
	*/
	public void paint(Graphics g)
	{
		trace("paint: paint starts");

      	if (started)
      	{
			// clean up the window
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());

			// show the maze
           	((Grid)(paintMe.getData())).showGrid(window);

        	// show the summary if applicable
           	g.setColor(Color.BLACK);
    		if (solved)
    		{
    			g.drawString("Maze solved in " + paintMe.getCount() + " steps.",10,350);
    		}
         	else
         	{
         		if (! solvable)
         		{
         			g.drawString("Maze is not solvable.",10,350);
         		}
         	}
   		}

		trace("paint: paint ends");
   	}


	/**
	 * 	update
	 * 	Set method for "paintMe" instance variable.
	 * 	Pre-condition: none
	 * 	Post-condition: the paintMe instance variable has been
	 * 					assigned the given value
	 *	Informally: update paintMe, sleep 1/4 of a second, and
	 *				then paint the screen with the contents of
	 *				the variable
	 *
	 * 	@param t GameTree to assign to paintMe field
	*/
	public void update(GameTree t)
	{
		trace("update: update starts");

		paintMe=t;
	
		// wait for a bit
		try
		{
			Thread.sleep(250);
		}
		catch (InterruptedException e)
		{
		}

		// schedule the repainting
		//repaint();
		paint(window.getGraphics());

		trace("update: update ends");
	}


	/**
	 * 	actionPerformed
	 * 	Handle user-generated events on the GUI
	 *	Pre-condition: the ActionEvent parameter indicates whether
	 *				   the "dfs" or "bfs" buttons were pressed
	 *	Post-condition: the maze is solved using either a depth-
	 *					or breadth-first approach and the solution
	 *					displayed
	 *	Informally: solve the maze and show the solution!
	 *
	 * 	@param e ActionEvent object that represents the user's
	 * 			action
	*/
   	public void actionPerformed(ActionEvent e)
   	{
 		trace("actionPerformed: actionPerformed starts");

  		// look for a new solution
   		solved=false;
    	paintMe=new GameTree(maze);
		paintMe.resetCount();

  		if (e.getSource() == dfs) // depth-first
   		{
	    	trace("actionPerformed: Depth first traversal: ");
      		dfst = new Stack();
      		paintMe=paintMe.buildGameDF(this,dfst);
  		}
   		else
   		{
			// breadth-first
			trace("actionPerformed: Breadth first traversal: ");
			bfst = new Queue();
			paintMe=paintMe.buildGameBF(this,bfst);
       	}

		// check result
     	if (paintMe.isEmpty())
		{
			// no solution
			solvable=false;
		}
		else
		{
			// solution found
			solved=true;		
		}

		//re-draw solution
		update(paintMe);

 		trace("actionPerformed: actionPerformed ends");
   	}


	/**
	 * 	openFile
	 * 	Open the text file containing the maze data
	 *	Pre-condition: the file exists in the current
	 *				   folder/directory and is a readable text
	 *				   file
	 *	Post-condition: the text file containing the encoded maze
	 *					to be solved is opened for reading
	 *	Informally: open the text file containing the maze, throw
	 *				an exception if the file cannot be opened
	*/
   	protected void openFile()
   	{
		trace("openFile: openFile starts");

      	try
      	{
		    input = new BufferedReader(new FileReader(FILENAME));
		}
      	catch (IOException e)
		{
		    System.err.println("Error opening " + FILENAME + " for loading");
		    System.exit(1);
		}

		trace("openFile: openFile ends");
	}


	/**
	 * 	closeFile
	 * 	Close the text file containing the maze data
	 *	Pre-condition: a text file attached to instance variable "input"
	 *				   is open
	 *	Post-condition: the text file is closed
	 *	Informally: close the text file containing the maze, throw an
	 *				exception if it cannot be closed
	*/
   	protected void closeFile()
	{
		trace("closeFile: closeFile starts");

		try
		{
			input.close();
		}
		catch (IOException e)
		{
			System.err.println("Error closing " + FILENAME + " -- " + e.toString());
		}

		trace("closeFile: closeFile ends");
	}


	/**
	 *	getLine
	 *	Read a line from the file
	 *	Pre-condition: a text file attached to instance variable "input"
	 *				   is open and contains a validly encoded maze
	 *	Post-condition: a non-comment line has been read from the file
	 *					and returned
	 *	Informally: get the next line from the file, skipping comments
	 *				(those lines beginning with "#"), throw an exception
	 *				if a line cannot be read from the file
	 *
	 * @return String the line read from the file
	*/
	protected String getLine()
	{
   		String line;	// line of text from the file

		trace("getLine: getLine starts");

		// initialise return value
   		line=null;

   		try
   		{
			// try to read a line, skipping over lines commencing with #
   			line=input.readLine();
   			while (line.indexOf('#') == 0) // skip the comments
   			{
   				line=input.readLine();
   			}
   		}
		catch (IOException e)
		{
			// problem, can't continue!
            System.err.println("Error in " + FILENAME + " data");
            System.exit(1);
		}

		trace("getLine: getLine ends");

	   	return line;
	}


	/**
	 * 	readMaze
	 * 	Extract the maze from the file creating the starting Grid
	 *	Pre-condition: a text file attached to instance variable "input"
	 *				   is open and contains a validly encoded maze
	 *	Post-condition: a Grid object is created based on the maze
	 *					encoded within the text file and installed as
	 *					the only node of a game tree which is returned
	 *	Informally: get the maze details out of the file and build the
	 *				initial game tree which is returned
	 *
	 * 	@return Grid which is the starting state of the maze from the
	 * 			text file
	*/
	protected Grid readMaze()
	{
		String hLine,vLine,line;
		Grid m;
		Square s;
		int hD,vD,n,r,c;
		Location l;
		Dimension d;

		trace("readMaze: readMaze starts");

		// read the maze's dimensions
		hLine=getLine();
		vLine=getLine();
        hD=Integer.valueOf(hLine).intValue();
        vD=Integer.valueOf(vLine).intValue();
        d=new Dimension(vD,hD);

        // read the square number of the stop square
        line=getLine();
	    goal=Integer.valueOf(line).intValue();

		trace("readMaze: Settings read, now building Grid");

	    // create the default maze
        m=new Grid(d,goal);

		// re-define each square from file data
        for (r=1; r<=vD; r++)
        {
        	for (c=1; c<=hD; c++)
        	{
	        	l=new Location(r,c);
				line=getLine();
	        	n=Integer.valueOf(line).intValue();
	        	if (n>=0) // non wall
	        	{
    	    		s=m.getSquare(l);
    	    		s.solidWall(false);
    	    		s.squareNumber(n);
    	    		if (n==goal) // stop square
    	    		{
						trace("readMaze: found goal");
    	    			s.stopSquare();
    	    		}
    	    		m.setSquare(l,s);
    	    		if (n==0) // start square
    	    		{
						trace("readMaze: found origin");
    	    			m.occupySquare(l,true);
     	    		}
    	    	}
    	    }
    	}

		trace("readMaze: readMaze ends");

        return m;
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s String to print as trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("MazeSolver: " + s);
		}
	}
}
