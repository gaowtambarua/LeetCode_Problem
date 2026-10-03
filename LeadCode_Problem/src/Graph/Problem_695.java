package Graph;

public class Problem_695 {

	int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
	int dfs(int i,int j,int[][] grid,int m ,int n)
	{
		grid[i][j]=0;
		int sum=1;
		for(int[] d : dir)
		{
			int i_=d[0]+i;
			int j_=d[1]+j;
			if((i_>=0 && i_<m) && (j_>=0 && j_<n) && grid[i_][j_]==1)
			{
				sum=sum+dfs(i_,j_,grid,m,n);
			}
		}
		
		return sum;
	}
	
	

	public int maxAreaOfIsland(int[][] grid) {
		
		int m=grid.length;
		int n=grid[0].length;
		int maxArea=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(grid[i][j]==1)
				{
					maxArea=Math.max(maxArea,dfs(i,j,grid,m,n));
				}
			}
		}
		
		return maxArea;
		
	}


}
