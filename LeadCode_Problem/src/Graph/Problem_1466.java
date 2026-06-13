package Graph;
import java.util.*;
public class Problem_1466 {
	int count=0;
	private void dfs(List<int[]>[] adj,int node,int parent)
	{
		for(int[] child : adj[node])
		{
			int v=child[0];
			int d=child[1];
			
			if(parent!=v)
			{
				if(d==1)
				{
					count++;
				}
				dfs(adj, v, node);
			}
		}
	}
	public int minReorder(int n, int[][] connections) {
		
		List<int[]>[] adj=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			adj[i]=new ArrayList<int[]>();
		}
		for(int[] connection : connections)
		{
			int u=connection[0];
			int v=connection[1];
			adj[u].add(new int[]{v,1});
			adj[v].add(new int[]{u,0});
		}
		dfs(adj,0,-1);
		
		return count;
	}
	
	public Problem_1466()
	{
		int n=6,c[][]={
				{0,1},
				{1,3},{2,3},
				{4,0},
				{4,5}
				};
		System.out.println(minReorder(n, c));
	}
}
