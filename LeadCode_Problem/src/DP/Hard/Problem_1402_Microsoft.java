package DP.Hard;

import java.util.Arrays;

public class Problem_1402_Microsoft {
	int[][] dp;
	private int solve(int[] satisfaction,int idx,int n,int time)
	{
		if(idx>=n)
		{
			return 0;
		}
		if(dp[idx][time]!=0)
		{
			return dp[idx][time];
		}
		int left=satisfaction[idx]*time+solve(satisfaction, idx+1, n, time+1);
		int right=solve(satisfaction, idx+1, n, time);
		
		return dp[idx][time]=Math.max(left, right);
	}
	
	public int maxSatisfaction(int[] satisfaction) {
		int n=satisfaction.length;
		Arrays.sort(satisfaction);
		dp=new int[n][n+1];
		
		return solve(satisfaction,0,n,1);
	}
}
