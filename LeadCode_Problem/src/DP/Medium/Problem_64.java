package DP.Medium;

public class Problem_64 {
	 int dp[][];
		
		int solve(int[][] grid,int i,int j,int m,int n)
		{
			if(i>=m-1 && j>=n-1)
			{
				return grid[i][j];
			}
			if(dp[i][j]!=0)
	        {
	            return dp[i][j];
	        }
			int sum=grid[i][j];
			int left=Integer.MAX_VALUE;
			int right=Integer.MAX_VALUE;
			if(j<n-1)
			{
				left=solve(grid,i,j+1,m,n);
			}
			
			if(i<m-1)
			{
				right=solve(grid,i+1,j,m,n);
			}
			sum=sum+Math.min(left,right);
			
			return dp[i][j]=sum;
		}
		
		public int minPathSum(int[][] grid) {
	        int m=grid.length;
	        int n=grid[0].length;
	        dp=new int[m][n];
	        
	        return solve(grid,0,0,m,n);
	    }
	
	
}
