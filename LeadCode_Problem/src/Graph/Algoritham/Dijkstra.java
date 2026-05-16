package Graph.Algoritham;
import java.util.*;
public class Dijkstra {

	class Pair{
		int u;
		int d;
		public Pair(int u,int d)
		{
			this.u=u;
			this.d=d;
		}
	}


	public Dijkstra()
	{
		/// 0,1,2
		List<List<Pair>> adj=new ArrayList<>();
		int n=3;
		int src=0;

		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		
		
		//        	4	
		//		0-------1
		//		|      /|
		//	    |     / |
		//	    |    /  |
		//	  1 | 2 /   | 1
		//	    |  /    |
		//		| /     |
		//      |/      |
		//		2-------3
		//	        5

		//		0---->1 dist=4
		//		0---->2 dist=1
		//		2---->1 dist=2
		//		0---->1 dist=4
		//		1---->3 dist=1
		//		2---->3 dist=5
		
		
		/////////////////////////////////////////////// Negative Value er jonno aiti kaz korbe na

		//    	   -2	
		//		2-------1
		//		|      /
		//	    |     / 
		//	    |    /  
		//	 -2 |   / 1   
		//	    |  /    
		//		| /
		//      |/
		//		0

		//		2---->1 dist = -2
		//		1---->0 dist = 1
		//		0---->2 dist = -2 
		
		adj.get(2).add(new Pair(1,-2));
		adj.get(1).add(new Pair(0,1));
		adj.get(0).add(new Pair(2,-2));
		
		int[] dist=dijkstra(n,adj,src);
		
		System.out.println(" "+dist[0]);
	}
	
	int[] dijkstra(int n,List<List<Pair>> adj,int src)
	{
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		PriorityQueue<Pair> pq=new PriorityQueue<>(
				
				(a,b)->a.d-b.d
				
				);
		dist[0]=0;
		pq.add(new Pair(src,0));
		
		while(!pq.isEmpty())
		{
			Pair cur=pq.poll();
			int u=cur.u;
			for(Pair edge : adj.get(u))
			{
				int v=edge.u;
				int d=edge.d;
				
				if(dist[u]+d<dist[v])
				{
					dist[v]=dist[u]+d;
					pq.add(new Pair(v,dist[v]));
				}
			}
			System.out.println(Arrays.toString(dist));
		}
		
		return dist;
	}
}
