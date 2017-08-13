/**
 * 
 */
package CtCi.TextTreesGraphs;

/**
 * @author mkunaparaju
 *
 */
public class CheckBalanced {

	/**
	 * @param args
	 * Check if a Binary tree is balanced
	 * Height of a the subtrees of any node 
	 * Do not vary by more than 1
	 */
	public static void main(String[] args) {
		CheckBalanced check = new CheckBalanced();
		BNode root = new BNode(5);
		root.left = new BNode(10);
		root.right = new BNode(15);
		root.left.left = new BNode(20);
		root.left.right = new BNode(25);
		root.right.left = new BNode(30);
		root.right.left.left = new BNode(35);
		root.right.left.left.right = new BNode(45);
		root.right.left.left.right.left = new BNode(55);
		
		
		System.out.println(check.isBalanacedTree(root));
	}
	
	boolean isBalanacedTree(BNode root)	{
		 return height(root) != Integer.MIN_VALUE;
		
	}
	
	int height(BNode root) {
		if(root == null) return -1;
		
		int leftHeight = height(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

		int rightHeight = height(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

		if(Math.abs(rightHeight - leftHeight) > 1) return Integer.MIN_VALUE;
		else return Math.max(leftHeight, rightHeight) + 1;
	}

}
