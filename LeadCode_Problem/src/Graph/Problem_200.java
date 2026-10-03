package Graph;

public class Problem_200 {
	int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
	void dfs(int i,int j,char[][] grid,int m ,int n)
	{
		grid[i][j]='0';
		
		for(int[] d : dir)
		{
			int i_=d[0]+i;
			int j_=d[1]+j;
			if((i_>=0 && i_<m) && (j_>=0 && j_<n) && grid[i_][j_]=='1')
			{
				dfs(i_,j_,grid,m,n);
			}
		}
	}
	
	
	public int numIslands(char[][] grid) {
		
		int count=0;
		int m=grid.length;
		int n=grid[0].length;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(grid[i][j]=='1')
				{
					dfs(i,j,grid,m,n);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public Problem_200()
	{
		char [][] grid =
			{
				{'1','1','1'},{'0','1','0'},{'1','1','1'}
			};
		numIslands(grid);
	}
}
