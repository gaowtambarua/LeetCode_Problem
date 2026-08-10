package Graph.Hard;


import java.util.*;



public class Problem_2642 {

	class Graph {
		int[][] dist;
		int n;
		int INF=(int)1e9;
	    public Graph(int n, int[][] edges) {
	        
	        dist=new int[n][n];
	        this.n=n;
	        for(int i=0;i<n;i++)
	        {
	        	Arrays.fill(dist[i], INF);
	        	dist[i][i]=0;
	        }
	        
	        // build graph
	        for(int[] edge : edges)
	        {
	        	int u=edge[0];
	        	int v=edge[1];
	        	int cost=edge[2];
	        	dist[u][v]=cost;
	        }
	        
	        // Step 3: Floyd–Warshall//v^3 /// exmple: 3-0-1,exmple : 3-0-2, intermediate=0,srouce=3,destination=1,2
	        for(int k=0;k<n;k++)// intermediate
	        {
	        	for(int i=0;i<n;i++)// source
	        	{
	        		for(int j=0;j<n;j++)// destination
	        		{
	        			dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
	        		}
	        	}
	        }
	       
	    }
	    
	    public void addEdge(int[] edge) {
	    	int u=edge[0];
        	int v=edge[1];
        	int cost=edge[2];
	        	for(int i=0;i<n;i++)// source
	        	{
	        		for(int j=0;j<n;j++)// destination
	        		{
	        			dist[i][j]=Math.min(dist[i][j],dist[i][u]+cost+dist[v][j]);
	        		}
	        	}
	    }
	    
	    public int shortestPath(int node1, int node2) {
	        return dist[node1][node2]==INF?-1:dist[node1][node2];
	    }
	}
	
	
	
	
//	/////////// Using DijKstra
//	class Graph {
//		
//		class Pair{
//			int u;
//			int d;
//			public Pair(int u,int d)
//			{
//				this.u=u;
//				this.d=d;
//			}
//		}
//		
//		List<List<Pair>> adj=new ArrayList<List<Pair>>();
//		int[] dist;
//	    public Graph(int n, int[][] edges) {
//	        dist=new int[n];
//	        for(int i=0;i<n;i++)
//	        {
//	        	adj.add(new ArrayList<Pair>());
//	        }
//	        for(int[] edge: edges)
//	        {
//	        	int u=edge[0];
//	        	int v=edge[1];
//	        	int c=edge[2];
//	        	adj.get(u).add(new Pair(v,c));
//	        }
//	    }
//	    
//	    public void addEdge(int[] edge) {
//	    	int u=edge[0];
//        	int v=edge[1];
//        	int c=edge[2];
//        	adj.get(u).add(new Pair(v,c));
//	    }
//	    
//	    public int shortestPath(int node1, int node2) {
//	    	Arrays.fill(dist,Integer.MAX_VALUE);
//	    	PriorityQueue<Pair>pq=new PriorityQueue<>(
//	    			(a,b)->a.d-b.d
//	    			);
//	    	dist[node1]=0;
//			pq.add(new Pair(node1,0));
//			
//			while(!pq.isEmpty())
//			{
//				Pair cur=pq.poll();
//				int u=cur.u;
//				for(Pair edge : adj.get(u))
//				{
//					int v=edge.u;
//					int d=edge.d;
//					
//					if(dist[u]+d<dist[v])
//					{
//						dist[v]=dist[u]+d;
//						pq.add(new Pair(v,dist[v]));
//					}
//				}
//			}
//	    	
//	        return dist[node2]==Integer.MAX_VALUE?-1:dist[node2];
//	    }
//	}


	public Problem_2642()
	{

	}
}
