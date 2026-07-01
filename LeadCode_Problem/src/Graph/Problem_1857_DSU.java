package Graph;

import java.util.Arrays;

public class Problem_1857_DSU {
	
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
	
	public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		
		parent=new int[n];
		rank=new int[n];
		
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
		}
		
		
		int qSize=queries.length;
		boolean [] result=new boolean[qSize];
		int[][] newqueries=new int[qSize][4];
		for(int i=0;i<qSize;i++)
		{
			newqueries[i][0]=queries[i][0];
			newqueries[i][1]=queries[i][1];
			newqueries[i][2]=queries[i][2];
			newqueries[i][3]=i;
		}
		Arrays.sort(newqueries,(a,b)->a[2]-b[2]);
		Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
		int j=0;
		for(int[] newquerie : newqueries)
		{
			int u=newquerie[0];
			int v=newquerie[1];
			int dis=newquerie[2];
			int idx=newquerie[3];
			while(j<edgeList.length&&edgeList[j][2]<dis)
			{
				union(edgeList[j][0],edgeList[j][1]);
				j++;
			}
			if(find(u)==find(v))
			{
				result[idx]=true;
			}
		}
		
		return result;
	}
	public Problem_1857_DSU()
	{
		int n = 3, 
				edgeList[][] ={{0,1,2},{1,2,4},{2,0,8},{1,0,16}}, 
				queries[][] ={{0,2,5},{0,1,2}}; 
		distanceLimitedPathsExist(n, edgeList, queries);
	}
}
