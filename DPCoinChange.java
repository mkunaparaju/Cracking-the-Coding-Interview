import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DPCoinChange	{
	HashMap<Integer, Integer> monMap = new HashMap<Integer, Integer>();
    public static long makeChange(int[] coins, int money)	{
        if(money == 0)	{
        	return 0;
        }
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
