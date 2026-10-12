package Graph;

import java.util.Arrays;

public class Problem_785 {
	
	
	int[] color;

	boolean checkBipartiteDFS(int[][] graph,int node,int[] color,int currcol)
	{
		color[node]=currcol;
		
		for(int child : graph[node])
		{
			
			if(color[node]==color[child])
			{
				return false;
			}
			
			if(color[child]==-1)
			{
				int updateColor=1-currcol;
				if(!checkBipartiteDFS(graph,child, color,updateColor))
				{
					return false;
				}
			}
		}
		
		return true;
	}

	public boolean isBipartite(int[][] graph) {
		
		int n=graph.length;
		color=new int[n];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(color,-1);
		}
		
		for(int i=0;i<n;i++)
		{
			if(color[i]==-1)
			{
				if(!checkBipartiteDFS(graph,i,color,1))
				{
					return false;
				}
			}
		}
		
		
		
		return true;
	}
	
}
