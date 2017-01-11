/**
 * 
 */
package CtCi;

import java.util.*;

/**
 * @author mkunaparaju
 *
 */
public class time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solution(2,4,0,0));

	}
	
	public static String solution(int A, int B, int C, int D) {
        
	      if(A > 2 && B > 2 && C > 2 && D > 2)    {
	        	return "NOT POSSIBLE";
	        }
			int fmax = 0;
			int smax = 0;
			int tmax = 0;
			int fpos = 0;
			int spos = 0;
			int tpos = 0;
			
			boolean second  = false;
			boolean third = false;
	        String time = "";
	        ArrayList<Integer> nums = new ArrayList<Integer>();
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        nums.add(A);
	        nums.add(B);
	        nums.add(C);
	        nums.add(D);
	        for(int i = 0; i < nums.size(); i++){
	        	if(nums.get(i) <= 2){
	        		if(nums.get(i) > fmax){
	        			fmax = nums.get(i);
	        			fpos = i;
	        		}	
	        	}
	        }

	    	time = time + fmax;
	    	nums.remove((Integer)fmax);
	    	
	    	for(int i = 0; i < nums.size(); i ++){
	    	    System.out.println("qqqqqqqq "  + nums.get(i));
	    		if(fmax < 2){	
	    			if(nums.get(i) > smax)	{
	    				smax = nums.get(i);
	    				spos = i;
	    				second = true;
	    			}
	    		}
	    		else	{
	    			if(nums.get(i) < 4)	{
	    				if(nums.get(i) > smax)	{
	    					smax = nums.get(i);
	    					spos = i;
	    				}
	    				second = true;
	    			}
	    		}
	    	}
	    	if(!second)	{
	    		return "NOT POSSIBLE";
	    	}
	    	time = time + smax + ":";
	    	nums.remove((Integer)smax);
	    	
	    	for(int i = 0; i < nums.size(); i++)	{
	    	    System.out.println("sdfsf "  + nums.get(i));
	    		if(nums.get(i) < 6)	{
	    			third = true; 
	    			if(nums.get(i) > tmax)	{
	    				tmax = nums.get(i);
	    				tpos = i;
	    			}
	    		}
	    	}
	    	
	    	if(!third)	{
	    		return "NOT POSSIBLE";
	    	}
	    	time = time + tmax;
	    	nums.remove((Integer)tmax);
	    	
	    	
	    	time = time + nums.get(0);
	    	
	     return time;    
	    }
	
}
