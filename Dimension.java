//KIT107 Assignment 3
/**
 *	Dimension ADT
 *
 *	@author Kiran Chhantyal(770872)
 *	@version << Date of Completion >>
 *	
 *	This file holds the Dimension ADT which represents
 *	the two-dimensional size of a maze.  The maze's
 *	dimension consists of vertical and horizontal
 *	components.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


public class Dimension implements DimensionInterface
{
	// finals
	protected final boolean TRACING=true;				// do we want to see trace output?

	// non-finals
	protected int vert;		// the height of a maze (number of rows)
	protected int horiz;	// the width of a maze (number of columns)
	
	
	/**
	 *	Dimension
	 *	Constructor method.
	 *	Pre-condition: the height (v) and width (h) are valid
	 *				   positive integers
	 *	Post-condition: the Dimension object records the vertical and
	 *					horizontal sizes within instance variables
	 *	Informally: intialises the instance variables of the newly
	 *				created Dimension object to hold the vertical and
	 *				horizontal component values
	 *
	 * @param v the vertical dimension
	 * @param h the horizontal dimension
	*/
	public Dimension(int v, int h)
	{
      	trace("Dimension: Constructor starts");

	vert = v;
	horiz = h;

      	trace("Dimension: Constructor ends");
	}
	
	
	/**
	 *	setVert
	 *	Set method for "vert" instance variable.
	 *	Pre-condition: the height (v) is a valid positive integer
	 *	Post-condition: the Dimension object's vertical size is
	 *					altered to hold the given (v) value
	 *	Informally: assign the value of the parameter to the Dimension
	 *				object's vertical component instance variable
	 *
	 * @param v the vertical dimension
	*/
	public void setVert(int v)
	{
      	trace("setVert: setVert starts");

//COMPLETE ME!

      	trace("setVert: setVert ends");
	}
	
	
	/**
	 *	setHoriz
	 *	Set method for "horiz" instance variable.
	 *	Pre-condition: the width (h) is a valid positive integer
	 *	Post-condition: the Dimension object's horizontal size is
	 *					altered to hold the given (h) value
	 *	Informally: assign the value of the parameter to the Dimension
	 *				object's horizontal component instance variable
	 *
	 * @param h the horizontal dimension
	*/
	public void setHoriz(int h)
	{
      	trace("setHoriz: setHoriz starts");

//COMPLETE ME!

      	trace("setHoriz: setHoriz ends");
	}
	
	
	/**
	 * 	getVert
	 * 	Get method for "vert" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Dimension object's vertical size is
	 *					returned
	 *	Informally: examine the Dimension object's vertical component
	 *				instance variable returning its value
	 *
	 * @return int the vertical dimension
	*/
	public int getVert()
	{
      	trace("getVert: getVert starts and ends");

//COMPLETE ME
		return 0;	// CHANGE ME
	}
	
	
	/**
	 *	Get method for "horiz" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Dimension object's horizontal size is
	 *					returned
	 *	Informally: examine the Dimension object's horizontal component
	 *				instance variable returning its value
	 *
	 * @return int the horizontal dimension
	*/
	public int getHoriz()
	{
      	trace("getHoriz: getHoriz starts and ends");

//COMPLETE ME
		return 0;	// CHANGE ME
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s String to display as a trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("Dimension: " + s);
		}
	}
}