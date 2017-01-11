package CtCi;

import java.io.*;
import java.util.*;
import java.math.*;

public class NewDijkhstra 
{
    // Adjacency list representation of graph
    private static class Graph
    {
        private ArrayList<GraphNode> nodes;
        
        public Graph(int numNodes)
        {
            nodes = new ArrayList<GraphNode>(numNodes);
            for (int i=0; i<numNodes; i++) {
                nodes.add(new GraphNode(i));
            }
        }
        
        public GraphNode get(int index)
        {
            return nodes.get(index);    
        }
        
        public int size()
        {
            return nodes.size();    
        }
        
        public void addEdge(int x, int y, int weight)
        {
            GraphNode X = get(x);
            GraphNode Y = get(y);
            
            X.addEdge(y, weight);
            Y.addEdge(x, weight);
        }
        
        public void printGraph()
        {
            System.out.println(nodes.size());
            for (GraphNode node : nodes) {
                node.printNeighbors();
            }
        }
    }
    
    private static class GraphNode implements Comparable<GraphNode>
    {
        private int index;
        private HashMap<Integer,GraphEdge> neighbors;
        public int shortestDistance;
        
        public GraphNode(int index)
        {
            this.index = index;
            neighbors = new HashMap<Integer,GraphEdge>();
            shortestDistance = Integer.MAX_VALUE;
        }
        
        public void addEdge(int neighbor, int weight)
        {
            // Check if edge already exists, update weight
            if (neighbors.containsKey(neighbor)) {
                GraphEdge edge = neighbors.get(neighbor);
                if (weight < edge.weight) {
                    edge.weight = weight;
                }
            }
            else {
                neighbors.put(neighbor, new GraphEdge(neighbor, weight));
            }
        }
        
        public GraphEdge getEdge(int index)
        {
            return neighbors.get(index);
        }
        
        public int getIndex()
        {
            return index;
        }
        
        public Collection<GraphEdge> getNeighbors()
        {
            return neighbors.values();
        }
        
        public int compareTo(GraphNode other)
        {
            if (shortestDistance < other.shortestDistance) {
                return -1;
            }
            else if (shortestDistance == other.shortestDistance) {
                return 0;
            }
            else {
                return 1;
            }
        }
        
        public void printNeighbors()
        {
            for (GraphEdge edge : neighbors.values()) {
                System.out.println((index+1) + " " + (edge.neighbor+1) + " " + edge.weight);
            }
        }
    }
    
    private static class GraphEdge
    {
        public int neighbor;
        public int weight;
        
        public GraphEdge(int neighbor, int weight)
        {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        for (int j=0; j<numTests; j++) {
            int numNodes = in.nextInt();
            int numEdges = in.nextInt();
            
            // Build graph
            Graph graph = new Graph(numNodes);
            for (int i=0; i<numEdges; i++) {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                int weight = in.nextInt();
                
                graph.addEdge(x, y, weight);
            }
            graph.printGraph();
            
            int start = in.nextInt()-1;
            int[] result = dijkstraShortestDistance(graph, start);
            printArr(result);
        }
    }
    
    private static int[] dijkstraShortestDistance(Graph graph, int start)
    {
        boolean[] visited = new boolean[graph.size()];
        for (int i=0; i<visited.length; i++) {
            visited[i] = false;
        }
        
        // Heap of nodes to explore based on shortest distance
        PriorityQueue<GraphNode> q = new PriorityQueue<GraphNode>();
        
        // Initialize start node
        graph.get(start).shortestDistance = 0;
        q.add(graph.get(start));
        
        while (!q.isEmpty()) {
            // Pop and visit node
            GraphNode node = q.poll();
            visited[node.getIndex()] = true;
            
            // For every neighbor         
            for (GraphEdge edge : node.getNeighbors()) {
                GraphNode neighbor = graph.get(edge.neighbor);
                
                // If not visited, recalculate shortest distance to neighbor
                if (!visited[neighbor.getIndex()]) {
                    int distance = node.shortestDistance + edge.weight;
                    neighbor.shortestDistance = Math.min(neighbor.shortestDistance, distance);
                    // Add to queue
                    if (!q.contains(neighbor)) {
                        q.add(neighbor);
                    }
                }
            }
        }
        
        // Put shortest distances into array, -1 if not reachable
        int[] shortestDistance = new int[graph.size()];
        for (int i=0; i<shortestDistance.length; i++) {
            if (graph.get(i).shortestDistance != Integer.MAX_VALUE) {
                shortestDistance[i] = graph.get(i).shortestDistance;
            }
            else {
                shortestDistance[i] = -1;
            }
        }
        return shortestDistance;
    }
    
    private static void printArr(int[] arr)
    {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            System.out.print(arr[i] + " ");
        }    
        System.out.println();
    }
}