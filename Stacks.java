/**
 * 
 */
package CtCi;

import java.util.Scanner;
import java.util.Stack;



/**
 * @author mkunaparaju
 *
 */
class StackImpl {
	private static class Node	{
		private int data;
		private Node next;
		private Node(int data)	{
			this.data = data;
		}
	}

	Node top;
	
	public boolean isEmpty()	{
		return top == null;
	}
	
	public int peek()	{
		return top.data;
	}
	
	public void push(int data)	{
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	public int pop()	{
		int data = top.data;
		top = top.next;
		return data;
	}
}

public class Stacks	{
	
	public static void main(String [] args)	{
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    String [] exprA = new String[t];
	    for (int a0 = 0; a0 < t; a0++) {
	        String expression = in.next();
	       exprA[a0] = expression;
	       
	    }
	    for(int i = 0; i < exprA.length; i++)	{
	    	System.out.println( (isBalanced(exprA[i])) ? "YES" : "NO" );
	    }
	}
	
	public static boolean isBalanced(String expr)	{
		boolean isBalanced = false;
		Stack<Character> stack = new Stack<Character>();
		int length = expr.length();
		char [] exprArr = expr.toCharArray();
		
		for(int i = 0; i < exprArr.length; i++)	{
			
			if(expr.charAt(i) == '(' || expr.charAt(i) == '{' || expr.charAt(i) == '[')	{
				stack.push(expr.charAt(i));
				isBalanced = false;
			} 
			else	{
				if(stack.isEmpty())	{
					return false;
				}
				char bracket = stack.pop();
				if(exprArr[i] == ')')	{
					if(bracket == '(')	{
						isBalanced = true;
					}
					else	{
						return false;
					}
				}
				
				if(exprArr[i] == '}')	{
					if(bracket == '{')	{
						isBalanced = true;
					}
					else	{
						return false;
					}
				}
				
				if(exprArr[i] == ']')	{
					if(bracket == '[')	{
						isBalanced = true;
					}
					else	{
						return false;
					}
				}
			}
		}
		return isBalanced;
	}
}
	
	

