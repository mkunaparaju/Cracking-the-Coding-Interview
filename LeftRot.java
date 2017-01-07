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
 Performs Left rotation on Arrays 
 (https://www.hackerrank.com/challenges/ctci-array-left-rotation)
 */
public class LeftRot {
	 public static int[] arrayLeftRotation(int[] a, int n, int k) {
		 int [] b = new int[n];
		 for (int i=0;i<n; i++)
		 {
			 int presElem = a[i];
			 int presPos = i;
			 if(presPos-k <0)
			 {
				 presPos = presPos+ n;
			 }
			 b[presPos-k] = presElem;
			 
		 }
		 
		 return b; 
	 }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	      
	        int[] output = new int[n];
	        output = arrayLeftRotation(a, n, k);
	        for(int i = 0; i < n; i++)
	            System.out.print(output[i] + " ");
	      
	        System.out.println();
	      
	    }
}
