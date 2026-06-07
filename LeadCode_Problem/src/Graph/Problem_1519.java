package Graph;
import java.util.*;
public class Problem_1519 {
	
	public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
        	graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
        	int u=edge[0];
        	int v=edge[1];
        	graph.get(u).add(v);
        	graph.get(v).add(u);
        }
        
        int[] result=new int[n];
        int[] count=new int[26];
        
        dfs(graph,labels,0,-1,result,count);
        
        return result;
    }
	
	private void dfs(List<List<Integer>> graph,String lavels,int node,int parent,int[] result,int[] count)
	{
		char ch=lavels.charAt(node);
		int beforeCharCount=count[ch-'a'];
		count[ch-'a']+=1;
		
		for(int child : graph.get(node))
		{
			if(child==parent)
			{
				continue;
			}
			dfs(graph,lavels,child,node,result,count);
		}
		
		int afterCharCount=count[ch-'a'];
		
		result[node]=afterCharCount-beforeCharCount;
	}
}
