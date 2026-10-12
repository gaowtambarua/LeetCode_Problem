package Graph.Hard;
import java.util.*;
public class Problem_2493 {
	
	
	boolean checkBartite(List<List<Integer>>adj,int[] colour,int node,int currColour)
	{
		
		colour[node]=currColour;
		
		for(int child : adj.get(node))
		{
			if(colour[node]==colour[child])
			{
				return false;
			}
			
			if(colour[child]==-1)
			{
				int updateColour=1-currColour;
				if(!checkBartite(adj,colour,child,updateColour))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	int dfs(List<List<Integer>>adj,int node,int n)
	{
		
		int level=1;
		
		boolean[] visited=new boolean[n];
		Queue<Integer> qu=new LinkedList<Integer>();
		qu.offer(node);
		visited[node]=true;
		while(!qu.isEmpty()){
			int size=qu.size();
			while(size-->0)
			{
				int cur=qu.poll();
				for(int child: adj.get(cur))
				{
					if(!visited[child])
					{
						visited[child]=true;
						qu.offer(child);
					}
				}
			}
			
			level++;
		}
		return level-1;
	}
	
	
	private int getMaxFromEachComp(List<List<Integer>>adj,int[] level,int node,boolean[] visited)
	{
		int max=level[node];
		visited[node]=true;
		
		for(int child : adj.get(node))
		{
			if(!visited[child])
			{
				max=Math.max(max,getMaxFromEachComp(adj, level,child, visited));
			}
		}
		
		return max;
	}
	
	
	public int magnificentSets(int n, int[][] edges) {
		
		List<List<Integer>> adj=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int[] edge : edges)
		{
			int u=edge[0]-1;
			int v=edge[1]-1;
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		
		int[] colour=new int[n];
		for(int i=0;i<n;i++);
		{
			Arrays.fill(colour, -1);
		}
		
		
//		 Bipartite check
		for(int i=0;i<n;i++)
		{
			if(colour[i]==-1)
			{
				if(!checkBartite(adj,colour,i,1))
				{
					return -1;
				}
			}
		}
		
//		level
		int[] level=new int[n];
		
		for(int i=0;i<n;i++)
		{
			level[i]=dfs(adj,i,n);
		}
		
		int maxGroup=0;
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				maxGroup+=getMaxFromEachComp(adj,level,i,visited);
			}
			
		}
		
		return maxGroup;
		
	}
}
