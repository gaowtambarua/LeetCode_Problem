package Graph;
import java.util.*;
public class Problem_1443 {
	
	private int dfs(List<List<Integer>> adj,int current,List<Boolean> hasApple)
	{
		
		for(int child : adj.get(current))
		{
			dfs(adj,child,hasApple);
		}
		
		return 0;
	}

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		
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
		
		return dfs(adj,0,hasApple);
	}


	public Problem_1443()
	{
		System.out.println("Hellow");
	}
}
