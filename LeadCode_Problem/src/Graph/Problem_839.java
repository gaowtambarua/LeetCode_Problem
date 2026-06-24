package Graph;
import java.util.*;
public class Problem_839 {
	/////////////// Using Graph
	//	private boolean isSimilar(String str1, String str2)
	//	{
	//		int n=str1.length();
	//		int dif=0;
	//		for(int i=0;i<n;i++)
	//		{
	//			char ch1=str1.charAt(i);
	//			char ch2=str2.charAt(i);
	//			if(ch1!=ch2)
	//			{
	//				dif++;
	//			}
	//		}
	//		return dif==2||dif==0;
	//	}
	//	private void dfs(int node,boolean[] visited,List<List<Integer>> adj)
	//	{
	//		visited[node]=true;
	//		for(int child : adj.get(node))
	//		{
	//			if(!visited[child])
	//			{
	//				dfs(child, visited, adj);
	//			}
	//		}
	//	}
	//	public int numSimilarGroups(String[] strs) {
	//		
	//		int n=strs.length;
	//		
	//		List<List<Integer>> adj=new ArrayList<>();
	//		for(int i=0;i<n;i++)
	//		{
	//			adj.add(new ArrayList<>());
	//		}
	//		for(int i=0;i<n;i++)
	//		{
	//			for(int j=i+1;j<n;j++)
	//			{
	//				if(isSimilar(strs[i],strs[j])){
	//					adj.get(i).add(j);
	//					adj.get(j).add(i);
	//				}
	//			}
	//		}
	//		
	//		boolean[] visited=new boolean[n];
	//		int count=0;
	//		for(int i=0;i<n;i++)
	//		{
	//			if(!visited[i])
	//			{
	//				dfs(i,visited,adj);
	//				count++;
	//			}
	//		}
	//		
	//		return count;
	//	}


	////////////// Using DSU	

	int[] parent;
    int[] rank;

    private int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return find(parent[x]);       
    }

    private void union(int a,int b)
    {
        int pa=find(a);
        int pb=find(b);

        if(rank[pa]<rank[pb])
        {
            parent[pa]=pb;
        }
        else if(rank[pa]>rank[pb])
        {
            parent[pb]=pa;
        }
        else
        {
            parent[pb]=pa;
            rank[pa]++;
        }
    }
    private boolean similar(String s1,String s2)
    {
        int n=s1.length();
        int diff=0;
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                diff++;
            }
        }
        return diff==2||diff==0;
    }
    public int numSimilarGroups(String[] strs) {
        int n=strs.length,result=n;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if((similar(strs[i],strs[j])) && (find(i)!=find(j)))
                {
                    union(i,j);
                    result--;
                }
            }
        }

        return result;
    }

	public Problem_839()
	{

	}
}
