package DP.Medium;

import java.util.Arrays;

public class Problem_926_Google {

	int[][] dp;
	private int solve(String s,int n,int idx,int pre)
	{
		if(idx>=n)
		{
			return 0;
		}
		if(dp[idx][pre]!=-1)
		{
			return dp[idx][pre];
		}
		int flip=Integer.MAX_VALUE;
		int notflip=Integer.MAX_VALUE;
		
		if(s.charAt(idx)=='1')
		{
			if(pre==1)
			{
				notflip=solve(s, n, idx+1, 1);
			}
			else
			{
				flip=1+solve(s,n,idx+1,0);
				notflip=solve(s, n, idx+1, 1);
			}
		}
		else
		{
			if(pre==0)
			{
				notflip=solve(s,n,idx+1,0);
				flip=1+solve(s,n,idx+1,1);
			}
			else
			{
				flip=1+solve(s, n, idx+1, 1);
			}
		}
		
		
		return  dp[idx][pre]=Math.min(flip, notflip);
	}
	
	public int minFlipsMonoIncr(String s) {
		int n=s.length();
		dp=new int[n][2];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(dp[i],-1);
		}
		return solve(s,n,0,0);
	}

}
