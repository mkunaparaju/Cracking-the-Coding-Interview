/**
 * 
 */
package CtCi;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * @author mkunaparaju
 *Given an array check to see if an element exists 
 *such that the sum of elems on left equals sum of elems on right
 */
public class SherlockAndArray {
	
	public static void main(String [] args)	{
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		
		for(int i = 0; i < testCases; i++)	{
			int elems = in.nextInt();
			int[] elementArray = new int[elems];
			
			for(int elem = 0; elem < elems; elem++)	{
				elementArray[elem] = in.nextInt();
			}
			
			String output = output(elementArray);
			if(elementArray.length == 1)	output = "YES";
			System.out.println(output);
		}
	}
	
	static String output(int [] elemArr)	{
		int length = elemArr.length;
		int lSum = 0;
		int rSum = 0;
		
		//calculating the sum of all elements in the array give us the initial rSum before the loop starts
		for(int elem = 0; elem < length; elem++)	{
			rSum = rSum + elemArr[elem];
		}
		
		for(int elem = 0; elem < length; elem++)	{	
			if(elem == 0)	{
				lSum = lSum + elemArr[elem];
				rSum = rSum - elemArr[elem];
				continue;
			}
			rSum = rSum - elemArr[elem];
			if(lSum == rSum )	{
				return "YES";
			}
			lSum = lSum + elemArr[elem];			
		}
		return "NO";
	}
}
