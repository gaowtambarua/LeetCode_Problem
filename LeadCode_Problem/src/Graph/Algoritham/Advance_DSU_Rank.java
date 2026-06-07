package Graph.Algoritham;

public class Advance_DSU_Rank {
	
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
		
		boolean union(int a,int b)
		{
			
			int pa=find(a);
			int pb=find(b);

			if(pa==pb)
			{
				
				return false; // already same set → cycle
			}

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

			return true;
		}
	}
	
	public Advance_DSU_Rank()
	{
		int[][] edges={
				{2,1},
				{1,0},
				{0,2}//cycle
		};
		
		DSU dsu=new DSU(3);
		boolean cycle=false;
		
		for(int[] e : edges)
		{
			int u=e[0];
			int v=e[1];
			
			if(!dsu.union(u, v))
			{
				cycle=true; // cycle detected
				break;
			}
		}
	}
}
