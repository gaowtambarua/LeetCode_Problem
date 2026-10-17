package DP.Medium;

public class Problem_983 {
	
	int[] dp;
	
	private int solve(int[] days,int n,int i,int[] costs)
	{
		if(i>=n)
		{
			return 0;
		}
		if(dp[i]!=0)
		{
			return dp[i];
		}
		
		int cost_1=costs[0]+solve(days, n, i+1, costs);
	
		
		int j=i;
		int maxday=days[j]+7;
		while(j<n && days[j]<maxday)
		{
			j++;
		}
		int cost_2=costs[1]+solve(days, n, j, costs);
		
		
		j=i;
		maxday=days[j]+30;
		while(j<n && days[j]<maxday)
		{
			j++;
		}
		int cost_3=costs[2]+solve(days, n, j, costs);
		
		return dp[i]= Math.min(cost_1, Math.min(cost_2, cost_3));
	}


	public int mincostTickets(int[] days, int[] costs) {
		int n=days.length;
		dp=new int[n];
		return solve(days,n,0,costs);
	}


}
