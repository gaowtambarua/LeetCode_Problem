package Graph;

import java.util.*;

public class Problem_787 {


	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		List<int[]>[] graph=new ArrayList[n];
		
		for(int i=0;i<n;i++)
		{
			graph[i]=new ArrayList<int[]>();
		}
		
		for(int[] flight : flights)
		{
			int u=flight[0];
			int v=flight[1];
			int d=flight[2];
			
			graph[u].add(new int[]{v,d});
		}
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		pq.offer(new int[]{src,0});
		dist[src]=0;
		int i=0;
		while(!pq.isEmpty()&&i!=k)
		{
			int[] cur=pq.poll();
			int u=cur[0];
			
			for(int[] child : graph[u])
			{
				int v=child[0];
				int d=child[1];
				if(dist[u]+d<dist[v])
				{
					dist[v]=dist[u]+d;
					pq.offer(new int[]{v,dist[v]});
				}
			}
			k++;
		}
		
		return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
	}


	
}
