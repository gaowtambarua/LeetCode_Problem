package Problem;

import java.util.Arrays;

public class Problem_3108 {

	class DSU{
		int[] parent;
		int[] rank;
		public DSU(int n)
		{
			parent=new int[n];
			rank=new int[n];
			for(int i=0;i<n;i++)
			{
				parent[i]=i;
				rank[i]=0;
			}
		}
		
		int find(int x)
		{
			if(parent[x]!=x)
			{
				parent[x]=find(parent[x]);
			}
			return parent[x];
		}
		
		void union(int a,int b)
		{
			
			int pa=find(a);
			int pb=find(b);

			// union by rank
			if(rank[pa]<rank[pb])
			{
				
				parent[pa]=pb;
			}
			else if(rank[pb]<rank[pa])
			{
				parent[pb]=pa;
			}
			else
			{
				parent[pb]=pa;
				rank[pa]++;
			}

		}
	}
	

	public int[] minimumCost(int n, int[][] edges, int[][] query) {
		
		DSU dsu=new DSU(n);
		int[] dp=new int[n];
		Arrays.fill(dp, -1);
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			dsu.union(u, v);
		}
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			int w=edge[2];
			int pa=dsu.find(u);
			dp[pa]=dp[pa]&w;
		}
		int qSize=query.length;
		int[] result=new int[qSize];
		Arrays.fill(result,-1);
		for(int i=0;i<qSize;i++)
		{
			int u=query[i][0];
			int v=query[i][1];
			int pa=dsu.find(u);
			int pb=dsu.find(v);
			if(pa==pb)
			{
				result[i]=dp[pa];
			}
		}
		
		return result;
	}
}
