package Graph;
import java.util.*;
public class Problem_3243 {
	
	private int bfs(List<List<Integer>> adj,int n)
	{
		int level=0;
		boolean[] visited=new boolean[n];
		Queue<Integer> qu=new LinkedList<Integer>();
		qu.offer(0);
		visited[0]=true;
		while(!qu.isEmpty())
		{
			int quSize=qu.size();
			
			while(quSize-->0)
			{
				int u=qu.poll();
				for(int child : adj.get(u))
				{
					if(!visited[child])
					{
						qu.offer(child);
						visited[child]=true;
					}
				}
			}
			level++;
			if(visited[n-1])
			{
				return level;
			}
		}
		
		return level;
	}

	public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
		
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<n-1;i++)
		{
			adj.get(i).add(i+1);
		}
		int qSize=queries.length;
		int[] result=new int[qSize];
		
		for(int i=0;i<qSize;i++)
		{
			int u=queries[i][0];
			int v=queries[i][1];
			adj.get(u).add(v);
			result[i]=bfs(adj,n);
		}
		
		System.out.println(Arrays.toString(result));
		return result;
		
	}
	
	public Problem_3243()
	{
		int[][] a={{0,3},{0,2}};
		shortestDistanceAfterQueries(4,a);
	}

}
