//KIT107 Assignment 3
/**
 *	GameTree ADT
 *
 *	@author << Student Names and IDs >>
 *	@version << Date of Completion >>
 *	
 *	This file holds the GameTree ADT which is a
 *	doubly-linked ternary game tree.  The GameTree is
 *	built using TNode ADTs.  A GameTree object consists
 *	of a "root" field which refers to a TNode object
 *	which has a "data" field and "left", "middle",
 *	and "right" references.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


public class GameTree implements GameTreeInterface
{
	// finals
	protected final boolean TRACING=true;				// do we want to see trace output?

	// non-finals
	// static non-finals
	protected static int count;	// a counter available to all instances

	// non-static non-finals
	protected TNode root;	// the node at the top of the tree


	/**
	 *	GameTree
	 *	Constructor method 1.
	 *	Pre-condition: none
	 *	Post-condition: the GameTree object's "first" field is null
	 *	Informally: creates an empty tree
	*/
	public GameTree()
	{
		trace("GameTree: constructor starts");
		
//COMPLETE ME
		
		trace("GameTree: constructor ends");
	}


	/**
	 *	GameTree
	 *	Constructor method 2.
	 *	Pre-condition: none
	 *	Post-condition: the GameTree object's "first" field refers
	 *					to a new TNode object containing the
	 *					parameter value (o) with a null parent
	 *					and null children
	 *	Informally: create a tree of a single node (i.e. a leaf)
	 *				with the node value provided on the parameter
	 *				list
	 *
	 *	@param o Object to include in GameTree node
	*/
	public GameTree(Object o)
	{
		trace("GameTree: constructor starts");
		
		root=new TNode(o);
		
		trace("GameTree: constructor ends");
	}
	
	
	/**
	 *	isEmpty
	 *	Check if the game tree is empty
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the GameTree object has no
	 *					items, false is returned if it does
	 *	Informally: indicate if the GameTree contains no nodes
	 *
	 *	@return boolean whether or not the game tree is empty
	*/
	public boolean isEmpty()
	{
		trace("isEmpty: isEmpty starts and ends");
		
		return (root == null);
	}


	/**
	 *	getData
	 * Get method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's data
	 *					field is returned
	 *	Informally: return the value within the root node,
	 *				throw an exception if the tree is empty
	 *
	 *	@return Object the data item of the root node
	*/
	public Object getData() throws EmptyGameTreeException
	{
		trace("getData: getData starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("getData: empty game tree");
			throw new EmptyGameTreeException();
		}

		// non-empty tree
		trace("getData: getData ends");
//COMPLETE ME
		return null;	//CHANGE ME
	}
	
	
	/**
	 *	getLeft
	 *	Get method for "left" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's left
	 *					field is returned in a newly
	 *					constructed GameTree object
	 *	Informally: return the GameTree object's left child, throw
	 *					an exception if the tree is empty
	 *
	 * 	@return GameTree the left sub-tree
	*/
	public GameTree getLeft() throws EmptyGameTreeException
	{
		GameTree r;	// result
		
      	trace("getLeft: getLeft starts");
		
		if (isEmpty())
		{
			// no left branch...
    	  	trace("getLeft: tree is empty...");

			throw new EmptyGameTreeException();
		}
  
		// create the result and connect the branch
      	trace("getLeft: creating result");

		r=new GameTree();
		r.root=root.getLeft();

      	trace("getLeft: getLeft ends");		
		return r;
	}


	/**
	 * 	getMiddle
	 *	Get method for "middle" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's middle
	 *					field is returned in a newly
	 *					constructed GameTree object
	 *	Informally: return the GameTree object's middle child,
	 *					throw an exception if the tree is empty
	 *
	 * 	@return GameTree the middle sub-tree
	*/
	public GameTree getMiddle() throws EmptyGameTreeException
	{
		GameTree r;	// result
		
      	trace("getMiddle: getMiddle starts");
		
		if (isEmpty())
		{
			// no middle branch...
    	  	trace("getMiddle: tree is empty...");

			throw new EmptyGameTreeException();
		}
  
//COMPLETE ME
      	trace("getMiddle: getMiddle ends");		
		return null;	//CHANGE ME
	}


	/**
	 * 	getRight
	 *	Get method for "right" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's right
	 *					field is returned in a newly
	 *					constructed GameTree object
	 *	Informally: return the GameTree object's right child,
	 *					throw an exception if the tree is empty
	 *
	 * 	@return Gametree the right sub-tree
	*/
	public GameTree getRight() throws EmptyGameTreeException
	{
		GameTree r;	// result
		
      	trace("getRight: getRight starts");
		
		if (isEmpty())
		{
			// no right branch...
    	  	trace("getRight: tree is empty...");

			throw new EmptyGameTreeException();
		}
  
//COMPLETE ME
      	trace("getRight: getRight ends");		
		return null;	//CHANGE ME
	}


	/**
	 * 	getCount
	 *	Get method for "count" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's count
	 *					field is returned in a newly
	 *					constructed GameTree object
	 *	Informally: return the GameTree object's count field,
	 *					throw an exception if the tree is empty
	 *
	 * 	@return int the count of considered moves
	*/
	public int getCount()
	{
      	trace("getCount: getCount starts and ends");

		return count;
	}


	/**
	 *	setData
	 *	Set method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's data field is altered to
	 *					hold the given (o) value
	 *	Informally: store the given value in the root node of the
	 *				GameTree object, throw an exception if the tree is
	 *				empty
	 *
	 * 	@oaram Object the value intended for the data field
	*/
	public void setData(Object o) throws EmptyGameTreeException
	{
      	trace("setData: setData starts");

		if (isEmpty())
		{
			// empty tree, can't continue
      		trace("setData: empty tree");

			throw new EmptyGameTreeException();
		}

//COMPLETE ME
      	trace("setData: setData ends");
	}
	
	
	/**
	 *	setLeft
	 *	Set method for "left" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's left field is altered
	 *					to hold the given (t) value
	 *	Informally: assign the given value as the left child of
	 *				the GameTree object, throw an exception if the tree
	 *				is empty
	 *
	 * 	@param GameTree the value intended for the left field
	*/
	public void setLeft(GameTree t) throws EmptyGameTreeException
	{
      	trace("setLeft: setLeft starts");

		if (isEmpty())
		{
			// empty tree, can't continue
      		trace("setLeft: empty tree");

			throw new EmptyGameTreeException();
		}
		
//COMPLETE ME
      	trace("setLeft: setLeft ends");
	}
	
	
	/**
	 * 	setMiddle
	 *	Set method for "middle" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's middle field is
	 *					altered to hold the given (t) value
	 *	Informally: assign the given value as the middle child of
	 *				the GameTree object, throw an exception if the tree
	 *				is empty
	 *
	 * @param GameTree the value intended for the middle field
	*/
	public void setMiddle(GameTree t) throws EmptyGameTreeException
	{
      	trace("setMiddle: setMiddle starts");

		if (isEmpty())
		{
			// empty tree, can't continue
      		trace("setMiddle: empty tree");

			throw new EmptyGameTreeException();
		}
		
//COMPLETE ME
      	trace("setMiddle: setMiddle ends");
	}
	
	
	/**
	 * 	setRight
	 *	Set method for "right" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's right field is
	 *					altered to hold the given (t) value
	 *	Informally: assign the given value as the right child of
	 *				the GameTree object, throw an exception if the
	 *				tree is empty
	 *
	 * @param GameTree the value intended for the right field
	*/
	public void setRight(GameTree t) throws EmptyGameTreeException
	{
      	trace("setRight: setRight starts");

		if (isEmpty())
		{
			// empty tree, can't continue
      		trace("setRight: empty tree");

			throw new EmptyGameTreeException();
		}
		
//COMPLETE ME
      	trace("setRight: setRight ends");
	}


	/**
	 * 	resetCount
	 * 	Set method for "count" instance variable.
	 * 	Pre-condition: none
	 * 	Post-condition: the GameTree object's count field is
	 *				   altered to hold the value 0
	 *	Informally: reset the count field of the GameTree object, 
	 *				throw an exception if the tree is empty
	 */
	public void resetCount()
	{
      	trace("resetCount: resetCount starts");

		count=0;

      	trace("resetCount: resetCount ends");
	}


	/**
	 * 	incCount
	 *	Set method for "count" instance variable.
	 * 	Pre-condition: none
	 * 	Post-condition: the GameTree object's count field is
	 *				   incremented
	 *	Informally: add one to the count field of the GameTree 
	 *				object, throw an exception if the tree is 
	 *				empty
	 */
	public void incCount()
	{
      	trace("incCount: incCount starts");

		count++;

		trace("incCount: incCount ends");
	}


	/**
	 *	generateLevelDF
	 *	Generate the next level of the tree
	 *	Pre-condition: the current tree is not empty and the given
	 *				   stack is defined
	 *	Post-condition: an additional level of possible moves has
	 *					been added to the given game tree and each
	 *					tree node of the new level also has been
	 *					pushed onto the stack.
	 *	Informally: generate the next level of the game tree
	 *
	 *	@param s Stack of reachable but unexpanded game trees
	*/
	protected void generateLevelDF(Stack s)
	{
		// local final variables
		final int HORIZONTAL[]={-1,0,+1,0};	// together these two arrays represent changes to the row and column for
		final int VERTICAL[]={0,-1,0,+1};	// the four movements: [0] is left, [1] is up, [2] is right, [3] is down
	
		// local non-final variables
		
		trace("generateLevelDF: generateLevelDF starts");
		
//COMPLETE ME
	
		trace("generateLevelDF: generateLevelDF ends");
	}
	
	
	/**
	 *	buildGameDF
	 *	Generate the game tree in a depth-first manner
	 *	Pre-condition: the current tree is defined and the given
	 *				   Stack and MazeSolver objects are defined
	 *	Post-condition: If the given tree's root node isn't the
	 *					solved maze, the next level of possible
	 *					alternate moves has been generated, each
	 *					has been added to the stack and then
	 *					the next tree is determined by removing 
	 *					the top of the stack and the maze at the
	 *					root of the obtained game tree is
	 *					displayed.  The process continues until the
	 *					stack is empty or the solution is found.
	 *	Informally: generate the game tree from the current point
	 *				in a depth-first manner until the solution is
	 *				reached or the maze is found to be unsolveable.
	 *
	 *	@param m MazeSolver containing the Display to paint the
	 *				grid onto
	 *	@param s Stack of reachable but unexpanded game trees
	 *
	 * 	@return	GameTree an empty tree if the maze has no solution,
	 * 			or a GameTree with the solution at the root.
	*/
	public GameTree buildGameDF(MazeSolver m, Stack s)
	{
		GameTree t;	// game tree containing next candidate move
		Grid b;		// grid from current tree
			
		trace("buildGameDF: buildGameDF starts");

//COMPLETE ME
		
		trace("buildGameDF: buildGameDF ends");

		return null;	//CHANGE ME
	}
	
	
	/**
	 *	generateLevelBF
	 *	Generate the next level of the tree
	 *	Pre-condition: the current tree is not empty and the given
	 *				   queue is defined
	 *	Post-condition: an additional level of possible moves has
	 *					been added to the given game tree and each
	 *					tree node of the new level also has been
	 *					added onto the queue.
	 *	Informally: generate the next level of the game tree
	 *
	 *	@param q Queue of reachable but unexpanded game trees
	*/
	protected void generateLevelBF(Queue q)
	{
		// local final variables
		final int HORIZONTAL[]={-1,0,+1,0};	// together these two arrays represent changes to the row and column for
		final int VERTICAL[]={0,-1,0,+1};	// the four movements: [0] is left, [1] is up, [2] is right, [3] is down
	
		// local non-final variables
		
		trace("generateLevelBF: generateLevelBF starts");
		
//COMPLETE ME

		trace("generateLevelBF: generateLevelBF ends");
	}
	
	
	/**
	 *	buildGameBF
	 *	Generate the game tree in a breadth-first manner
	 *	Pre-condition: the current tree is defined and the given
	 *				   Queue and MazeSolver objects are defined
	 *	Post-condition: If the given tree's root node isn't the
	 *					solved maze, the next level of possible
	 *					alternate moves has been generated, each
	 *					has been added to the queue and then
	 *					the next tree is determined by removing 
	 *					the front of the queue and the maze at the
	 *					root of the obtained game tree is
	 *					displayed.  The process continues until the
	 *					queue is empty or the solution is found.
	 *	Informally: generate the game tree from the current point
	 *				in a breadth-first manner until the solution is
	 *				reached or the maze is found to be unsolveable.
	 *
	 *	@param m MazeSolver containing the Display to paint the
	 *				grid onto
	 *	@param q Queue of reachable but unexpanded game trees
	 *
	 * 	@return	GameTree an empty tree if the maze has no solution,
	 * 			or a GameTree with the solution at the root.
	*/
	public GameTree buildGameBF(MazeSolver m, Queue q)
	{
		GameTree t;	// game tree containing next candidate move
		Grid b;		// grid from current tree
					
		trace("buildGameBF: buildGameBF starts");

//COMPLETE ME
		
		trace("buildGameBF: buildGameBF ends");

		return null;	//CHANGE ME
	}				


	/**
	 *	rootNodeToString
	 *	Convert contents of root node to a String
	 *	Pre-condition: none
	 *	Post-condition: a String object is returned consisting of the
	 *				String representation of the value within the
	 *				root node, followed by " " or "<>" if the GameTree
	 *				object is the empty tree
	 *	Informally: produce a String representation of the tree's root
	 *				node
	 *	
	 *	@return String the printable form of the maze in the root node
	*/
	protected String rootNodeToString()
	{
		String s="";	// solution

		trace("rootNodeToString: rootNodeToString starts");
		
		if (isEmpty())
		{
			// nothing in the root node
			s="<>";
		}
		else
		{
			// add String version of data field to result
			s+=(getData().toString() + " ");
		}

		trace("rootNodeToString: rootNodeToString ends");
		return s;
	}
	
	
	/**
	 * 	toString
	 * 	Convert tree contents to a String
	 *	Pre-condition: none
	 *	Post-condition: a String object is returned consisting of the
	 *				String representation of all items in the GameTree,
	 *				from top to bottom in depth-first order (left,
	 *				middle, right), separated by " " and
	 *				contained within "<" and ">"
	 *	Informally: produce a String representation of the Stack
	 *
	 *	@return String the text-based printable form of the game tree
	*/
	public String toString()
	{
		GameTree c;	// traversal variable if printing entire tree
		String s;	// solution string

		trace("toString: toString starts");
		
		if (isEmpty())
		{
			// nothing to see here
			trace("toString: toString ends");
			s="<>";
		}
		else
		{
			// traverse, node value first
			s=rootNodeToString();

			// and then the children in depth-first order
			// Uncomment the following to see the remainder of the tree
			// Warning: 'there be dragons!'
			/*c=getLeft();
			if (! c.isEmpty())
			{
				s+=(c.toString());
			}
			c=getMiddle();
			if (! c.isEmpty())
			{
				s+=(c.toString());
			}
			c=getRight();
			if (! c.isEmpty())
			{
				s+=(c.toString());
			}/**/
		}

		trace("toString: toString ends");
		return s;
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
			System.out.println("GameTree: " + s);
		}
	}
}
