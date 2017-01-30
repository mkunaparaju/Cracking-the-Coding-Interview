/**
 * 
 */
package CtCi;

import java.util.Scanner;

/**
 * @author mkunaparaju
 *
 */
public class BinarySearchImpl {
	
	static boolean binarySearch(int x, int [] bsArray)	{
		//return binarySearchRec(x, bsArray, 0, bsArray.length - 1);
		return binarySearchIter(x, bsArray);
	}
	
	static boolean binarySearchRec(int x, int [] bsArray, int left, int right)	{
		 if(left > right)	{
			 return false;
		 }
		 int mid = left + (right - left) / 2;
		 if(bsArray[mid] == x)	{
			 return true;
		 }
		 if(bsArray[mid] < x){
			return binarySearchRec(x, bsArray, mid + 1, bsArray.length-1);
		 }

		 if(bsArray[mid] > x){
			return binarySearchRec(x, bsArray, 0, mid - 1);
		 }
		return false;
		 	
	}
	
	static boolean binarySearchIter(int x, int [] arr)	{
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right)	{
			int mid = (left + right) / 2;
			if(arr[mid] == x)	{
				return true;
			}
			if(x < arr[mid])	{
				right = mid - 1;
			}
			if(x > arr[mid])	{
				left = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String [] args)	{
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int elems = in.nextInt();
		int [] eArr = new int [elems];
		for(int i = 0; i < elems; i++)	{
			eArr[i] = in.nextInt();
		}
		
		boolean isElemPresent = binarySearch(x, eArr);
		System.out.println(isElemPresent);
	}
}
