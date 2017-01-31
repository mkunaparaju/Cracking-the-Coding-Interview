/**
 * 
 */
package CtCi;

import java.util.*;

/**
 * @author mkunaparaju
 *
 */
public class ArraysStringBook {

	public static void main(String [] args)	{
		ArraysStringBook asb = new ArraysStringBook();
		String input = "asdfghlp";
		System.out.println(asb.isUniqueString(input));
	}
	
	boolean isUniqueString(String input)	{
		HashSet<Character> uniqChar = new HashSet<Character>();
		boolean isUniq = false;
		for(int i = 0; i < input.length(); i++)	{
			isUniq = uniqChar.add(input.charAt(i));
			if(!isUniq)	return false;
		}
		return isUniq;
	}
}
