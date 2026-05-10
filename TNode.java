//KIT107 Assignment 3
/**
 *	Tree Node ADT
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


public class TNode implements TNodeInterface
{
	// finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// non-finals
	protected Object data;		// the value stored in the node
	protected TNode left;		// the left child node of the current node
	protected TNode middle;	// the forward child node of the current node
	protected TNode right;		// the right child node of the current node


	/**
		Constructor method 1.
		Pre-condition: none
		Post-condition: the TNode object holds the parameter value
						(o) within its "data" field and its "parent",
						"left", "forward", and "right" fields are null
		Informally: intialises the instance variables of the newly
					created TNode object to hold the given parameter
					and to terminate the "parent", "left", "forward",
					and "right" fields

	 *	@param o the Object to store in the data field of the node

	*/
	public TNode(Object o)
	{
      	trace("TNode: Constructor starts");

		data=o;
		left=null;
		middle=null;
		right=null;

      	trace("TNode: Constructor ends");
	}


	public void setData(Object o)
	/*
		Set method for "data" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's data field is altered to
						hold the given (o) value
		Informally: assign the value of the parameter to the TNode
					object's "data" instance variable
	*/
	{
		data=o;
	}
	
	
	public void setLeft(TNode n)
	/*
		Set method for "left" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's left field is altered to
						hold the given (n) value
		Informally: assign the value of the parameter to the TNode
					object's "left" instance variable
	*/
	{
		left=n;
	}
	
	
	public void setMiddle(TNode n)
	/*
		Set method for "forward" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's forward field is altered
						to hold the given (n) value
		Informally: assign the value of the parameter to the TNode
					object's "forward" instance variable
	*/
	{
		middle=n;
	}
	
	
	public void setRight(TNode n)
	/*
		Set method for "right" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's right field is altered
						to hold the given (n) value
		Informally: assign the value of the parameter to the TNode
					object's "right" instance variable
	*/
	{
		right=n;
	}
	
	
	public Object getData()
	/*
		Get method for "data" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's data field is returned
		Informally: examine the TNode object's "data" instance
					variable returning its value
	*/
	{
		return data;
	}
	

	public TNode getLeft()
	/*
		Get method for "left" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's left field is returned
		Informally: examine the TNode object's "left" instance
					variable returning its value
	*/
	{
		return left;
	}
	
	
	public TNode getMiddle()
	/*
		Get method for "forward" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's forward field is
						returned
		Informally: examine the TNode object's "forward"
					instance variable returning its value
	*/
	{
		return middle;
	}
	
	
	public TNode getRight()
	/*
		Get method for "right" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's right field is
						returned
		Informally: examine the TNode object's "right" instance
					variable returning its value
	*/
	{
		return right;
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s the String to be displayed as the trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("TNode: " + s);
		}
	}
}
