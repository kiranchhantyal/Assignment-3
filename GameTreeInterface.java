//KIT107 Assignment 3
/**
 *	GameTree ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version May 5th 2026
 *	
 *	This file holds the GameTree ADT which is a
 *	doubly-linked ternary game tree.  The GameTree is
 *	built using TNode ADTs.  A GameTree object consists
 *	of a "root" field which refers to a TNode object
 *	which has a "data" field and "left", "middle",
 *	and "right" references.
 *
 * 	This file is complete.
*/


public interface GameTreeInterface
{
	//public GameTree();
	//public GameTree(Object o);
	public boolean isEmpty();
	public void setData(Object o) throws EmptyGameTreeException;
	public Object getData() throws EmptyGameTreeException;
	public void setLeft(GameTree c) throws EmptyGameTreeException;
	public GameTree getLeft() throws EmptyGameTreeException;
	public void setMiddle(GameTree s) throws EmptyGameTreeException;
	public GameTree getMiddle() throws EmptyGameTreeException;
	public void setRight(GameTree s) throws EmptyGameTreeException;
	public GameTree getRight() throws EmptyGameTreeException;
	public void resetCount();
	public void incCount();
	public int getCount();
	public GameTree buildGameDF(MazeSolver m, Stack s);
	public GameTree buildGameBF(MazeSolver m, Queue q);
	public String toString();
}
