/**
 * 
 */
package CtCi.TextTreesGraphs;
import java.util.*;
/**
 * @author mkunaparaju
 * Given a binary tree
 * LinkedList of all nodes at a depth
 */
public class ListOfDepths {

	/**
	 * @param args
	 * 
	 */
	
	ArrayList<LinkedList<BNode>> DepthList(BNode root)	{
		ArrayList<LinkedList<BNode>> depthList = new ArrayList<LinkedList<BNode>>();
		depthWithCount(root, depthList, 0 );
		return depthList;
	}
	
	void depthWithCount(BNode root, ArrayList<LinkedList<BNode>> depthList, int level)	{
		
		if( root == null ) return;
		
		if(depthList.size() == level) {
			depthList.add(level, new LinkedList<BNode>());
		}
		
		depthList.get(level).add(root);
		depthWithCount(root.left, depthList, level+1);
		depthWithCount(root.right, depthList, level+1);
	}
	
	ArrayList<LinkedList<BNode>> depthWithBFS(BNode root )	{
		
		ArrayList<LinkedList<BNode>> depthList = new ArrayList<LinkedList<BNode>>();
		LinkedList<BNode> current = new LinkedList<BNode>();
		
		if(root != null) current.add(root);
		
		while(current.size() > 0)	{
			depthList.add(current);
			LinkedList<BNode> parents = current;
			current = new LinkedList<BNode>();

			for(BNode parent: parents) 	{
				if(parent.left != null ) current.add(parent.left);
				if(parent.right != null ) current.add(parent.right);
			}
			
		}
		
		return depthList;
	}
	
	
	public static void main (String [] args)	{
	
		BNode root = new BNode(5);
		root.left = new BNode(10);
		root.right = new BNode(15);
		root.left.left = new BNode(20);
		root.left.right = new BNode(25);
		root.right.left = new BNode(30);
		root.right.right = new BNode(35);
		
		ListOfDepths list = new ListOfDepths();
		//ArrayList<LinkedList<BNode>> depthList = list.DepthList(root);
		ArrayList<LinkedList<BNode>> depthList = list.depthWithBFS(root);
		
		for(LinkedList<BNode> levels: depthList)	{
			for(BNode elem: levels) 	{
				System.out.print(elem.data + " ");
			}
			System.out.println();
		}
		
	}
}
