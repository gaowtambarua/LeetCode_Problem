package Problem;

public class Problem_3740 {

	public int minimumDistance(int[] nums) {
		int result=Integer.MAX_VALUE,n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(nums[i]==nums[j])
				{
					for(int k=j+1;k<n;k++)
					{
						if(nums[j]==nums[k])
						{
							result=Math.min(result,2*(k-i));
						}
					}
				}
			}
		}
		
		return (result==Integer.MAX_VALUE)? -1 : result;
	}

	public Problem_3740()
	{
		int[] nums={1,2,1,1,3};
		System.out.println(minimumDistance(nums));
	}
}
