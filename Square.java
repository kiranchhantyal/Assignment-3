//KIT107 Assignment 3
/**
 *	Square ADT
 *
 *	@author << Student Names and IDs >>
 *	@version << Date of Completion >>
 *
 *	This file holds the Square ADT which represents
 *	a physical space within a maze.  A Square in a
 *	maze consists of a location, a colour, a number,
 *	and four flags indicating whether or not the
 *	Square object is: a wall, visited as part of
 *	the attempt to find a solution, the start square
 *	of the maze, and/or the stop square of the maze.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


import java.awt.*;


public class Square implements SquareInterface, Cloneable
{
	// finals
	protected final boolean TRACING=true;				// do we want to see trace output?

	// non-finals
	protected Location loc;		// the location of the current square within the maze
	protected Color colour;		// the colour of the current square
	protected boolean wall;		// whether the square is a wall
	protected boolean visited;	// whether the square has been visited yet
	protected boolean start;	// whether the square is the start square
	protected boolean stop;		// whether the square is the stop square
	protected int number;		// the number of the square


	/**
	 *	Constructor method 1.
	 *	Pre-condition: the given location value is defined
	 *	Post-condition: the Square object's "loc" field is the value
	 *					given, its "colour" field is 'black', its
	 *					"wall" field is true, its "visited", "start",
	 *					and "stop" fields are false, and its "number"
	 *					field is given the integer value -1 to
	 *					represent undefined
	 *	Informally: creates a wall square at the given location
	 *
	 * @param l the starting location on the maze
	*/
	public Square(Location l)
	{
      	trace("Square: Constructor starts");

		loc=l;
		colour=Color.BLACK;
		wall=true;
		visited=false;
		start=false;
		stop=false;
		number=-1;
	}


	/**
	 *	Constructor method 2.
	 *	Pre-condition: the given location value is defined
	 *	Post-condition: the Square object's "loc" field is the value
	 *					given, its "colour" field is 'white', its
	 *					"wall", "visited", "start",	and "stop" fields
	 *					are false, and its "number" field is assigned
	 *					the given value
	 *	Informally: creates a non-wall square at the given location
	 *					with the given square number
	 *
	 * @param l the starting location on the maze
	 * @param n the number of that square
	*/
	public Square(Location l,int n)
	{
      	trace("Square: Constructor starts");
		loc = l;
		colour = Color.WHITE;
		wall = false;
		visited = false;
		start = false;
		stop = false;
		number = n;

		trace("Square: Constructor ends");
	}


	/**
	 *	Constructor method 3.
	 *	Pre-condition: the given location value is defined and the
	 *					given boolean values are valid
	 *	Post-condition: the Square object's "loc" field is the value
	 *					given, its "colour" field is 'yellow' if
	 *					either of the given boolean values (o for
	 *					origin, i.e. start, and g for goal, i.e. stop),
	 *					are true, and 'white' otherwise, its
	 *					"wall" and "visited" fields are false, its
	 *					"number" field is assigned the given value,
	 *					and its "start" and "stop" fields are assigned
	 *					the given values of o and g respectively
	 *	Informally: creates a non-wall square at the given location
	 *					with the given square number, that may be the
	 *					start and/or stop square
	 *
	 * @param l the starting location on the maze
	 * @param o the number of the start (origin) square
	 * @param g the number of the stop (goal) square
	 * @param n the number of that square
	*/
	public Square(Location l, boolean o, boolean g, int n)
	{
      	trace("Square: Constructor starts");

		loc=l;
		wall=false;
		visited=false;
		start=o;
		stop=g;

		if (start || stop)
		{
			colour=Color.YELLOW;
		}
		else
		{
			colour=Color.WHITE;
		}

		number=n;

		trace("Square: Constructor ends");
	}


	/**
	 *	clone
	 *	clone method for Square objects
	 *	Pre-condition: the current Square object is validly defined
	 *	Post-condition: the Square object is copied
	 *	Informally: copy the current Square
	 *
	 * @return Object the copy of the Square
	*/
	public Object clone()
	{
		Square s;

		trace("clone: clone starts");

// COMPLETE ME

      	trace("clone: clone ends");
		return null;	// CHANGE ME
	}


	/**
	 *	getLocation
	 *	Get method for "loc" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					location field is returned
	 *	Informally: return the current square's location
	 *
	 * @return Location the square's location
	*/
	public Location getLocation()
	{
      	trace("getLocation: getLocation starts and ends");

		return loc;
	}


	/**
	 * 	setLocation
	 *	Set method for "loc" instance variable.
	 *	Pre-condition: the given Location value is defined and
	 *				   valid within the enclosing maze
	 *	Post-condition: the value of the Square object's loc
	 *					field is altered to contain the given
	 *					Location value
	 *	Informally: update the Square object's Location to the
	 *				given value
	 *
	 *	@param l the square's intended location
	*/
	public void setLocation(Location l)
	{
      	trace("setLocation: setLocation starts");

		loc=l;

      	trace("setLocation: setLocation ends");
	}


	/**
	 *	getColour
	 *	Get method for "colour" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					colour field is returned
	 *	Informally: return the current square's colour
	 *
	 * 	@return Color the square's colour
	*/
	public Color getColour()
	{
      	trace("getColour: getColour starts and ends");

		return colour;
	}


	/**
	 * 	setColour
	 *	Set method for "colour" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's colour
	 *					field is altered to contain the given
	 *					Color value
	 *	Informally: update the Square object's Color to the
	 *				given value
	 *
	 * 	@param c the square's intended colour
	*/
	public void setColour(Color c)
	{
      	trace("setColour: setColour starts");

		colour=c;

      	trace("setColour: setColour ends");
	}


	/**
	 * isWall
	 *	Get method for "wall" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					wall field is returned
	 *	Informally: return whether the current square is a
	 *				wall
	 *
	 * 	@return boolean whether this square is a wall
	*/
	public boolean isWall()
	{
      	trace("isWall: isWall starts and ends");

		return wall;
	}


	/*
	 *	solidWall
	 *	Set method for "wall" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the given value is assigned to the Square
	 *					object's wall field.  If the value alters
	 *					the Square to be a wall its colour is set
	 *					to black, otherwise it is set to white
	 *	Informally: update the Square object's wall to the
	 *				given value
	 *
	 * 	@param w whether this square is to be a wall
	*/
	public void solidWall(boolean w)
	{
      	trace("solidWall: solidWall starts");

		// update wall property
		wall=w;

		// update colour property
		if (wall)
		{
			colour=Color.BLACK;
		}
		else
		{
			colour=Color.WHITE;
		}

      	trace("solidWall: solidWall ends");
	}


	/**
	 *	isOccupied
	 *	Get method for "visited" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					visitation field is returned
	 *	Informally: return whether the current square has
	 *				been visited in the current attempt at
	 *				finding a solution
	 *
	 * 	@return boolean whether the square has been visited
	*/
	public boolean isOccupied()
	{
      	trace("isOccupied: isOccupied starts and ends");

//COMPLETE ME
		return false;	// CHANGE ME
	}


	/**
	 * occupied
	 *	Set method for "visited" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the given value is assigned to the Square
	 *					object's visited field and if the Square
	 *					is now visited its colour is changed to red
	 *	Informally: record whether or not the current Square is
	 *				visited
	 *
	 * 	@param o whether the square is to be occupied
	*/
	public void occupied(boolean o)
	{
      	trace("occupied: occupied starts");

		// update visited property
		visited=o;

		// update colour property
		if (visited)
		{
			colour=Color.RED;
		}

      	trace("occupied: occupied ends");
	}


	/**
	 * 	numbered
	 * 	Get method for "number" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					number field is returned
	 *	Informally: return the current square's number
	 *
	 * 	@return int the square's number
	*/
	public int numbered()
	{
      	trace("numbered: numbered starts and ends");

		return number;
	}


	/**
	 * 	squareNumber
	 *	Set method for "number" instance variable.
	 *	Pre-condition: the given value is a legal square number
	 *	Post-condition: the given value is assigned to the Square
	 *					object's number field
	 *	Informally: update the Square object's square number to the
	 *				given value
	 *
	 * 	@param n the intended number of the square
	*/
	public void squareNumber(int n)
	{
      	trace("squareNumber: squareNumber starts");

		number=n;

      	trace("squareNumber: squareNumber ends");
	}


	/**
	 *	isStopSquare
	 *	Get method for "stop" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					stop field is returned
	 *	Informally: return whether the current square is
	 *				the stop square
	 *
	 * 	@return boolean whether this square is the goal
	*/
	public boolean isStopSquare()
	{
      	trace("isStopSquare: isStopSquare starts and ends");

		return stop;
	}


	/**
	 * 	stopSquare
	 *	Set method for "stop" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Square object's "stop" instance
	 *					variable is set to true and its "colour"
	 *					instance variable is set to yellow
	 *	Informally: record that the current Square is the stop
	 *				square
	*/
	public void stopSquare()
	{
      	trace("squareNumber: squareNumber starts");

		// update stop property
		stop=true;
		// update colour property
		colour=Color.YELLOW;

      	trace("squareNumber: squareNumber ends");
	}


	/**
	 * 	isStartSquare
	 *	Get method for "start" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					start field is returned
	 *	Informally: return whether the current square is
	 *				the start square
	 *
	 * 	@return boolean whether this square is the origin
	*/
	public boolean isStartSquare()
	{
      	trace("isStartSquare: isStartSquare starts and ends");

		return start;
	}


	/**
	 * 	startSquare
	 *	Set method for "start" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Square object's "stop" instance
	 *					variable is set to true, its colour is
	 *					set to yellow, and the square number is
	 *					set to 0
	 *	Informally: record that the current Square is the stop
	 *				square
	*/
	public void startSquare()
	{
      	trace("startSquare: startSquare starts");

		// update start property
		start=true;
		// update colour property
		colour=Color.YELLOW;
		// update number property
		number=0;

      	trace("startSquare: startSquare ends");
	}


	/**
	 * 	showSquare
	 *	Pre-condition: the Display parameter is correctly defined
	 *	Post-condition: the Display representation of the Square
	 *					object is displayed on the given Display at
	 *					the position related to its location using
	 *					the Square object's colour to display the
	 *					square (of 20 pixels) and also write the
	 *					Square's number	on the displayed square
	 *	Informally: display the current square
	 *
	 * @param s the abstract display on which the square is to be
	 * 		    shown
	*/
	public void showSquare(Display s)
	{
		// final variables for simplicity
		final int PIXEL_MULTIPLIER=20;
		final int HORIZ_OFFSET=15;
		final int VERT_OFFSET=65;

		// non-final variables for convenience
		int row=loc.getRow();
		int column=loc.getColumn();

      	trace("showSquare: showSquare starts");

		// paint the square
		s.getGraphics().setColor(getColour());

		s.getGraphics().fillRect(PIXEL_MULTIPLIER*(column)+HORIZ_OFFSET,
						PIXEL_MULTIPLIER*(row)+VERT_OFFSET,20,20);

		// draw the square number if the square is not a wall
		if (! isWall())
		{
			s.getGraphics().setColor(Color.BLACK);
			s.getGraphics().drawString(Integer.toString(numbered()),
							PIXEL_MULTIPLIER*(column)+HORIZ_OFFSET+6,
							PIXEL_MULTIPLIER*(row)+VERT_OFFSET+10);
		}

      	trace("showSquare: showSquare ends");
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
			System.out.println("Square: " + s);
		}
	}
}
