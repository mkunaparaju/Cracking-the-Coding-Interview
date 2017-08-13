/**
 * 
 */
package CtCi.TextTreesGraphs;

import java.util.*;

/**
 * @author mkunaparaju
 *
 */
public class BuildOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	Project[] getBuildOrder(String [] projects, String [][] dependencies)	{
		OrderGraph graph = buildGraph(projects, dependencies);
		Project [] projectList = orderProjects(graph.getProjectList());
		return projectList;
	}
	
	OrderGraph buildGraph(String [] projects, String [][] dependencies)	{
		
		OrderGraph graph = new OrderGraph();
		
		for(String project : projects)	{
			graph.getAddProject(project);
		}
		
		for(String [] dependency : dependencies)	{
			String start	= dependency[0];
			String end 		= dependency[1];
			graph.addEdge(start, end);
		}
		
		return graph;
	}
	
	Project[] orderProjects(ArrayList<Project> projectList) {
		
		Project[] order = new Project[projectList.size()];
		int endOfList = addNonDependent(projectList, order, 0);
		int toBeProcessed = 0;
		
		while(toBeProcessed < order.length)	{
			Project current = order[toBeProcessed];
			if(current == null) return null;
			
			// This removes current as a dependency 
			ArrayList<Project> children = current.getChildren();
			for(Project child : children)	{
				child.decrement();
			}
			
			// to order, add projects with no dependencies
			endOfList = addNonDependent(children, order, endOfList);
			toBeProcessed++;
			
		}
		
		return order;
	}
	
	int addNonDependent(ArrayList<Project> projectList, Project[] ordered, int offset)	{
		for( Project proj: projectList)	{
			if(proj.getNumDependencies() == 0)	{
				ordered[offset] = proj;
				offset++;
			}
		}
		return offset;
	}

}

//	This class describes each Project
class Project	{
	
	String name;
	int dependencies = 0; // number of projects which depend on this project
	
	ArrayList<Project> children = new ArrayList<Project>();
	
	// Map of all the children to this project
	// If it already has a project, the child is already mapped
	HashMap<String, Project> childMap = new HashMap<String, Project>(); 
	
	public Project(String n)	{
		this.name = n;
	}
	
	String getName()	{
		return this.name;
	}
	
	int getNumDependencies() {
		return dependencies;
	}
	
	ArrayList<Project> getChildren() {
		return children;
	}
	
	void addChildren(Project p )	{
		if(!childMap.containsKey(p.getName()))	{
			childMap.put(p.getName(), p);
			p.increment(); 
			children.add(p);
		}
	}
	
	void increment() {
		dependencies++;
	}
	
	void decrement()	{
		dependencies--;
	}
}

// This class describes the graph

class OrderGraph	{
	
	ArrayList<Project> projectList = new ArrayList<Project>();
	Map<String, Project> projectMap = new HashMap<String, Project>();
	
	public Project getAddProject(String name)	{
		if(!projectMap.containsKey(name))	{
			Project p = new Project(name);
			projectMap.put(name,  p);
			projectList.add(p);
		}
		return projectMap.get(name);
	}
	
	public void addEdge(String start, String end)	{
		Project startProj 	= getAddProject(start);
		Project endProj		=  getAddProject(end);
		
		startProj.addChildren(endProj);
	}
	
	public ArrayList<Project> getProjectList()	{
		return projectList;
	}
}
