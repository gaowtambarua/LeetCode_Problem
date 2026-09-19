package Graph.Hard;

import java.util.*;

public class Problem_2699 {
	 int constance=(int)2e9;
		public long dijkstra(int[][]edges,int n,int s,int d )
		{
			long[] dist=new long[n];
			Arrays.fill(dist,constance);


			List<List<int[]>> adj=new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				adj.add(new ArrayList<int[]>());
			}
			for(int[] edge : edges)
			{
				int u=edge[0];
				int v=edge[1];
				int wt=edge[2];
				if(wt!=-1)
				{
					adj.get(u).add(new int[]{v,wt});
					adj.get(v).add(new int[]{u,wt});
				}
			}

			PriorityQueue<long[]> pq =new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

			pq.offer(new long[]{s,0});
			dist[s]=0;
			boolean[] visited=new boolean[n];
			while(!pq.isEmpty())
			{
				long[] cur=pq.poll();
				int u=(int)cur[0];
				long parent_wt=cur[1];
				visited[u]=true;
				for(int[] child : adj.get(u))
				{
					int v=child[0];
					int wt=child[1];
					if(!visited[v]&&parent_wt+wt<dist[v])
					{
						dist[v]=parent_wt+wt;
						pq.offer(new long[]{v,dist[v]});
					}

				}
			}
			return dist[d];
		}

		public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

			long matchTarget=dijkstra(edges,n,source,destination);
			boolean targetmatch=false;
			
			if(matchTarget<target)
			{
				return new int[0][0];
			}
			
			else
			{
				for(int[] edge : edges)
				{
					if(edge[2]==-1)
					{
						edge[2]=targetmatch?constance:1;
						matchTarget=dijkstra(edges,n,source,destination);
						if(matchTarget<=target)
						{
							edge[2]+=target-matchTarget;
							targetmatch=true;
						}
					}
				}
	            if(matchTarget==target)
	            {
	                return edges;
	            }
			}
			if(!targetmatch)
			{
				return new int[0][0];
			}

			return edges;
		}
	public Problem_2699()
	{
		
		int n=5;
		int[][] edges={{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}};
		int source=0,destination=1,target=5;
		modifiedGraphEdges(n, edges, source, destination, target);
		
		
		PriorityQueue<long[]> pq =new PriorityQueue<>((a, b) ->Long.compare(a[1],b[1]));

	}
}
