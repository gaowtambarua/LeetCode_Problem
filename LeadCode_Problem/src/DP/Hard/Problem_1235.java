package DP.Hard;

import java.util.*;

public class Problem_1235 {
	int[] mem;
//	 Use Binaray Search ALgoritham
	int findNextSechedul(int i,int n, int[][] jobSchedul){
		int l=i;
		int r=n-1;
		int target=jobSchedul[i-1][1];
		int result=n+1;
		
		while(l<=r)
		{
			int mid=l+(r-l)/2;
			
			if(jobSchedul[mid][0]<target)
			{
				l=mid+1;
			}
			else
			{
				result=mid;
				r=mid-1;
			}
		}
		
		return result;
	}
	
	public int solve(int idx,int n,int[][] jobSchedul)
	{
		
		if(idx>=n)
		{
			return 0;
		}
		if(mem[idx]!=-1)
		{
			return mem[idx];
		}
		int next=findNextSechedul(idx+1,n,jobSchedul);//	 Use Binaray Search ALgoritham
		int left=jobSchedul[idx][2]+solve(next, n, jobSchedul);
		int right=solve(idx+1, n, jobSchedul);
		mem[idx]=Math.max(left,right);
		return mem[idx];
	}

	
	
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		
		int n=startTime.length;
		
		int[][] jobSchedul=new int[n][3];
		for(int i=0;i<n;i++)
		{
			int st=startTime[i];
			int end=endTime[i];
			int prfit=profit[i];
			
			jobSchedul[i][0]=st;
			jobSchedul[i][1]=end;
			jobSchedul[i][2]=prfit;
		}
		Arrays.sort(jobSchedul,(a,b)->Integer.compare(a[0],b[0]));
		mem=new int[n+1];
		Arrays.fill(mem,-1);
		
		return solve(0,n,jobSchedul);
	}
}
