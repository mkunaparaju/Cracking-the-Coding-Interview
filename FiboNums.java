/**
 * 
 */
package CtCi;

import java.util.Scanner;

/**
 * @author mkunaparaju
 *
 */
public class FiboNums {
	
	public static int fibonacci(int n) {
        int [] fibSum = new int[n+1];
        if(n == 0){
        	return 0;
        }
        if( n == 1){
        	return 1;
        }
        
       	fibSum[n] = fibonacci(n-1) + fibonacci(n-2);
           
        return fibSum[n];
		
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }

}
