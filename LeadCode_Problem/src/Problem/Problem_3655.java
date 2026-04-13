package Problem;
import java.util.*;

import javax.print.attribute.standard.Fidelity;
public class Problem_3655 {
	
	int m=(int)1e9+7;
	long findpow(long a,long pow)
	{
		if(pow==0)// a^0=1
		{
			return 1;
		}
		long half=findpow(a, pow/2);
		long result=(half*half)%m;
		if(pow%2==1)
		{
			result=(result*a)%m;
		}
		return result;
	}
	
	public int xorAfterQueries(int[] nums, int[][] queries) {
		int n=nums.length;
		int blockSize=(int)Math.ceil(Math.sqrt(n));// using squre root decomsiton.
		Map<Integer,List<int[]>> map=new HashMap<>();
		
		for(int[] query : queries)
		{
			int l=query[0];
			int r=query[1];
			int k=query[2];
			int v=query[3];
			if(k>=blockSize)// using squre root decomsiton.
			{
				while(l<=r)
				{
					nums[l]=(int)(((long)nums[l]*v)%m);
					l+=k;
				}
			}
			else
			{
				map.computeIfAbsent(k,key->new ArrayList<int[]>()).add(query);
			}
		}
		
		for(int key : map.keySet())
		{
			//Using Difference Array Technique
			long dif[]=new long[n];
			Arrays.fill(dif, 1);
			
			for(int[] query : map.get(key))
			{
				int l=query[0];
				int r=query[1];
				int k=query[2];
				int v=query[3];
				
				dif[l]=(dif[l]*v)%m;
				
				int step=(r-l)/k;
				int next=l+(step+1)*k;
				
				if(next<n)
				{
					
					dif[next]=( dif[next]*findpow(v,m-2))%m;
				}
			}
			
			for(int i=0;i<n;i++)
			{
				if(i-key>=0)
				{
					dif[i]=(dif[i]*dif[i-key])%m;
				}			
			}
			
			for(int i=0;i<n;i++)
			{
				nums[i]=(int)((nums[i]*dif[i])%m);
			}
		}
		int result=0;
		for(int val : nums)
		{
			result^=val;
		}
		return result;
	}
	
	public Problem_3655()
	{
		int[] nums={2,3,1,5,4};
		int[][] queries={
				{1,4,2,3},
				{1,4,3,3},
				{1,5,2,3},
				{0,2,1,2}
				};
		xorAfterQueries(nums,queries);
	}


}
