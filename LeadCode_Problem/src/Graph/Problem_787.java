package Graph;

import java.util.*;

public class Problem_787 {


	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		
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
		
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		Queue<int[]> pq=new LinkedList<int[]>();
		dist[src]=0;
		pq.add(new int[]{src,0});
		int step=0;
		while(!pq.isEmpty()&& step<=k)
		{
			int pqSize=pq.size();
			for(int i=0;i<pqSize;i++)
			{
				int[] present=pq.poll();
				int u=present[0];
				
				for(int[] child : graph[u])
				{
					int v=child[0];
					int d=child[1];
					if(present[1]+d<dist[v])
					{
						dist[v]=present[1]+d;
						pq.add(new int[]{v,dist[v]});
					}
				}
			}
			
			
			step++;
		}
		
		return dist[dst]==Integer.MAX_VALUE? -1 : dist[dst];
	}
	
	
	public Problem_787()
	{
		int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int src=0,dst=3,k=1;
		
		System.out.println(findCheapestPrice(4,flights,src,dst,k));
	}


	
}
