/**
 * 
 */
package CtCi.TextTreesGraphs;

/**
 * @author mkunaparaju
 *
 */
public class ValidateBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(10);
		root.right = new BNode(30);
		root.left.left = new BNode(5);
		root.left.right = new BNode(15);
		root.left.left.left = new BNode(3);
		root.left.left.right = new BNode(7);
		root.left.right.right = new BNode(17);
		
		ValidateBST validate = new ValidateBST();
		System.out.println(validate.isBST(root));

	}
	
	boolean isBST(BNode root) {
		if (root == null) return true;
		
		boolean left = (root.left != null) ? (root.left.data < root.data) : true;
		boolean right = (root.right != null) ? (root.right.data > root.data) : true;
		
		return isBST(root.left) && isBST(root.right) && left && right;		
	}
	
	

}
