/**
 * 
 */
package CtCi;

import java.util.*;

/**
 * @author mkunaparaju
 *
 */
public class RedBlueBlueRed {

	/**
	 * @param args
	 */ 
	HashMap<String, String> patMatch = new HashMap<String, String>();
	public static void main(String[] args) {
		String pattern = "abba";
		String input = "redbluebluered";
			
		int output = isPatternMatch(pattern, input) ? 1 : 0;	
		System.out.println(output);
	}
	
	static boolean isPatternMatch(String pat, String in)	{
		
		if(pat.length() == 0 && in.length() == 0)	{
			return true;
		}
		if(pat.length() > in.length() || pat.length() == 0)	{
			return false;
		}
		
		
		return false;
	}

}
