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
		//--------------question 1.1------------------
		String input = "asdfghlp";
		//System.out.println(asb.isUniqueHashSet(input));
		
		//--------------question 1.2------------------
		String inPerm = "qwerty";
		String checkPerm = "trewq";
		//System.out.println(asb.isPermutation(inPerm, checkPerm));
		
		//--------------question 1.3------------------
		String urlInput = "Mr jonn travolta        ";
		int urlLength = 16;
		//System.out.println(asb.urlify(urlInput, urlLength));
		
		//--------------question 1.4------------------
		
		String permIn = "a cat";
		//System.out.println(asb.isPalinPermutation(permIn));
		
		//--------------question 1.5------------------
		String oneAwayInput = "pale";
		String oneAwayNextIn = "palesq";
		boolean oneAway = asb.oneAway(oneAwayInput, oneAwayNextIn );
		//System.out.println("is one edit away: " + oneAway);
		
		//-------------question 1.6-------------------
		
		String longStr = "aabbccccccaaa";
		//System.out.println(asb.compressedString(longStr));
		
		//--------------question 1.7------------------//only for nxn
		int [][] origMatrix = {{1,2,3,10}, {4,5,6,11}, {7,8,9,12}, {13,14,15,16}};
		//asb.printRotatedMatrix(origMatrix);
		
		//------------question 1.8--------------------
		int [][] mnMatrix = {{1,0,1,2}, {5,6,7,5}, {8,9,3,8}};
		asb.setZeroMatrix(mnMatrix);
		
		//--------------question 1.9------------------
		String in = "stackoverflow";
		String rotate = "overflowstack";
		//System.out.println("is String a Rotation " + asb.stringRotation(in, rotate));
	}
	
	//Question 1.1
	boolean isUniqueHashSet(String input)	{
		HashSet<Character> uniqChar = new HashSet<Character>();
		boolean isUniq = false;
	
		for(int i = 0; i < input.length(); i++)	{
			isUniq = uniqChar.add(input.charAt(i));
			if(!isUniq)	return false;
		}
		
		return isUniq;
	}
	//Question 1.2
	boolean isPermutation(String in, String check)	{
		boolean isPerm = (in.length() == check.length()) ? true : false;
		HashSet<Character> checkSet = new HashSet<Character>();
		for (int i = 0; i < in.length(); i++)	{
			checkSet.add(in.charAt(i));
		}
		for(int i = 0; i < check.length(); i++)	{
			if(!checkSet.contains(check.charAt(i)))	{
				isPerm  = false;
				break;
			}
		}
		return isPerm;
	}
	
	//Question 1.3
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
	
	//Question 1.4
	boolean isPalinPermutation(String in)	{
		boolean ispp = false;
		boolean even = (in.length() % 2 == 0) ? true : false;
		String [] inArr = in.split(" ");
		String checkIn = "";
		
		for(int i = 0; i < inArr.length; i++)	{
			checkIn = checkIn + inArr[i];
		}
		checkIn.toLowerCase();

		HashMap<Character, Integer> checkMap = new HashMap<Character,Integer>();
		for (int i = 0; i < checkIn.length(); i++)	{
			if(checkMap.containsKey(checkIn.charAt(i)))	{
				int val = checkMap.get(checkIn.charAt(i));
				checkMap.put(checkIn.charAt(i), val+1);
			}
			else	{
				checkMap.put(checkIn.charAt(i), 1);
			}
		}
		System.out.println(checkMap.size());
		int count = 0;
		Collection<Integer> checkList = checkMap.values();
		System.out.println(checkList.size());
		for(Integer i : checkList)	{
			if(i % 2 != 0)	count++;
			System.out.println(count + " count ");
		}
		if(count > 1) {
			return false;
		}
		return true;
	}
	
	//Question 1.5
	boolean oneAway(String str, String cmpStr)	{
		
		// basic length checks
		if((Math.abs(str.length() - cmpStr.length())) > 1)	{
			return false;
		}
		
		int countRemRep = 0;
		int j = 0;
		
		//for remove and replace
		if(cmpStr.length() <= str.length())	{
			
			for(int i = 0; i < str.length(); i++ )	{
				if(i == cmpStr.length()) return true;
				
				if(str.charAt(i) != cmpStr.charAt(j))	{
					countRemRep++;
					j = (cmpStr.length() < str.length()) ? (j-1) : j;
					if(countRemRep > 1) return false;
				}
				j++;
			}
		}
		
		//for addition
		else	{
			
			for(int i = 0; i < cmpStr.length(); i++ )	{
				if(i == str.length()) return true;
				
				if(str.charAt(j) != cmpStr.charAt(i))	{
					countRemRep++;
					j--;
					if(countRemRep > 1) return false;
				}
				j++;
			}		 
		}
		return true; 
	}
	
	//Question 1.6
	String compressedString(String in)	{
		ArrayList<Character> charArr = new ArrayList<Character>();
		ArrayList<Integer> charCount = new ArrayList<Integer>();
		for(int i = 0; i < in.length(); i++)	{
			
			if(charArr.size() == 0){
				charArr.add(in.charAt(i));
				charCount.add(1);
				continue;
			}
			
			if(in.charAt(i) == charArr.get(charArr.size() - 1))	{
				int val = charCount.remove(charCount.size() - 1);
				charCount.add(val + 1);
			}
			else	{
				charArr.add(in.charAt(i));
				charCount.add(1);
			}
		}
		
		String output = "";
		for(int i = 0; i < charArr.size(); i++)	{
			output = output + charArr.get(i) + charCount.get(i);
		}
		if(output.length() == in.length()) return in;
		return output;
	}
		
	//Question 1.7 --- transpose and exchange rows // only nxn
	void printRotatedMatrix(int [][] origmatrix)	{
		int [][] matrix = transposeMatrix(origmatrix);
		int len = matrix[0].length;
		for(int i = 0; i < matrix.length; i++)	{
			for(int j = 0; j < len/2; j++)	{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][len-1-j];
				matrix[i][len-1-j] = temp;
			}
		}
		
		for(int i = 0; i < matrix.length; i++)	{
			for(int j = 0; j < matrix[0].length; j++)	{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	int [][] transposeMatrix(int [][] matrix)	{
		for(int i = 0; i < matrix.length; i++)	{
			for(int j = i; j < matrix[0].length; j++)	{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		return matrix;
	}
	
	//Question 1.8
	void setZeroMatrix(int [][] m)	{
		
	}
	
	
	//Question 1.9 ------------
	boolean stringRotation(String in, String rotate)	{
		
		if(in.length() != rotate.length()) return false;
		String doubleIn = in.concat(in);
		//System.out.println(doubleIn);
		return isSubString(doubleIn, rotate);
	}
	
	boolean isSubString(String in, String str)	{
		int len = str.length();
		for(int i = 0; i < in.length() - len; i++)	{
			if(str.equals(in.substring(i, len + i)) ) return true;
		}
		return false;
	}
	
	
}
