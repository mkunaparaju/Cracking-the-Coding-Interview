package CtCi;

import java.io.*;
import java.util.*;
import java.math.*;


class vertex	{
	int id;
	int pathLen;
	int pred;
	boolean isPerm;
	
	vertex(int id)	{
		this.id = id;
		this.pathLen = 99999;
		this.pred = -1;
		this.isPerm = false;
	}
}

class DGraph	{
	
	int size;
	List<vertex> vertices = new ArrayList<vertex>();
	DGraph(int size)	{
		this.size = size;
	}
	
	void addEdge(int src, int dest, int wr)	{
		
	}
	
//	int[] shortestDistance(int startId)	{
//		
//	}
}
public class Dijkshtra	{
		public static void main(String [] args)	{
		Scanner scanner = new Scanner(System.in);
	      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            DGraph graph = new DGraph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges	
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int wt = scanner.nextInt();
                // add each edge to the graph
                graph.addEdge(u, v, wt);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
           // int[] distances = graph.shortestReach(startId);
 
//            for (int i = 0; i < distances.length; i++) {
//                if (i != startId) {
//                    System.out.print(distances[i]);
//                    System.out.print(" ");
//                }
//            }
            System.out.println();            
        }
        
        scanner.close();
	}
}