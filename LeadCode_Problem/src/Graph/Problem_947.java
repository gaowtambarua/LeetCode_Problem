package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem_947 {

	class DSU{
		int[] parent;
		public DSU(int n)
		{
			parent=new int[n];
			for(int i=0;i<n;i++)
			{
				parent[i]=i;
			}
		}
		
		int find(int x)
		{
			if(parent[x]==x)
			{
				return x;
			}
			return find(parent[x]);
		}
		
		void union(int a,int b)
		{
			int pa=find(a);
			int pb=find(b);
			
			if(pa!=pb)
			{
				parent[pa]=pb;
			}
		}
	}


	public int removeStones(int[][] stones) {
		int n=stones.length;
		DSU dsu=new DSU(n);


		// same row or same column হলে union
		for (int i = 0; i < n; i++) {
			for(int j=i+1;j<n;j++)
			{
				if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
				{
					dsu.union(i,j);
				}
			}
		}
		
		Set<Integer> components = new HashSet<>();

        for (int i = 0; i < n; i++) {
        	components.add(dsu.find(i));
        }
		
		
		return n-components.size();
	}



	public Problem_947()
	{
		int[][] stones ={	
				{0,0},
				{0,1},
				{1,0},
				{1,2},
				{2,1},
				{2,2}
		};

		System.out.println(removeStones(stones));
	}
}
