/**
 * 
 */
package CtCi;

import java.util.Scanner;

/**
 * @author mkunaparaju
 *
 */


public class ConnectedGridCells {
	 public static int getBiggestRegion(int[][] matrix) {
		 int max = 0;
		 for (int i = 0; i < matrix.length; i++)	{
			 for(int j = 0; j < matrix.length; j++)	{	
				 max = Math.max(max, getBigRegion(i, j, matrix));
			 }
		 }
	        return max;
	    }
	    
	 	private static int getBigRegion(int i, int j, int[][] matrix)	{
	 		if(i < 0 || j < 0 || i > matrix.length-1 || j > matrix.length-1)	{
	 			return 0;
	 		}
	 		
	 		int count =matrix[i][j] --;
	 		count += getBigRegion(i + 1, j, matrix);
	 		count += getBigRegion(i - 1, j, matrix);
	 		count += getBigRegion(i, j + 1, matrix);
	 		count += getBigRegion(i, j - 1, matrix);
	 		count += getBigRegion(i + 1, j - 1, matrix);
	 		count += getBigRegion(i - 1, j - 1, matrix);
	 		count += getBigRegion(i - 1, j + 1, matrix);
	 		count += getBigRegion(i - 1, j - 1, matrix);
	 		return count;
	 	}
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int grid[][] = new int[n][m];
	        for(int grid_i=0; grid_i < n; grid_i++){
	            for(int grid_j=0; grid_j < m; grid_j++){
	                grid[grid_i][grid_j] = in.nextInt();
	            }
	        }
	        System.out.println(getBiggestRegion(grid));
	    }
}
