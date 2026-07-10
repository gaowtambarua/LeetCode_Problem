package Problem;
import java.util.*;
public class Problem_2101 {



	public int maximumDetonation(int[][] bombs) {
		int totalbom=bombs.length;
		Map<Integer,List<Integer>> adj=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<totalbom;i++)
		{
			for(int j=0;j<totalbom;j++)
			{
				if(i==j)
				{
					continue;
				}
				int x1=bombs[i][0];
				int y1=bombs[i][1];
				int r1=bombs[i][2];

				int x2=bombs[j][0];
				int y2=bombs[j][1];
				int r2=bombs[j][2];

				long x=(long)Math.pow((x2-x1),2);
				long y=(long)Math.pow((y2-y1),2);
				double d=Math.sqrt(x+y);
				if(r1>=d)
				{
					adj.computeIfAbsent(i,key->new ArrayList<Integer>()).add(j);
				}
			}
		}
		int result=0;
		for(int i=0;i<totalbom;i++)
		{
			boolean[] visited=new boolean[totalbom];
			result=Math.max(result,dfs(visited,i,adj));
		}
		
		return  result;
	}
	private int dfs(boolean[] visited,int node,Map<Integer,List<Integer>> adj)
	{
		int result=1;
		visited[node]=true;
		if(adj.get(node)!=null)
		{
			for(int child : adj.get(node))
			{
				if(!visited[child])
				{
					result=result+dfs(visited, child, adj);
				}
			}
		}

		return result;
	}

	public Problem_2101()
	{
		int[][] bombs={{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
		
		
		System.out.println(maximumDetonation(bombs));
	}
}
