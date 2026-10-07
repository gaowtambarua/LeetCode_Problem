package DP.Hard;
import java.util.*;
public class Problem_1751 {
	
	int[][] mem;
	int findNextIndx(int[][] arr,int left ,int right)
	{
		int result=right+1;
		int target=arr[left-1][1];
		while(left<=right)
		{
			int mid=left+(right-left)/2 ;
			
			if(arr[mid][0]<=target)
			{
				left=mid+1;
			}
			else
			{
                result=mid;
				right=mid-1;
			}
			
		}
		
		return  result;
	}
	
	
	int solve(int[][] arr,int k,int idx,int n)
	{
		if(idx>=n||k==0)
		{
			return 0;
		}
		if(mem[idx][k]!=-1)
		{
			return mem[idx][k];
		}
		int nextIdx=findNextIndx(arr,idx+1,n-1);
		int left=arr[idx][2]+solve(arr,k-1,nextIdx,n);
		int right=solve(arr,k,idx+1,n);
		
		
		return mem[idx][k]=Math.max(left,right);
		
	}

	public int maxValue(int[][] events, int k) {
		
		int n=events.length;
		Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
		mem=new int[n][k+1];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(mem[i],-1);
		}
		return solve(events,k,0,n);
	} 


	public Problem_1751()
	{

	}
}
