package CtCi;

import java.util.ArrayList;
import java.util.Scanner;

///import HackerRank30Days.Node1;

// Java implementation to check if given Binary tree
// is a BST or not
 
/* Class containing left and right child of current
 node and key value*/
class BNode
{
    int data;
    BNode left, right;
 
    public BNode(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTree{
	
    BNode insert(BNode root, int data)
    {
    	if(root == null)
    	{
    		root = new BNode(data);
    	}
    	if(root.data <= data)
    	{
    		root.right = new BNode(data);
    	}
    	
    	return root;
    }
    
   
 
    /* Driver program to test above functions */
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        BNode root=null;
        BinaryTree tree = new BinaryTree();
        while(T-->0){
            int data=sc.nextInt();
            root=tree.insert(root,data);
        }
      //  int height=getHeight(root);
      //  System.out.println(height);
    }	
    
}