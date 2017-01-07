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
class QueueImpl	{
	private static class Node	{
			private int data;
			private Node next;
			private Node(int data)	{
				this.data = data;
			}
	}
	
	Node head;
	Node tail;
	
	public boolean isEmpty()	{
		return head == null; 
	}
	
	public int peek()	{
		return head.data;
	}
	
	public void add(int data)	{
		Node nextNode = new Node(data);
		if(tail != null)	{
			tail.next = nextNode;
		}
		if(head == null)	{
			head = nextNode;
		}
	}
	
	public int remove()		{
		int remData = head.data;
		head = head.next;
		if(head == null)	{
			tail = null; 
		}
		return remData;
	}
}


public class Queues	{
	 public static class MyQueue<T> {
	        Stack<T> stackNewestOnTop = new Stack<T>();
	        Stack<T> stackOldestOnTop = new Stack<T>();

	        public void enqueue(T value) { // Push onto newest stack
	        	stackNewestOnTop.push(value);
	        }

	        public T peek() {
	        	if(stackOldestOnTop.isEmpty())	{
	        		while(!stackNewestOnTop.isEmpty())	{
		        		T elem = stackNewestOnTop.pop();
		        		stackOldestOnTop.push(elem);
		        	}
	        	} 
	        	return stackOldestOnTop.peek();
	        }

	        public T dequeue() {
	        	if(stackOldestOnTop.isEmpty())	{
	        		while(!stackNewestOnTop.isEmpty())	{
		        		T elem = stackNewestOnTop.pop();
		        		stackOldestOnTop.push(elem);
		        	}
	        	}
	        	
	            return stackOldestOnTop.pop();
	        }
	    }
	
	 public static void main(String[] args) {
	        MyQueue<Integer> queue = new MyQueue<Integer>();
	        
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        
	        for (int i = 0; i < n; i++) {
	            int operation = scan.nextInt();
	            if (operation == 1) { // enqueue
	                queue.enqueue(scan.nextInt());
	            } else if (operation == 2) { // dequeue
	                queue.dequeue();
	            } else if (operation == 3) { // print/peek
	                System.out.println(queue.peek());
	            }
	        }
	        scan.close();
	    }
}