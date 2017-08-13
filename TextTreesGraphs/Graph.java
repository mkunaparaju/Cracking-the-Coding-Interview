/**
 * 
 */
package CtCi.TextTreesGraphs;

import java.util.*;


/**	
 * @author mkunaparaju
 *	An undirected graph class
 *	
 *
 */

public class Graph {
	
	int v;
	List<LinkedList<Integer>> adjList;
	
	public Graph(int vertices) 	{
		this.v = vertices;
		adjList = new LinkedList<LinkedList<Integer>>() ;
		for(int i = 0; i < v; i++) {
			adjList.add(new LinkedList<Integer>());
		}
	}
	
	void addEdge(int u, int v)	{
		adjList.get(u).add(v);
	}
	
	boolean hasPathDFS(Graph g, int start, int dest)	{
		HashSet<Integer> visited  = new HashSet<Integer>();
		return dfsUtil(g, start, dest, visited);
	}
	
	boolean dfsUtil(Graph g, int start, int dest, HashSet<Integer> visited) 	{
		//because it has been visited already
		if(visited.contains(start) ) {
			return false;
		}
		//we are at the destination
		if(start == dest ) {
			return true;
		}
		visited.add(start);
		for(Integer child : adjList.get(start))		{
			if( dfsUtil(g, child, dest, visited))	{
				return true;
			}
		}
		return false; 
	}
	
	boolean hasPathBFS(Graph g, int start, int dest)	{
		
		//Nodes yet to visit
		Queue<Integer> toBeVisited = new LinkedList<Integer>();
		
		//Visited Nodes
		HashSet<Integer> visited  = new HashSet<Integer>();
		
		//Add the starting node
		toBeVisited.add(start);		
		
		//While no more child nodes
		while(!toBeVisited.isEmpty())	{
			int current = toBeVisited.poll();
			if(current == dest) return true;
			if(visited.contains(current)) return false;
			visited.add(current);
			for(Integer child : adjList.get(current))	{
				toBeVisited.add(child);
			}
		}
		return false;
	}
	
	public static void main (String [] args) 	{
		// Create a graph 

		Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        
        boolean bfsPath = g.hasPathBFS(g, 3, 1);
        boolean dfsPath = g.hasPathDFS(g, 3, 1);
        
        System.out.println(bfsPath);
        System.out.println(dfsPath);
	}
	
}
