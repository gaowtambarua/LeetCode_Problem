package Graph.Hard;
import java.util.*;
public class Problem_2045 {


	public int secondMinimum(int n, int[][] edges, int time, int change) {
		List<List<int[]>> adj=new ArrayList<List<int[]>>();
		int[] frstDist=new int[n+1];
		int[] scndDist=new int[n+1];
		Arrays.fill(frstDist,Integer.MAX_VALUE);
		Arrays.fill(scndDist,Integer.MAX_VALUE);
		
		for(int i=0;i<=n;i++)
		{
			adj.add(new ArrayList<int[]>());
		}
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			adj.get(u).add(new int[]{v,time});
			adj.get(v).add(new int[]{u,time});
		}
		pq.offer(new int[]{1,0});
		frstDist[1]=0;
		while(!pq.isEmpty())
		{
			int[] currentNode=pq.poll();
			int u=currentNode[0];
			int path=currentNode[1];
			if(scndDist[n]!=Integer.MAX_VALUE)
			{
				return scndDist[n];
			}
			int div=path/change;
			if(div%2==1)
			{
				path=(div+1)*change;
			}
			for(int[] child : adj.get(u))
			{
				int cV=child[0];
				int cCost=child[1];
				if(path+cCost<frstDist[cV])
				{
					scndDist[cV]=frstDist[cV];
					frstDist[cV]=path+cCost;
					pq.offer(new int[]{cV,frstDist[cV]});
				}
				else if(frstDist[cV]!=path+cCost && path+cCost<scndDist[cV])
				{
					scndDist[cV]=Math.min(scndDist[cV],path+cCost);
                    pq.offer(new int[]{cV,scndDist[cV]});
				}
			}
		}
		
		
		return scndDist[n];
		
	}
	public Problem_2045()
	{
//		pq.offer(new int[]{4,3});
//		pq.offer(new int[]{3,3});
//		pq.offer(new int[]{4,2});
//		while(!pq.isEmpty())
//		{
//			System.out.println(Arrays.toString(pq.poll()));
//		}
	}

}
