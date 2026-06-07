package Graph;
import java.util.*;
import java.util.Arrays;

public class Problem_2359 {

	//	private void dfs(int[] edges,int[] dist,int u,boolean[] visited)
	//	{
	//		visited[u]=true;
	//		int v=edges[u];
	//		if(v!=-1&&!visited[v])
	//		{
	//			dist[v]=dist[u]+1;
	//			dfs(edges,dist,v,visited);
	//		}
	//	}
	//	public int closestMeetingNode(int[] edges, int node1, int node2) {
	//		int n=edges.length;
	//		
	//		int[] dist1=new int[n];
	//		int[] dist2=new int[n];
	//		boolean[] visited1=new boolean[n];
	//		boolean[] visited2=new boolean[n];
	//		
	//		Arrays.fill(dist1,Integer.MAX_VALUE);
	//		Arrays.fill(dist2,Integer.MAX_VALUE);
	//		dist1[node1]=0;
	//		dist2[node2]=0;
	//		dfs(edges,dist1,node1,visited1);
	//		dfs(edges,dist2,node2,visited2);
	//		
	//		int result=-1;
	//		int minimized=Integer.MAX_VALUE;
	//		for(int i=0;i<n;i++)
	//		{
	//			int maxDist=Math.max(dist1[i],dist2[i]);
	//			if(maxDist<minimized)
	//			{
	//				minimized=maxDist;
	//				result=i;
	//			}
	//		}
	//		
	//		return result;
	//	}
	


	public Problem_2359()
	{
	}
}
