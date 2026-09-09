package Graph;
import java.util.*;
public class Problem_310 {
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n==1)
		{
			return new ArrayList<>(Arrays.asList(0));
		}
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		int[] indegree=new int[n];
		
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
			indegree[u]++;
			indegree[v]++;
		}
		
		Queue<Integer> qu=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==1)
			{
				qu.offer(i);
			}
		}
		while(n>2)
		{
			int size=qu.size();
			n=n-size;
			while(size-->0)
			{
				int current=qu.poll();
				for(int node : adj.get(current))
				{
					indegree[node]--;
					if(indegree[node]==1)
					{
						qu.offer(node);
					}
				}
			}
		}
		return new ArrayList<>(qu);
	}
	
	public Problem_310()
	{
		int result =  ((5 - 2+5) % 5) + 1;
		System.out.println(result);
	}
}
