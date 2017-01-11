/**
 * 
 */
package CtCi;

import java.util.*;


/**	
 * @author mkunaparaju
 *
 */

class GNode	{
	int id;
	LinkedList<GNode> adj = new LinkedList<GNode>();
	
	GNode(int id)	{
		this.id = id;
	}	
}

public class GraphImpl {

	HashMap<Integer, GNode> nodeMap = new HashMap<Integer, GNode>();
	
	
	void addEdge(int source, int dest)	{
		GNode sourceNode = nodeMap.get(source);
		GNode destNode = nodeMap.get(dest);
		
		sourceNode.adj.add(destNode);
	}
	
	boolean hasPathDFS(int source, int destination)	{
		HashSet<Integer> isVisit = new HashSet<Integer>();
		GNode srcNode = nodeMap.get(source);
		GNode destNode = nodeMap.get(destination);
		if(isVisit.contains(source))	{
			return false;
		}
		isVisit.add(source);
		
		if(source == destination)	{
			return true;
		}
		for(GNode child : srcNode.adj)	{
			if(hasPathDFS(child.id, destination))	{
				return true;
			}
		}
		
		return false;
	}
	
	boolean hasPathBFS(int source, int dest)	{
		HashSet<Integer> isVisit = new HashSet<Integer>();
		LinkedList<Integer> nextVisit = new LinkedList<Integer>();
		nextVisit.add(source);
		
		while(!nextVisit.isEmpty())	{
			int nodeid = nextVisit.remove();
			GNode node = nodeMap.get(nodeid);
			if(isVisit.contains(nodeid))	{
				continue;
			}
			isVisit.add(nodeid);
			if(nodeid == dest)	{
				return true;
			}
			for(GNode child : node.adj)	{
				nextVisit.add(child.id);
			}			
		}
		return false;
	}
	
}
