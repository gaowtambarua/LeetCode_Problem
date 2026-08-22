package Graph.Hard;

import java.util.*;
public class Problem_1579 {
	
	private void dijkstra(int n,int[] grid,int source,List<List<int[]>> adj)
	{
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		pq.offer(new int[]{source,0});
		Arrays.fill(grid,Integer.MAX_VALUE);
		grid[source]=0;
		
		while(!pq.isEmpty())
		{
			int[] current=pq.poll();
			int u=current[0];
			int c=current[1];
			for(int[] child: adj.get(u))
			{
				int v=child[0];
				int cost=child[1];
				if(c+cost<grid[v])
				{
					grid[v]=c+cost;
					pq.offer(new int[]{v,grid[v]});
				}
			}
		}
	}
	
	int findResult(int n,int[][] grid,int d)
	{
		int result=0;
		int smallest_number=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(i!=j&&grid[i][j]<=d)
				{
					count++;
				}
			}
			if(count<=smallest_number)
			{
				smallest_number=count;
				result=i;
			}
		}
		return result;
	}
	
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] grid=new int[n][n];
		int INF=(int)1e9;
		for(int i=0;i<n;i++)
		{
			Arrays.fill(grid[i],INF);
			grid[i][i]=0;
		}
		
		List<List<int[]>> adj=new ArrayList<List<int[]>>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<int[]>());
		}
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			int w=edge[2];
			adj.get(u).add(new int[]{v,w});
			adj.get(v).add(new int[]{u,w});
		}
		
		for(int i=0;i<n;i++)
		{
			dijkstra(n,grid[i],i,adj);
		}
		
		return findResult(n,grid,distanceThreshold);
	}


	public Problem_1579()
	{

	}
}
