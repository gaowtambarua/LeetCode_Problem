package DP.Medium;

import java.util.Arrays;

public class Problem_309 {
	int[][] dp;
	private int solve(int[] prices,int cur,int n,int buy)
	{
		if(cur>=n)
		{
			return 0;
		}
		if(dp[cur][buy]!=-1)
		{
			return dp[cur][buy];
		}
		int profit=0;
		if(buy==1)
		{
			int sell=solve(prices, cur+1, n,0)-prices[cur];
			int nextSell=solve(prices, cur+1, n,1);
			profit=Math.max(sell,nextSell);
		}
		else
		{
			int by=prices[cur]+solve(prices,cur+2,n,1);
			int nextby=solve(prices,cur+1,n,0);
			profit=Math.max(by,nextby);
		}
		
		
		return dp[cur][buy]=profit;
	}

	public int maxProfit(int[] prices) {
		int n=prices.length;
		dp=new int[n][2];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(dp[i],-1);
		}
		return solve(prices,0,n,1);
	}
	
	public Problem_309()
	{
	
	}
}
