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
 *
 https://www.hackerrank.com/challenges/ctci-making-anagrams
 */
public class Anagrams {
	public static int numberNeeded(String first, String second) {

			int [] occur = new int[26];
			char a = 'a';
			for(int i =0; i<first.length(); i++)
			{
				char c = first.toLowerCase().charAt(i);
			//	System.out.println(Character.getNumericValue(c) + " " + Character.getNumericValue(a));
				occur[Character.getNumericValue(c) - Character.getNumericValue(a)] = occur[Character.getNumericValue(c) - Character.getNumericValue(a)] + 1;
			}
			for(int i =0; i<second.length(); i++)
			{
				char c = second.toLowerCase().charAt(i);
			//	System.out.println(Character.getNumericValue(c) + " " + Character.getNumericValue(a));
				occur[Character.getNumericValue(c) - Character.getNumericValue(a)] = occur[Character.getNumericValue(c) - Character.getNumericValue(a)] - 1;
			}
			int count =0; 
			
			for(int i : occur){
			//	System.out.println(i);
				count = count + Math.abs(i); }
			return count;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
