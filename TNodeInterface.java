//KIT107 Assignment 3
/**
 *	Tree Node ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version May 5th 2026
 *	
 *	This file holds the GameTree Node ADT which represents
 *	the nodes in a ternary tree.  GameTree nodes consist of
 *	a "data" field and three references to other nodes
 *	(these being the three child nodes ("left", "middle",
 *	and "right")).
*/


public interface TNodeInterface
{
	//public TNode(Object o);
	public void setData(Object o);
	public Object getData();
	public void setLeft(TNode n);
	public TNode getLeft();
	public void setMiddle(TNode n);
	public TNode getMiddle();
	public void setRight(TNode n);
	public TNode getRight();
}
