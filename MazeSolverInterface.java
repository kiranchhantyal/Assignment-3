//KIT107 Assignment 3
/**
 *	Interface for Graphical User Interface and Solution
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


public interface MazeSolverInterface
{
	//public MazeSolver(String a)
    public void paint(Graphics g);
	public void actionPerformed(ActionEvent e);
	public void update(GameTree t);
}
