package Graph;
import java.util.*;
public class Problem_2492 {
	
//	class Pair{
//		int v;
//		int d;
//		public Pair(int v,int d)
//		{
//			this.v=v;
//			this.d =d;
//		}
//	}
//	int result=Integer.MAX_VALUE;
//	
//	private void dfs(Map<Integer,List<Pair>> adj,int node,boolean[] visited)
//	{
//		visited[node] = true;
//		for(Pair child : adj.get(node))
//		{
//			int v=child.v;
//			int d=child.d;
//			result=Math.min(result,d);
//			if(!visited[v])
//			{
//				dfs(adj, v, visited);
//			}
//		}
//	}
//	
//	public int minScore(int n, int[][] roads) {
//		Map<Integer,List<Pair>> adj=new TreeMap<>();
//		for(int[]road : roads)
//		{
//			int u=road[0];
//			int v=road[1];
//			int d=road[2];
//			
//			adj.computeIfAbsent(u,key->new ArrayList<Pair>()).add(new Pair(v,d));
//			adj.computeIfAbsent(v,key->new ArrayList<Pair>()).add(new Pair(u,d));
//			
//		}
//		boolean[] visited=new boolean[n+1];
//		dfs(adj,1,visited);
//		
//		return result;
//	}

/////////////////////////////////////// 2nd code	
	
	int answer=Integer.MAX_VALUE;
	List<int[]>[] graph;
	boolean[] visited;
	public int minScore(int n, int[][] roads) {
		
		graph=new ArrayList[n+1];
		
		for(int i=1;i<=n;i++)
		{
			graph[i]=new ArrayList<int[]>();
		}
		for(int[]road : roads)
		{
			int u=road[0];
			int v=road[1];
			int d=road[2];
			graph[u].add(new int[]{v, d});
            graph[v].add(new int[]{u, d});
			
		}
		visited=new boolean[n+1];
		dfs(1);
		
		return answer;
	}
	private void dfs(int node)
	{
		visited[node]=true;
		for(int[] child : graph[node])
		{
			int v=child[0];
			int d=child[1];
			answer=Math.min(d,answer);
			if(!visited[v])
			{
				dfs(v);
			}
		}
	}
	
	
	
	
	public Problem_2492()
	{
		int n=4;
		int[][] roads={
				{1,2,9},
				{2,3,6},
				{2,4,5},
				{1,4,7}
		};
		
		System.out.println(minScore(n, roads));
	}
}
