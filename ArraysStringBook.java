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
		//System.out.println(asb.isUniqueHashSet(input));
	
		String urlInput = "Mr jonn travolta        ";
		int urlLength = 16;
		//System.out.println(asb.urlify(urlInput, urlLength));
		
		String oneAwayInput = "pale";
		String oneAwayNextIn = "ple";
		boolean oneAway = asb.oneAway(oneAwayInput, oneAwayNextIn );
	}
	
	boolean isUniqueHashSet(String input)	{
		HashSet<Character> uniqChar = new HashSet<Character>();
		boolean isUniq = false;
		for(int i = 0; i < input.length(); i++)	{
			isUniq = uniqChar.add(input.charAt(i));
			if(!isUniq)	return false;
		}
		return isUniq;
	}
	//using a string builder instead of a string due stringbuilder being a resizable array
	String urlify(String in, int len)	{
		StringBuilder url = new StringBuilder();
		String [] words = in.split(" ");
		for(int i = 0; i < words.length - 1; i++)	{
			url.append(words[i]);
			url.append("%20");
		}
		url.append(words[words.length - 1]);
		return url.toString();
	}
	
	boolean oneAway(String in, String nextIn)	{
		boolean isReplace = false;
		boolean isInsert = false;
		boolean isRemove = false;
		int count = 0;
		
		ArrayList<Character> inList = new ArrayList<Character>();
		for(int i = 0; i < in.length(); i++ )	{
			inList.add(in.charAt(i));
		}
		
		if(in.length() - nextIn.length() > 1)	return false;
		if(nextIn.length() - in.length() > 1)	return false;
		isReplace = isReplace(inList, nextIn);
		
		
		return true;
	 }
	
	boolean isReplace(ArrayList<Character> inList, String nextIn)	{
		int count = 0;
		for(int i = 0; i < nextIn.length(); i++)	{
			if(inList.contains(nextIn.charAt(i)))	{
				
			}
		}
		return false;
	}
}
