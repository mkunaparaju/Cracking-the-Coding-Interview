package CtCi;

import java.util.*;
import java.io.*;

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

public class BinaryTree	{
	
	static int height(BNode root) {
		int height = 0;
		
		if(root == null) return -1;
		
		int htLeft = 1 + height(root.left);
		int htRight = 1 + height(root.right);
		
		height = (htLeft > htRight) ? htLeft : htRight;
		return height;
		
    }
	
	public static BNode insert(BNode root, int data) {
        if(root == null){
            return new BNode(data);
        }
        else {
            BNode cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	
	static void iterativeInOrder(BNode root)	{
		if(root == null) return;
		
		Stack<BNode> inorder = new Stack<BNode>();
		inorder.push(root);
		BNode node = root.left;
		// keep adding the left nodes so the left most is on top.
		
		while(node != null)	{
			inorder.push(node);
			node = node.left;
		}
		
		while(!inorder.isEmpty()){
			BNode popped = inorder.pop();
			System.out.println(popped.data);
			
			if(popped.right != null)	{
				inorder.push(popped.right);
			}
			
			while(popped != null){
				inorder.push(popped.left);
				popped = popped.left;
			}
			
		}
	}
	
	static void iterativePreOrder(BNode root)	{
		if(root == null) return;
		Stack<BNode> preorder = new Stack<BNode>();
		preorder.push(root);
		
		while(!preorder.isEmpty())	{
			BNode top = preorder.pop();
			System.out.println(top.data);
			
			if(top.right != null)	{
				preorder.push(top.right);
				
			}
			
			if(top.left != null)	{
				preorder.push(top.left);
				
			}
		}
	}
		void LevelOrder(BNode root)	{

	       LinkedList<BNode> elements = new LinkedList<BNode>();
	       elements.add(root);
	       
	       while(!elements.isEmpty())   {
	           BNode node = elements.remove();
	           System.out.println(node.data);
	           
	           if(node.left != null)	{
	        	   elements.add(node.left);
	           }
	           
	           if(node.right != null)	{
	        	   elements.add(node.right);
	           }
	           
	       }
	}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        BNode root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}
    
