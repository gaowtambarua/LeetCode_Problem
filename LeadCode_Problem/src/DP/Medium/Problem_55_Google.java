package DP.Medium;

import java.util.Arrays;

public class Problem_55_Google {
	
	int[] dp;
	boolean[] mam;
	private boolean solve(int[] nums,int n,int idx)
	{
		
		if(idx==n-1)
		{
			return true;
		}
		else if(idx>=n)
		{
			return false;
		}
		if(dp[idx]!=-1)
		{
			return mam[idx];
		}
		
		for(int i=1;i<=nums[idx];i++)
		{
			if(solve(nums,n,i+idx))
			{
				dp[idx]=1;
				return mam[idx]=true;
			}
		}
		dp[idx]=1;
		return mam[idx]=false;
	}
	
	
	 public boolean canJump(int[] nums) {
		 int n=nums.length;
		 int[] dp=new int[n];
		 Arrays.fill(dp,-1);
		 mam=new boolean[n];
		 
		 return solve(nums,n,0);
	 }
	
	
	
	public Problem_55_Google()
	{
		
	}
}
