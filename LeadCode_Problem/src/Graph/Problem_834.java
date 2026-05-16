package Graph;

import java.util.*;

public class Problem_834 {
	int topRoot=0,n;
	int[]childCount;
	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		int[] result=new int[n];
		this.n=n;
		childCount=new int[n];
		
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		dfsTop(adj,0,-1,0);
		result[0]=topRoot;
		
		dfsResult(adj,0,-1,result);
		
		return result;
	}
	
	private void dfsResult(List<List<Integer>> adj,int presentNode,int prev,int[] result)
	{
		for(int child : adj.get(presentNode))
		{
			if(child==prev)
			{
				continue;
			}
			
			result[child]=result[presentNode]-childCount[child]+(n-childCount[child]);
			dfsResult(adj, child,presentNode,result);
		}
	}
	
	private int dfsTop(List<List<Integer>> adj,int presentNode,int prev,int deft)
	{
		int totalCount=1;
		topRoot+=deft;
		for(int child : adj.get(presentNode))
		{
			if(child==prev)
			{
				continue;
			}
			totalCount+=dfsTop(adj, child,presentNode, deft+1);
		}
		childCount[presentNode]=totalCount;
		return totalCount;
	}
	
	public Problem_834()
	{
		int n=2,edges[][]={{1,0}};
		System.out.println(Arrays.toString(sumOfDistancesInTree(n, edges)));
		
	}
}
