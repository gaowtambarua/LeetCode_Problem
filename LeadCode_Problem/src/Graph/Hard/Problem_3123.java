package Graph.Hard;
import java.util.*;
public class Problem_3123 {
	
	
	int[] dijkstra(List<List<int[]>> adj ,int src,int n)
	{
		int[] dist=new int[n];
		Arrays.fill(dist,(int)1e9);
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(
				(a,b)->a[1]-b[1]
				);
		
		pq.offer(new int[]{src,0});
		dist[src]=0;
		
		while(!pq.isEmpty())
		{
			int[] cur=pq.poll();
			int u=cur[0];
			
			for(int[] child : adj.get(u))
			{
				int v=child[0];
				int vw=child[1];
				if(dist[u]+vw<dist[v])
				{
					dist[v]=dist[u]+vw;
					pq.offer(new int[]{v,dist[v]});
					
				}
				
			}
		}
		
		return dist;
	}
	
	

	public boolean[] findAnswer(int n, int[][] edges) {
		
		int m=edges.length;
	
		List<List<int[]>> adj =new ArrayList<>();
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
		
		int[] fromSrc=dijkstra(adj,0,n) ;
		int[] fromDest=dijkstra(adj,n-1,n);
		
		
		boolean[] result=new boolean[m];
		
		for(int i=0;i<m;i++)
		{
			int u=edges[i][0];
			int v=edges[i][1];
			int w=edges[i][2];
			
			int distfromSrc=fromSrc[u];
			int distfromDest=fromDest[v];
			if(distfromSrc+w+distfromDest==fromSrc[n-1])
			{
				result[i]=true;
			}
			
			distfromSrc=fromSrc[v];
			distfromDest=fromDest[u];
			if(distfromSrc+w+distfromDest==fromSrc[n-1])
			{
				result[i]=true;
			}
		}
		
		return result;
	}


	public Problem_3123()
	{
		int n = 6, edges[][] ={{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};
		findAnswer(n, edges);
	}
}
