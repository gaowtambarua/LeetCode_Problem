package Graph;
import java.util.*;
public class Problem_886 {

	public boolean possibleBipartitiion(int n, int[][] dislikes)
	{
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<=n;i++)
		{
			adj.add(new ArrayList<>());
		}

		for(int[] dir : dislikes)
		{
			adj.get(dir[0]).add(dir[1]);
			adj.get(dir[1]).add(dir[0]);
		}
		boolean[] visited=new boolean[n+1];
		int[] group=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			if(!visited[i])
			{
				if(!bfs(i,visited,adj,group))
				{
					return false;
				};
			}
		}

		return true;
	}
	private boolean bfs(int node,boolean[] visited,List<List<Integer>> adj,int[] group)
	{
		Queue<Integer> qu=new LinkedList<>();
		qu.offer(node);
		visited[node]=true;

		while(!qu.isEmpty())
		{
			int presentnode=qu.poll();

			for(int val : adj.get(presentnode))
			{
				if(!visited[val])
				{
					visited[val]=true;
					qu.offer(val);
					if(group[presentnode]==0)
					{
						group[val]=-1;
					}
				}
				else if(group[val]==group[presentnode])
				{
					return false;
				}
			}
		}
		return true;
	}





	public Problem_886()
	{
		int n=5;
		int[][] dislikes={
				{1,3},
				{1,2},
				{4,1},
				{5,4}
		};
		System.out.println(possibleBipartitiion(n, dislikes));
	}
}
