package Graph;
import java.util.*;
public class Problem_1857 {

	public int largestPathValue(String colors, int[][] edges) {
		int n=colors.length();
		List<List<Integer>> adj=new ArrayList<>();
		int[] indegree=new int[n];
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		for(int [] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			adj.get(u).add(v);
			indegree[v]++;
		}
		Queue<Integer> qu=new LinkedList<Integer>();
		int[][] t=new int[n][26];
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==0)
			{
				qu.offer(i);
				t[i][colors.charAt(i)-'a']=1;
			}
		}
		
		int answer=0,count=0;
		
		while(!qu.isEmpty())
		{
			int u=qu.poll();
			count++;
			answer=Math.max(answer, t[u][colors.charAt(u)-'a']);
			for(int v : adj.get(u))
			{
				for(int i=0;i<26;i++)
				{
					t[v][i]=Math.max(t[v][i],t[u][i]+(colors.charAt(v)-'a'==i?1:0));
				}
				indegree[v]--;
				if(indegree[v]==0)
				{
					qu.offer(v);
				}
			}
		}
		

		return count<n?-1:answer;
	}


	public Problem_1857()
	{
		int[][] edges ={{0,1},{0,2},{2,3},{3,4}};
		String colors = "abaca";
		largestPathValue(colors, edges);
	}
}
