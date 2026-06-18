package Problem;

import java.util.Arrays;

public class Problem_2360 {
	int result=-1;
	private void dfsDirectedCycle(int[]edges,boolean[] visited,boolean[] path,int node,int[] count)
	{
		visited[node]=true;
		path[node]=true;
		int v=edges[node];
		if(v==-1&&!visited[v])
		{
			count[v]=count[node]+1;
			dfsDirectedCycle(edges, visited, path, v,count);
		}
		else if(v==-1&&path[v])
		{
			result=Integer.max(result,count[node]-count[v]+1);
		}
		path[node]=false;
	}
	public int longestCycle(int[] edges) {
		int n=edges.length;
		boolean[] visited=new boolean[n];
		boolean[] path=new boolean[n];
		int[] count=new int[n];
		Arrays.fill(count, 1);
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				dfsDirectedCycle(edges,visited,path,i,count);
			}
			
		}
		return result;
	}


	public Problem_2360()
	{

	}
}
