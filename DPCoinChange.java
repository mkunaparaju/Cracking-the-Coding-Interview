package CtCi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DPCoinChange	{
	static HashMap<Integer, Long> monMap = new HashMap<Integer, Long>();
    public static long makeChange(int[] coins, int money)	{
    	//for all the elements where u cant make a combination with
    	if(money < coins[0])	{
    		for(int i = 0; i < coins[0]; i++)	{
    			if(!monMap.containsKey(i))	{
    				monMap.put(i, (long) 0);
    			}
    		}
        }
    	if(money == coins[0])	{
    		if(!monMap.containsKey(coins[0]))	{
    			monMap.put(coins[0], (long) 1);
    		}
    	}
    	
        return 0;
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
