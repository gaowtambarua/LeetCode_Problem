package Graph.Hard;

import java.util.*;

public class Problem_1489_MST {
	
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
			}
		}
		private int find(int x)
		{
			if(parent[x]==x)
			{
				return x;
			}
			return find(parent[x]);
		}
		private boolean union(int a,int b)
		{
			int pa=find(a);
			int pb=find(b);
			if(pa==pb)
			{
				return false;
			}
			if(rank[pa]==rank[pb])
			{
				parent[pb]=pa;
				rank[pa]++;
			}
			else if(rank[pa]>rank[pb])
			{
				parent[pb]=pa;
			}
			else
			{
				parent[pa]=pb;
			}
			return true;
		}
	}
	
	private int mst(int[][] edges,int n,int skip,int add)
	{
		int mstWeight=0;
		int size=edges.length;
		DSU dsu=new DSU(n);
		if(add!=-1)
		{
			int u=edges[skip][0];
			int v=edges[skip][1];
			int wt=edges[skip][2];
			dsu.union(u, v);
			mstWeight+=wt;
		}
		for(int i=0;i<size;i++)
		{
			if(i==skip)
			{
				continue;
			}
			int u=edges[i][0];
			int v=edges[i][1];
			int wt=edges[i][2];
			if(dsu.union(u, v))
			{
				mstWeight+=wt;
			}
			
		}
		for(int i=0;i<n;i++)
		{
			if(dsu.find(0)!=dsu.find(i))
			{
				return Integer.MAX_VALUE;
			}
		}
		
		return mstWeight;
	}

	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
		int size=edges.length;
		int[][]temedges=new int[size][4];
		
		for(int i=0;i<size;i++)
		{
			temedges[i][0]=edges[i][0];
			temedges[i][1]=edges[i][1];
			temedges[i][2]=edges[i][2];
			temedges[i][3]=i;
		}
		
		Arrays.sort(temedges,(a,b)->a[2]-b[2]);
		List<Integer> critical=new ArrayList<Integer>();
		List<Integer> pseudo_critical=new ArrayList<Integer>();
		int mainMst=mst(temedges,n,-1,-1);
		for(int i=0;i<size;i++)
		{
			if(mst(temedges,n,i,-1)>mainMst)
			{
				critical.add(temedges[i][3]);
			}
			else if(mst(temedges,n,i,0)==mainMst)
			{
				pseudo_critical.add(temedges[i][3]);
			}
			
		}
		
		return new ArrayList<>(Arrays.asList(critical,pseudo_critical));
	}


	public Problem_1489_MST()
	{
		int n=5;
		int[][] edges={{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
	}
}
