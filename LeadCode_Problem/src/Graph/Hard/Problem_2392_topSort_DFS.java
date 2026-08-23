package Graph.Hard;
import java.util.*;
public class Problem_2392_topSort_DFS {
	
	boolean dfs(int u,boolean[] visited,List<List<Integer>> adj,Stack<Integer> st,boolean[] path)
	{
		visited[u]=true;
		path[u]=true;
		for(int child : adj.get(u))
		{
			if(!visited[child])
			{
				if(dfs(child, visited, adj, st,path))
				{
					return true;
				}
			}
			else if(path[child])
			{
				return true;
			}
		}
		st.push(u);
		path[u]=false;
		return false;
	}
	
	
	
	private List<Integer> topoSort(int[][] edges,int n)
	{
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<=n;i++){
			adj.add(new ArrayList<>());
		}
		
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			adj.get(u).add(v);
		}
		boolean[] visited=new boolean[n+1];
		boolean[] path=new boolean[n+1];
		Stack<Integer> st=new Stack<>();
		for(int i=1;i<=n;i++)
		{
			if(!visited[i])
			{
				if(dfs(i,visited,adj,st,path))
				{
					return new ArrayList<Integer>();
				}
			}
		}
		List<Integer> result=new ArrayList<Integer>();
		while(!st.isEmpty())
		{
			result.add(st.pop());
		}
		return result;
	}
	
	
	
	
	
	public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
		List<Integer> rowSort=topoSort(rowConditions,k);
		List<Integer> colSort=topoSort(colConditions,k);
		if(rowSort.isEmpty()||colSort.isEmpty())
		{
			return new int[0][0];
		}
		int[][] result=new int[k][k];
		for(int i=0;i<k;i++)
		{
			int r=rowSort.get(i);
			for(int j=0;j<k;j++)
			{
				int c=colSort.get(j);
				if(r==c)
				{
					result[i][j]=r;
				}
			}
		}
		
		return result;
	}
}
