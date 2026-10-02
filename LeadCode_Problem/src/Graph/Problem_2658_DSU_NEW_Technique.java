package Graph;

public class Problem_2658_DSU_NEW_Technique {
	
	
	class DSU{
		int[] parent;
		int[] rank;
		int[] size;
		
		public DSU(int n)
		{
			parent=new int[n];
			rank=new int[n];
			size=new int[n];
			
			for(int i=0;i<n;i++)
			{
				parent[i]=i;
			}
		}
		
		void union(int a,int b)
		{
			int pa=find(a);
			int pb=find(b);
			
			if(pa==pb)
			{
				return ;
			}
			
			if(rank[pa]==rank[pb])
			{
				rank[pa]++;
				parent[pb]=pa;
				size[pa]=size[pa]+size[pb];
			}
			else if(rank[pa]>rank[pb])
			{
				parent[pb]=pa;
				size[pa]=size[pa]+size[pb];
			}
			else 
			{
				parent[pa]=pb;
				size[pb]=size[pb]+size[pa];
			}
		}
		
		int find(int x)
		{
			if(x==parent[x])
			{
				return x;
			}
			
			return find(parent[x]);
		}
		
		void set(int idx,int val)
		{
			size[idx]=val;
		}
		
		int result()
		{
			int max=0;
			for(int val : size)
			{
				max=Math.max(val,max);
			}
			
			return max;
		}
	}
	
	
	

	public int findMaxFish(int[][] grid) {
		int[][] direction={{0,1},{0,-1},{0,1},{-1,0}};
		int m=grid.length;
		int n=grid[0].length;
		
		DSU dsu=new DSU(m*n);
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int idx=i*n+j;
				dsu.set(idx,grid[i][j]);
			}
		}
		
		
		
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(grid[i][j]>0)
				{
					int idx=i*n+j;
					for(int[] dir : direction)
					{
						int i_=dir[0]+i;
						int j_=dir[1]+j;
						
						if(i_>=0&&i_<m&&j_>=0&&j_<n && grid[i_][j_]>0)
						{
							int idx_=i_*n+j_;
							dsu.union(idx,idx_);
						}
					}
				}
			}
		}
		
		
		return dsu.result();
		
	}
}
