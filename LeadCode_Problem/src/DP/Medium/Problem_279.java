package DP.Medium;

import java.util.Arrays;

public class Problem_279 {

	int[] mem;
	
	public int solve (int n) {
		if(mem[n]!=-1)
		{
			return mem[n];
		}
		if(n==0)
		{
			return 0;
		}
		int s=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++)
		{
			int sqr=i*i;
			s=Math.min(1+solve(n-sqr),s);
		}
		return mem[n]=s;
	}
	public int numSquares(int n) {
		mem=new int[n];
		Arrays.fill(mem,-1);
		return solve(n);
	}
	
	
	public Problem_279()
	{
		int n=Integer.MAX_VALUE;
		mem=new int[n+1];
		System.out.println(Math.max(n+1,n));
	}
}
