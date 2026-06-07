package Tree_Graph;
import java.util.*;
public class Problem_2246 {

	int result=0;
	
	public int longestPath(int[] parent, String s) {
		
		int n=parent.length;
		List<List<Integer>> graph=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			graph.add(new ArrayList<>());
		}
		for(int i=1;i<n;i++)
		{
			int u=parent[i];
			int v=i;
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		dfs(0,-1,graph,s);
		
		return result;
	}
	private int  dfs(int node,int parent,List<List<Integer>> graph,String s)
	{
		int left=0;
		int right=0;
		for(int child : graph.get(node))
		{
			if(child==parent)
			{
				continue;
			}
			int child_largest=dfs(child,node,graph,s);
			if(s.charAt(child)==s.charAt(node))
			{
				continue;
			}
			if(child_largest>left)
			{
				left=child_largest;
			}
			if(left>right)
			{
				int temp=left;
				left=right;
				right=temp;
			}
			
		}
		result=Math.max(result,1+left+right);
		return 1+Math.max(left,right);
	}

}
