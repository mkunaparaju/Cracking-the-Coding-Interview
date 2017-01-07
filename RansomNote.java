/**
 * 
 */
package CtCi;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author mkunaparaju
 *
 *https://www.hackerrank.com/challenges/ctci-ransom-note
 */
public class RansomNote {

	Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String magazine;
    String note;
    public RansomNote(String magazine, String note) {
        this.magazine = magazine;
        this.note = note;
    }
    
    public boolean solve() {
    	boolean ransom = false;
    	String [] magArr = magazine.split(" ");
    	String [] noteArr = note.split(" ");
    	Hashtable<String, Integer> magtable  = new Hashtable<String, Integer>();
    	int wordCount = 0;
    	for(int i =0; i< magArr.length; i++){
    		magtable.put(magArr[i], i);
    	}
    	
    	for(int i = 0; i< noteArr.length; i++){
    		//System.out.println(noteArr[i]);
    		if(magtable.containsKey(noteArr[i])){
    			//System.out.println(magtable.get(noteArr[i]) + "---------------");
    			if(magtable.get(noteArr[i]) >= wordCount){
    				 ransom = true;
    				 wordCount = magtable.get(noteArr[i]);
    			}
    			else{
    				ransom = false;
    			}
    		}
    		else{
    			ransom = false;
    		}
    	}
    		
    	
    	return ransom;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(	System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
