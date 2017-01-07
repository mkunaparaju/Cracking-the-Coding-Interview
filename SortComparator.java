/**
 * 
 */
package CtCi;

import java.util.*;

/**
 * @author mkunaparaju
 *	
 */
 class Checker implements Comparator<Player>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	 //comparator for decreasing order
	@Override
	public int compare(Player p1, Player p2) {
		if(p1.score < p2.score)	{
			return 1;
			//should return -1 in ascehnding order. this is for descending order
		}
		else if(p1.score > p2.score)	{
			return -1;
		}
		else if(p1.score == p2.score)	{
			return p1.name.compareToIgnoreCase(p2.name);
		}
		return 0;
	}

}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class SortComparator extends Checker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        SortComparator checker = new SortComparator();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
