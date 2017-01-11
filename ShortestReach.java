package CtCi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestReach {
	
    public static class Graph {
    	
        int size;
        List<List<Integer>> adjList; 
        int weight;
        public Graph(int size) {
            this.size = size;
            adjList = new ArrayList<>();
            weight = 6;
            while(size-- > 0)//Initialize the adjancency list.
                adjList.add(new ArrayList<Integer>());
        }

        public void addEdge(int first, int second) {
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
        	List<Integer> startList = adjList.get(startId);
        	HashSet<Integer> isVisit = new HashSet<Integer>();
        	LinkedList<Integer> nextVisit = new LinkedList<Integer>();
        	int[] dist = new int[size];
        	Arrays.fill(dist, -1);
        	isVisit.add(startId);
        	nextVisit.add(startId);
        	dist[startId] = 0;
        	while(!nextVisit.isEmpty())	{
        		int node = nextVisit.remove();
        		for(int elem : adjList.get(node))	{
          			if(isVisit.contains(elem))	{
        				continue;
        			}
        			isVisit.add(elem);
        			dist[elem] = dist[node] + weight;
        			nextVisit.add(elem);
        		}
        	}
        	return dist;   
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges	
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}