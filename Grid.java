//KIT107 Assignment 3
/**
 *	Grid ADT
 *
 *	@author << Student Names and IDs >>
 *	@version << Date of Completion >>
 *	
 *	This file holds the Grid ADT which represents
 *	the maze.  The Grid consists of a location (of
 *	the current position of the solver), a
 *	dimension, a square number (of the stop square),
 *	and a two-dimensional array (table/matrix) of
 *	the squares in a maze.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


import java.awt.*;


public class Grid implements GridInterface, Cloneable
{
	// finals
	protected final boolean TRACING=true;				// do we want to see trace output?

	// non-finals
	protected Dimension dim;	// size of the maze
	protected Square grid[][];	// all the Squares within the maze
	protected Location loc;		// current position of solver
	protected int goalNumber;	// square number of stop square

	
	/**
	 *	Grid
	 *	Constructor method 1.
	 *	Pre-condition: the given Dimension value is defined and
	 *				   valid
	 *	Post-condition: a Grid of given Dimension is created
	 *					where all squares are walls and the
	 *					square number of the goal square is
	 *					recorded from that given
	 *	Informally: create a solid maze of given dimension and
	 *				indicated stop square number
	 *
	 *	@param m Dimension the vertical and horizontal size of
	 *				the maze
	 *	@param g int representing the number of the goal square
	*/
	public Grid(Dimension m, int g)
	{
      	trace("Grid: Constructor starts");

//COMPLETE ME		

      	trace("Grid: Constructor ends");
	}
	
	
	/**
	 * 	Grid
	 *	Constructor method 2.
	 *	Pre-condition: the given Dimension and Location values
	 * 				   is defined and valid and the given
	 * 				   Location value is defined to be a
	 * 				   location within the given Dimension
	 *	Post-condition: a Grid of given Dimension is created
	 *					where all squares are walls, the square
	 *					number of the goal square is recorded
	 *					from that given, and the square indicated
	 *					by the provided location is occupied
	 *	Informally: create a solid maze of given dimension,
	 *				indicated stop square number, and indicated
	 *				current position; an exception is thrown if
	 *				the provided location is not within the bounds
	 *				of the maze
	 *
	 *	@param m Dimension the vertical and horizontal size of
	 *				the maze
	 *	@param l Location the intended current position
	 *	@param g int representing the number of the goal square
	*/
	public Grid(Dimension m, Location l, int g) throws IllegalGridException
	{
      	trace("Grid: Constructor starts");

		// initialise dim and goal number properties
		dim=m;
		goalNumber=g;
		
		// initialise all the squares
		initialiseGrid();
		if (validMove(l))
		{
			// initialise loc and move there
			loc=l;
			occupySquare(l,true);
		}
		else
		{
			// cannot continue, location is invalid
			throw new IllegalGridException();
		}

      	trace("Grid: Constructor ends");
	}
	
	
	/**
	 *	initialiseGrid
	 *	Create the squares within the Grid
	 *	Pre-condition: none
	 *	Post-condition: the two-dimensional array of Squares is
	 *					instantiated and filled with newly
	 *					created wall squares each with the
	 *					correct location
	 *	Informally: create a solid maze of known dimension
	*/
	protected void initialiseGrid()
	{
		int r,c;	// row and column indices
		Location l;	// location comprising r and c
		
      	trace("initialiseGrid: initialiseGrid starts");

		// create the rows
		grid=new Square[dim.getVert()][];
		for (r=0; r<dim.getVert(); r++)
		{
			// create the columns
			grid[r]=new Square[dim.getHoriz()];
			for (c=0; c<dim.getHoriz(); c++)
			{
				// initialise the square
				l=new Location(r+1,c+1);
				grid[r][c]=new Square(l); //wall
			}
		}

      	trace("initialiseGrid: initialiseGrid ends");
	}
	
	
	/**
	 *	clone
	 *	Copy the Grid
	 *	Pre-condition: the current Grid object is validly defined
	 *	Post-condition: the Grid object is copied
	 *	Informally: copy the current Grid
	 *
	 * 	@return Object the copy of the Grid
	*/
	public Object clone()
	{
		Grid b;			// new Grid (copy)
		int r,c;		// row and column indices
		Dimension d;	// duplicated Dimension
		
      	trace("clone: clone starts");

//COMPLETE ME		
				
      	trace("clone: clone ends");

		return null;	//CHANGE ME
	}
	
	
	/**
	 * 	setSquare
	 *	Set method for an element of the "grid" instance variable.
	 *	Pre-condition: the given Location value is defined and
	 *				   valid within the enclosing maze
	 *	Post-condition: the given square is assigned to an element
	 *					of the Grid object selected according to
	 *					the given location within the maze
	 *	Informally: insert the given square into the maze at the
	 *				appropriate location
	 *
	 * 	@param l Location of the square to set
	 * 	@param s Square to be placed at that location
	*/
	public void setSquare(Location l, Square s) throws IllegalGridException
	{
		int r,c;	// row and column numbers
		
      	trace("setSquare: setSquare starts");

		if (!validMove(l))
		{
			// can't continue as destination location isn't in the maze
			throw new IllegalGridException();
		}
		else
		{
			// extract row and column numbers
			r=l.getRow();
			c=l.getColumn();
		}
		
		// update the grid
		grid[r-1][c-1]=s;

		trace("setSquare: setSquare ends");
	}


	/**
	 *	getSquare
	 *	Get method for an element of the "grid" instance variable.
	 *	Pre-condition: the given Location value is within the
	 *				   bounds of the current maze
	 *	Post-condition: the Square object at the appropriate
	 *					element of the "grid" selected according
	 *					to the given Location value is returned
	 *	Informally: return the square of the maze at the given
	 *				location, an exception is thrown if the
	 *				location is not within the maze
	 *
	 * 	@param l Location of the square to obtain
	 * 
	 *	@return Square at the specified location
	*/
	public Square getSquare(Location l) throws IllegalGridException
	{
		int r,c;	// row and column values

		trace("getSquare: getSquare ends");

		if (!validMove(l))
		{
			// can't continue as provided location isn't in the maze
			throw new IllegalGridException();
		}
//COMPLETE ME		

		trace("getSquare: getSquare ends");

		return null;	//CHANGE ME
	}
		
		
	/**
	 * 	setDimension
	 *	Set method for the "dim" instance variable.
	 *	Pre-condition: the given Dimension value is defined and
	 *				   valid
	 *	Post-condition: the instance variable "dim" is assigned
	 *					the given Dimension value
	 *	Informally: assign the given dimension to the Grid object
	 *
	 * @param d the intended Dimension for the Grid
	*/
	public void setDimension(Dimension d)
	{
		trace("setDimension: setDimension starts");

//COMPLETE ME		

		trace("setDimension: setDimension ends");
	}


	/**
	 * 	getDimension
	 *	Get method for "dim" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Grid object's
	 *					dimension field is returned
	 *	Informally: return the current maze's dimension
	 *
	 * 	@return Dimension the Grid's dimension
	*/
	public Dimension getDimension()
	{
		trace("getDimension: getDimension starts and ends");

//COMPLETE ME
		return null;	//CHANGE ME
	}


	/**
	 * 	setLocation
	 *	Set method for the "loc" instance variable.
	 *	Pre-condition: the given Location value is defined and
	 *				   valid
	 *	Post-condition: the instance variable "loc" is assigned
	 *					the given Location value
	 *	Informally: 'move to' the given location on the Grid object
	 *
	 * @param l the intended Location for the Grid
	*/
	public void setLocation(Location l)
	{
		trace("setLocation: setLocation starts");

//COMPLETE ME		

		trace("setLocation: setLocation ends");
	}
	
	
	/**
	 * 	getLocation
	 *	Get method for "loc" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Grid object's
	 *					loc field is returned
	 *	Informally: return the current position within
	 *				the maze
	 *
	 * 	@return Location the current Location on the Grid
	*/
	public Location getLocation()
	{
		trace("getLocation: getLocation starts and ends");

//COMPLETE ME
		return null;	//CHANGE ME
	}
	
	
	/**
	 * 	occupySquare
	 * 	Visit the specified square
	 *	Pre-condition: the given Location value is within
	 *				   the bounds of the current Grid
	 *				   object
	 *	Post-condition: the square at the position in the
	 *					maze indicated by the given Location
	 *					value is altered by the visitation
	 *					value indicated in the given Boolean
	 *					value and the given Location value is
	 *					remembered as the 'current' location
	 *	Informally: update the visitation component of the
	 *				square at the nominated location of the
	 *				maze with the given value and retain this
	 *				as the 'current' location within the maze
	 *
	 * 	@param l Location to occupy
	 * 	@param o boolean (whether to occupy or vacate)
	*/
	public void occupySquare(Location l, boolean o)
	{
		Square s;	// local variable for simplicity of coding

		trace("occupySquare: occupySquare starts");

//COMPLETE ME

		trace("occupySquare: occupySquare ends");
	}


	/**
	 * 	squareOccupied
	 * 	Check if nominated location has already been visited
	 *	Pre-condition: the given Location value is within
	 *				   the bounds of the current maze
	 *	Post-condition: a Boolean value is returned which
	 *					represents whether the visitation
	 *					property of the square of the
	 *					current Grid object with the given
	 *					Location value is set to true
	 *	Informally: return whether or not the square at
	 *				the given location has been visited
	 *
	 * 	@param l Location to examine
	 * 
	 * 	@return	boolean indicating whether specified square
	 * 			has been visited
	*/
	public boolean squareOccupied(Location l)
	{
		trace("squareOccupied: squareOccupied starts and ends");

//COMPLETE ME

		return false;	//CHANGE ME
	}
	
	
	/**
	 * 	makeWall
	 * 	Set the specified square to be or, not to be(!) a wall
	 *	Pre-condition: the given Location value is a valid
	 *				   value within the bounds of the
	 *				   current Grid object
	 *	Post-condition: the Square of the current Grid object
	 *					selected according to the given
	 *					Location value is altered to be a
	 *					wall
	 *	Informally: update the square of the maze at the
	 *				given location to be a wall
	 *
	 * 	@param l Location to update
	 * 	@param o boolean (whether it is a wall or not)
	*/
	public void makeWall(Location l, boolean o)
	{
		Square s;	// local variable for simplicity of coding
		
		trace("makeWall: makeWall starts");

		// update the square's details
		s=getSquare(l);
		s.solidWall(o);
		setSquare(l,s);

		trace("makeWall: makeWall starts");
	}


	/**
	 * 	isWall
	 *	Pre-condition: the given Location value is within
	 *				   the bounds of the current Grid
	 *				   object
	 *	Post-condition: true is returned if the square at
	 *					the given location within the
	 *					current Grid object is a wall,
	 *					false is returned if it is not
	 *	Informally: return whether or not the square in the
	 *				maze at the given location is a wall
	 *
	 * 	@param l Location to examine
	 * 
	 * 	@return	boolean indicating whether specified square
	 * 			is a wall
	*/
	public boolean isWall(Location l)
	{
		trace("isWall: isWall starts and ends");

		return getSquare(l).isWall();
	}
	
	
	/**
	 * 	setGoal
	 *	Set method for the "goalNumber" instance variable.
	 *	Pre-condition: the given goal number value is defined
	 *				   and valid within the current Grid object
	 *	Post-condition: the instance variable "goalNumber" is
	 *					assigned the given square number value,
	 *					and the square in the maze with that
	 *					square number is located and set as the
	 *					stop square
	 *	Informally: update the square within the maze that has
	 *				the given square number value to be the stop
	 *				square and also remember that square number
	 *				value as the goal
	 *
	 * 	@param g the intended goal square for the maze
	*/
	public void setGoal(int g)
	{
		Square s;	// local variable for simplicity of coding
		int r,c;	// row and column values
		Location l;	// location comprising r and c
		
		trace("setGoal: setGoal starts");

		// update goalNumber value
		goalNumber=g;

		// find the goal square and mark it as the goal
		for (r=1; r<=dim.getVert(); r++)
		{
			for (c=1; c<=dim.getHoriz(); c++)
			{
				l=new Location(r,c);
				s=getSquare(l);
         		if (s.numbered() == goalNumber)
         		{
					// this is it so mark it and put it back
         			s.stopSquare();
         			setSquare(l,s);
         		}
         	}
		}
		trace("setGoal: setGoal ends");
	}
	
	
	/**
	 * 	getGoal
	 *	Get method for "goalNumber" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Grid object's
	 *					goalNumber field is returned
	 *	Informally: return the current maze's stop
	 *				square's square number
	 *
	 * 	@return int the number of the stop (goal) square
	*/
	public int getGoal()
	{
		trace("getGoal: getGoal starts and ends");

		return goalNumber;
	}


	/**
	 * 	validMove
	 * 	Determine whether a location is on the maze
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the given
	 *					Location is within the bounds of
	 *					the current Grid object, false is
	 *					returned if it is not
	 *	Informally: return whether or not the given
	 *				location lies within the current maze
	 *
	 * 	@param l Location to query
	 * 
	 * 	@return boolean whether the given location is on the maze
	*/
	public boolean validMove(Location l)
	{
		int r,c;	// row and column values of given location

		trace("validMove: validMove starts");

//COMPLETE ME
		
      	trace("validMove: validMove ends");
		return false;	//CHANGE ME
	}


	/**
	 * 	gameOver
	 * 	Determine whether the goal has been reached
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the current
	 *					Location on the Grid is the stop
	 *					(goal) square, false is	returned
	 *					if it is not
	 *	Informally: return whether or not the current
	 *				location is the stop (goal) square
	 *
	 * 	@return boolean whether the current location is the goal
	*/
	public boolean gameOver()
	{
		trace("gameOver: gameOver starts and ends");

//COMPLETE ME
		return false;	//CHANGE ME
	}

	
	/**
	 * 	showGrid
	 * 	Output the grid on the given Display
	 *	Pre-condition: the Display parameter is correctly defined
	 *	Post-condition: the Display representation of the Grid
	 *					object is displayed on the given Display
	 *					with top-left coordinate (35,85) and
	 *					squares of 20 pixels
	 *	Informally: display the current maze
	 *
	 * 	@param s Display to output the grid on
	*/
	public void showGrid(Display s)
	{
		final int PIXEL_MULTIPLIER=20;	// pixel width and height of square
		
		int r,c;	// row and column values
		Location l;	// location comprising r and c
		
		trace("showGrid: showGrid starts");

		// paint the background
		s.getGraphics().setColor(Color.LIGHT_GRAY);
		s.getGraphics().fillRect(35,85,PIXEL_MULTIPLIER*dim.getHoriz(),
									PIXEL_MULTIPLIER*dim.getVert());

		for (r=1; r<=dim.getVert(); r++)
		{
			for (c=1; c<=dim.getHoriz(); c++)
			{
				// paint the square
				l=new Location(r,c);
         		getSquare(l).showSquare(s);
         	}
		}

		trace("showGrid: showGrid ends");

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
			System.out.println("Grid: " + s);
		}
	}
}
