package DP.Medium;

import java.util.Arrays;

public class Problem_931 {
	int n;
	int[][] dp;
	boolean[][] visited;
	int solve(int[][] matrix,int row,int col)
	{
		if(visited[row][col])
		{
			return dp[row][col];
		}
		if(row==n-1)
		{
			return matrix[row][col];
		}
		int current_value=matrix[row][col];
		int min=Integer.MIN_VALUE;
		
		for(int cl=-1;cl<=1;cl++)
		{
			if(col+cl>=0 && col+cl<n  &&  row+1<n)
			{
				min=Math.min(min,current_value+solve(matrix,row+1,col+cl));
			}
		}
		visited[row][col]=true;
		dp[row][col]=min;
		return dp[row][col];
	}
	

	public int minFallingPathSum(int[][] matrix) {
		n=matrix.length;
		dp=new int[n][n];
		visited=new boolean[n][n];
		
		int row=0;
		int result=Integer.MAX_VALUE;
		for(int col=0;col<n;col++)
		{
			result=Math.min(result, solve(matrix,row,col));
		}
		
		return result;
	}

}
