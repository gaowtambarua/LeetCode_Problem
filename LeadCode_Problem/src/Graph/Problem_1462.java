package Graph;
import java.util.*;
public class Problem_1462 {
	boolean[] visited;
	private boolean dfs(List<List<Integer>> adj,int u,int v)
	{
		visited[u]=true;
		if(u==v)
		{
			return true;
		}
		for(int child : adj.get(u))
		{
			if(!visited[child])
			{
				if(dfs(adj,child,v))
				{
					return true;
				}
			}
		}
		
		return false;
	}


	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		
		List<Boolean> result=new ArrayList<Boolean>();
		
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<numCourses;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int[]prerequisite : prerequisites)
		{
			int u=prerequisite[0];
			int v=prerequisite[1];
			
			adj.get(u).add(v);
		}
		for(int[] querie : queries)
		{
			int u=querie[0];
			int v=querie[1];
			visited=new boolean[numCourses];
			result.add(dfs(adj,u,v));
		}
		
		return result;
		
	}


}
