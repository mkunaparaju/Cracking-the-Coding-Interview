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
	
	Project[] getBuildOrderString [] projects, String [][] dependencies)	{
		
	}
	
	Graph buildGraph(String [] projects, String [][] dependencies)	{
		
	}
	
	Project[] orderProjects(List<Project> projectList) {
		
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
			dependencies++; 
			children.add(p);
			
		}
	}
}

// This class describes the graph

class OrderGraph	{
	
	List<Project> projectList = new ArrayList<Project>();
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
	
	public List<Project> getProjectList()	{
		return projectList;
	}
}
