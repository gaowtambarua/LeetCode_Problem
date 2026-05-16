package Graph;

import java.util.*;

public class Problem_797 {
	List<Integer> path=new ArrayList<>();
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result=new ArrayList<>();
		
		dfs(graph,0,graph.length-1,result);
		
		return result;
	}
	
	private void dfs(int[][]graph,int node,int target,List<List<Integer>> result)
	{
		path.add(node);
		if(node==target)
		{
			result.add(new ArrayList<>(path));
			return;
		}
		for(int child : graph[node])
		{
			dfs(graph,child,target,result);
			path.remove(path.size()-1);
		}
	}
	
	public Problem_797()
	{
		int[][] graph={{1,2},{3},{3},{}};
		
		System.out.println(allPathsSourceTarget(graph));
	}
}
