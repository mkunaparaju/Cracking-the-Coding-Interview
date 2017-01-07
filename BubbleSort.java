/**
 * 
 */
package CtCi;

import java.util.Scanner;

/**
 * @author mkunaparaju
 *
 */
public class BubbleSort {
	static int totalSwap =0; 

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
    int a[] = new int[n];
    for(int a_i=0; a_i < n; a_i++){
        a[a_i] = in.nextInt();
    }
    boolean isSort =  false;
    while(!isSort)
    {
        isSort = sort(a);
    }
    
    System.out.println("Array is sorted in " + totalSwap + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[n-1]);
    
}

static boolean sort(int [] arr)
{
    
    int numSwap =0; 
    for(int i =0; i<arr.length -1; i++)
    {
       if(arr[i] > arr[i+1])
       {
           arr = swap(arr, i, i+1);
            numSwap++;
       }
    }
    
    if(numSwap !=0)
    {
    	totalSwap += numSwap;
    	return false;
    }
    
    return true;
	}

static int[] swap(int[] arr, int a, int b)
{
	int temp = arr[a];
	 arr[a] = arr[b];
	 arr[b] = temp;
	 
	 return arr;
		
}
}