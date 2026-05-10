//KIT107 Assignment 3
/**
 *	Grid ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version May 5th 2026
 *	
 *	This file holds the Grid ADT which represents
 *	the maze.  The Grid consists of a location (of
 *	the current position of the solver), a
 *	dimension, a square number (of the stop square),
 *	and a two-dimensional array (table/matrix) of
 *	the squares in a maze.
 *
 * 	This file is complete.
*/


public interface GridInterface
{
	//public Grid(Dimension m, int g)
	//public Grid(Dimension m, Location l, int g) throws IllegalGridException;
	public Object clone();
	public void setSquare(Location l, Square s) throws IllegalGridException;
	public Square getSquare(Location l) throws IllegalGridException;
	public void setDimension(Dimension d);
	public Dimension getDimension();
	public void setLocation(Location l);
	public Location getLocation();
	public void setGoal(int g);
	public int getGoal();
	public void occupySquare(Location l, boolean o);
	public boolean squareOccupied(Location l);
	public void makeWall(Location l, boolean o);
	public boolean isWall(Location l);
	public boolean gameOver();
	public boolean validMove(Location l);
	public void showGrid(Display s);
}
