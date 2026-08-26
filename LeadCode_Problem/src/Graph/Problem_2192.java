package Graph;
import java.util.*;
public class Problem_2192 {

	void dfs(int node ,boolean[] visited,List<List<Integer>> adj)
	{
		visited[node]=true;
		for(int child : adj.get(node))
		{
			if(!visited[child])
			{
				dfs(child,visited,adj);
			}
		}
	}
	
	public List<List<Integer>> getAncestors(int n, int[][] edges) {
		List<List<Integer>> adj=new ArrayList<>();
		List<List<Integer>> result=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<Integer>());
			result.add(new ArrayList<Integer>());
		}
		
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			adj.get(v).add(u);
		}
		
		
		for(int i=0;i<n;i++)
		{
			boolean[] visited=new boolean[n];
			if(!visited[i])
			{
				dfs(i,visited,adj);
			}
			
			for(int j=0;j<n;j++)
			{
				if(i==j)
				{
					continue;
				}
				if(visited[j])
				{
					result.get(i).add(j);
				}
			}
		}
		
		return result;
	}


	public Problem_2192()
	{

	}
}
