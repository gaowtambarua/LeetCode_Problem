package Problem;
import java.util.*;
public class Problem_802 {

	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> result=new ArrayList<Integer>();
		int n=graph.length;
		boolean[] visited=new boolean[n];
		boolean[] path=new boolean[n];
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				dfs(i,graph,visited,path);
			}
			if(!path[i])
			{
				result.add(i);
			}
		}
		
		return result;
	}
	private boolean dfs(int node,int[][] graph,boolean[] visited,boolean[] path)
	{
		visited[node]=true;
		path[node]=true;
		for(int child : graph[node])
		{
			if(!visited[child]&&dfs(child,graph,visited,path))
			{
				return true;
			}
			else if(path[child])
			{
				return true;
			}
		}
		path[node]=false;
		return false;
	}

	public Problem_802()
	{

	}
}
