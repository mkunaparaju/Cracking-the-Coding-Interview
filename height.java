/**
 * 
 */
package CtCi;

import java.util.Arrays;
import java.util.*;

/**
 * @author mkunaparaju
 *
 */
public class height {

	public static void main(String [] args)	{
		int [] arr = {1,2,6,5,5,8,9};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] A) {
		int changes = 0;       
		int [] initArr = new int [A.length]; 
		for(int i = 0; i < A.length; i ++){
			initArr[i] = A[i];
		}
		 Arrays.sort(A);
		HashMap<Integer,Integer> numMap = new HashMap<>();
		ArrayList<Integer> numList = new ArrayList();
	    for(int i = 0; i < initArr.length; i++){
	    	numMap.put(initArr[i], A[i]);
	    	numList.add(initArr[i]);
	    }
	    int p1 = 0;
	    int p2 = 0;
	    for(int i = 0; i < numList.size(); i++)	{
	    	System.out.println("asdf  " + numList.get(i));
	    	if(numList.get(i) != numMap.get(numList.get(i)))	{
	    		//System.out.println("asdf  " + numList.get(i));
	    		p1 = i;
	    		break;
	    	}
	    }
	    
	    for(int j = numList.size() -1; j >=0; j--)	{
	    	System.out.println("qqqqq  " + numList.get(j));
	    	if(numList.get(j) != numMap.get(numList.get(j)))	{
	    		
	    		p2 = j;
	    		break;
	    	}
	    }
	    if(p1 < p2)	{
		    changes = p2 -p1 +1;
	    }

	    
	    
		return changes;
    }
	
}
