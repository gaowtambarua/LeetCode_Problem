package Graph;

import java.util.Arrays;

public class Problem_1579_DSU {

	class DSU
	{
		int[] parent;
		int[] rank;

		private DSU(int n)
		{
			parent=new int[n+1];
			rank=new int[n+1];
			for(int i=0;i<=n;i++)
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
	}


	public int maxNumEdgesToRemove(int n, int[][] edges) {
		int totalEdges=edges.length;

		DSU alice=new DSU(n);
		DSU bob=new DSU(n);
		Arrays.sort(edges,(a,b)->b[0]-a[0]);
		int connectedEdge=0,aliceconncetedEdge=0,bobconnectedEdge=0;
		for(int[] edge : edges)
		{
			int type=edge[0];
			int u=edge[1];
			int v=edge[2];

			if(type==3&&alice.find(u)!=alice.find(v)&&bob.find(u)!=bob.find(v))
			{
				alice.union(u, v);
				bob.union(u, v);
				connectedEdge++;
				aliceconncetedEdge++;
				bobconnectedEdge++;
			}
			else if(type==2 && bob.find(u)!=bob.find(v))
			{
				bob.union(u, v);
				connectedEdge++;
				bobconnectedEdge++;
			}
			else if(type==1 &&alice.find(u)!=alice.find(v))
			{
				alice.union(u, v);
				connectedEdge++;
				aliceconncetedEdge++;
			}
		}
		if(aliceconncetedEdge==n-1&&bobconnectedEdge==n-1)
		{
			return totalEdges-connectedEdge;
		}
		else
		{
			return -1;
		}
	}
}
