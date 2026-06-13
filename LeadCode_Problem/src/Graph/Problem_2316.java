package Graph;
import java.util.*;
public class Problem_2316 {
	
	long dfs(List<List<Integer>> adj,boolean[] visited,long size,int node)
	{
		visited[node]=true;
		for(int child : adj.get(node))
		{
			if(!visited[child])
			{
				size=dfs(adj, visited, size, child);
			}
		}
		//size=size+1;
		return ++size;
	}
	
	public long countPairs(int n, int[][] edges) {
		long result=0;
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		boolean[] visited=new boolean[n];
		int currentSIze=n;
		for(int i=0;i<n;i++)
		{
			long size=0;
			if(!visited[i])
			{
				size=dfs(adj,visited,size,i);
				result=result+(currentSIze-size)*size;
				currentSIze-=size;
			}
		}
		return result;
	}
	
}
