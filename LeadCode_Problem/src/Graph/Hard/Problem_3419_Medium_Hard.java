package Graph.Hard;
import java.util.*;
public class Problem_3419_Medium_Hard {

	
	boolean checkAllNoce(List<List<int[]>>adj,int n,int mid)
	{
		
		boolean[] visited=new boolean[n];
		Queue<int[]> qu=new LinkedList<int[]>();
		qu.offer(new int[]{0,0});
		visited[0]=true;
		while(!qu.isEmpty())
		{
			int[] current=qu.poll();
			int u=current[0];
			
			for(int[] child : adj.get(u)){
				int v=child[0];
				int w=child[1];
				if(w<=mid && !visited[v])
				{
					visited[v]=true;
					qu.offer(new int[]{v,w});
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			if(!visited[i]){
				return false;
			}
		}
		
		return true;
	}

	public int minMaxWeight(int n, int[][] edges, int threshold) {
		
		
		List<List<int[]>> adj=new ArrayList<List<int[]>>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<int[]>());
		}
		
		int mx=0;
		for(int[] edge: edges)
		{
			int u=edge[0];
			int v=edge[1];
			int w=edge[2];
			
			adj.get(v).add(new int[]{u,w});
			mx=Math.max(mx,w);
		}
		
		int result=-1;
//		apply binaray search
		int l=0;
		int r=mx;
		while(l<=r)
		{
			int mid=l+(r-l)/2;
			if(checkAllNoce(adj,n,mid))
			{
				result=mid;
				r=mid-1;
			}
			else
			{
				l=mid+1;
			}
		}
		
//		{2,0,1}
//		{1,0,2}
//		{2,1,1}
//		{3,2,2}
//		{3,1,1}
//		{4,1,1}
//		{3,4,5}
		
		
		return result==-1?-1: result;
	}
}
