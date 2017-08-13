/**
 * 
 */
package CtCi.TextTreesGraphs;
import java.util.Arrays;
import java.util.*;


/**
 * @author mkunaparaju
 * Description: Provided a sorted array
 * 				construct a tree with minimal height
 */

class BNode {
    BNode left;
    BNode right;
    int data;
    
    BNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


public class MinimalHeightTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] sortedArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		BNode root = new MinimalHeightTree().getMinimalHeightTree(sortedArr);	
		Queue<BNode> printList = new LinkedList<BNode>();
		printList.add(root);
		
		while(!printList.isEmpty())	{
			BNode current = printList.poll();
			if(current != null) {
				System.out.println(current.data);
				printList.add(current.left);
				printList.add(current.right);
					
			}
		}
		
	}
	
	BNode getMinimalHeightTree(int [] arr)	{
		int start = 0;
		int end = arr.length - 1;
		return getMinUtil(arr, start, end);
	}
	
	BNode getMinUtil(int [] arr, int start, int end) {
		if(start > end) return null;
		
		int mid = (start + end) / 2;
		BNode root = new BNode(arr[mid]);
		root.left  = getMinUtil(arr,start, mid - 1);
		root.right = getMinUtil(arr, mid + 1, end );
		
		return root;
	}
	
	
		

}
