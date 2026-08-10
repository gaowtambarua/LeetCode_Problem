package Graph.Algoritham;

import java.util.Arrays;

public class Floyd_Warshall_FInd_Shortest_Path {
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
}
