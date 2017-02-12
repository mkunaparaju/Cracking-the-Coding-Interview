/**
 * 
 */
package CtCi;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author mkunaparaju
 *
 */
//class MyStack<T>	{
//	
//	private static class StackNode<T>	{
//		T data;
//		StackNode<T> next;
//		
//		StackNode(T data)	{
//			this.data = data;
//		}
//	}
//	
//	StackNode<T> top;
//	StackNode min = new StackNode(new Integer(9999));
//	public T pop()	{
//		
//		if(top == null)	{
//			throw new EmptyStackException();
//		}
//		
//		T elem = top.data;
//		top = top.next;
//		return elem;
//	}
//	
//	public void push(T elem)	{
//	
//		StackNode<T> item = new StackNode<T>(elem);
//		item.next = top;
//		top = item;
//	}
//	
//	public T peek()	{
//		
//		if(top == null)	{
//			throw new EmptyStackException();
//		}
//		
//		return top.data;
//	}
//	
//	public boolean isEmpty()	{
//		return top == null;
//	}
//}

public class StacksBook {
	/**
	 * @param args
	 */
//	//----------------Question 1.1---------------
//	static class FixedMultiStack	{
//		int stackSize;
//		int numOfStacks;
//		int [] values;
//		int [] topIndex;
//		
//		FixedMultiStack(int stackSize, int numOfStacks )	{
//			this.stackSize = stackSize;
//			this.numOfStacks = numOfStacks;
//			values = new int [stackSize* numOfStacks];
//			topIndex = new int[numOfStacks];
//			// initializing top Indexes
//			for(int i = 0; i < numOfStacks; i++)	{
//				topIndex[i] = -1;
//			}
//			
//		}
//		
//		void push(int data, int stackNum)	{
//			int top = topIndex[stackNum - 1];
//			
//			if(isEmpty(stackNum)){
//				top = (stackNum - 1) * stackSize ;
//				values[top] = data;
//				return;
//			}
//			if(!atCapacity(stackNum))	{
//				values[top + 1] = data;
//				topIndex[stackNum - 1] = top + 1; 
//			}
//			else	{
//				System.out.println("no more elements can be added to this stack");
//			}
//		}
//		
//		int pop(int stackNum)	{
//			int top = topIndex[stackNum - 1];
//			if(isEmpty(stackNum)){
//				System.out.println("stack empty");
//				return 0;
//			}
//			int data = values[top];
//			topIndex[stackNum - 1] = top - 1;
//			return data;
//		}
//		
//		int peek(int stackNum)	{
//			
//			int top = topIndex[stackNum - 1];
//			
//			if(isEmpty(stackNum)){
//				System.out.println("stack empty");
//				return 0;
//			}
//			
//			int data = values[top];
//			return data;
//		}
//		
//		boolean isEmpty(int stackNum)	{
//			int top = topIndex[stackNum - 1];
//			return (top == -1);
//		}
//		
//		boolean atCapacity(int stackNum)	{
//			int top = topIndex[stackNum - 1];
//			return (top == ((stackNum  *  stackSize) - 1));
//		}
//	}
//	
//	
//	//------------Question 3.3--------------
//	static class StackOfPlates	{
//		int capacity;
//		int size;
//		Stack<Stack<Integer>> plates;
//		
//		StackOfPlates(int capacity)	{
//			plates = new Stack<Stack<Integer>>();
//			this.capacity = capacity;
//			this.size = 0;
//		}
//		
//		void push(int data)	{
//			// no plates at all
//			if(plates.size() == 0)	{
//				Stack<Integer> plate = new Stack<Integer>();
//				plate.push(data);
//				plates.push(plate);
//				return;
//			}
//			
//			// last plate is full
//			Stack<Integer> plate = plates.pop();
//			if(plate.size() == capacity)	{
//				plates.push(plate);
//				Stack<Integer> newPlate = new Stack<Integer>();
//				newPlate.push(data);
//				return;
//			}
//			
//			//adding to the last plate
//			plate.push(data);
//		}
//		
//		int pop()	{
//			
//			if(plates.size() == 0) {
//				System.out.println("empty stacks");
//				return 0;
//			}
//			
//			Stack<Integer> plate = plates.pop();
//			int item = plate.pop();
//			
//			if(plate.size() != 0)	{
//				plates.push(plate);
//			}
//			
//			return item;
//		}
//		
//		int peek()	{
//			
//			if(plates.size() == 0) {
//				System.out.println("empty stacks");
//				return 0;
//			}
//			
//			Stack<Integer> plate = plates.peek();
//			int item = plate.peek();
//			
//			return item;
//		}
//	}
	
	public static void main(String[] args) {
		
		StacksBook sb= new StacksBook();
		int [] inArr = { 3,2,5,7,9,6,1};
		Stack<Integer> sortedStack = sb.sortStack(inArr);
	//
		
		while(!sortedStack.isEmpty())
			System.out.println(sortedStack.pop());
	}
	
	//Question 3.5 Sort Stack
	
	Stack<Integer> sortStack(int [] inArr)	{
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> sorted = new Stack<Integer>();
		
 		for(int i = 0; i < inArr.length; i++)	{		
			stack.push(inArr[i]);
		}
		
 		while(!stack.isEmpty())	{
 			int item = stack.pop();
 			
 			while((!sorted.isEmpty() && (sorted.peek() > item)))	{
 				stack.push(sorted.pop());
 			}
 			sorted.push(item);
 		}
		return sorted;
	} 
	
	

}
