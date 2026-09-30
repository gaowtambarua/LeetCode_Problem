package DP.Hard;

import java.util.Arrays;

public class Problem_1335 {
	
	
	int[][] dp;
	private int sulution(int[] job ,int idx,int d,int n)
	{
		if(dp[d][idx]!=-1)
		{
			return dp[d][idx];
		}
		if(d==1)
		{
			int max=0;
			for(int i=idx;i<n;i++)
			{
				max=Math.max(max,job[i]);
			}
			return max;
		}
		
		int maxJob=0;
		int finalResult=Integer.MAX_VALUE;
		for(int i=idx;i<=n-d;i++)
		{
			maxJob=Math.max(maxJob,job[i]);
			finalResult=Math.min(finalResult,maxJob+sulution(job,i+1,d-1,n));
		}
		dp[d][idx]=finalResult;
		return dp[d][idx];
	}
	

	public int minDifficulty(int[] jobDifficulty, int d) {
		
		int n=jobDifficulty.length;
		dp=new int[d+1][n];
		for(int i=0;i<d+1;i++)
		{
			Arrays.fill(dp[i],-1);
		}
		if(n<d)
		{
			return -1;
		}
		
		return sulution(jobDifficulty,0,d,n);
	}
}
