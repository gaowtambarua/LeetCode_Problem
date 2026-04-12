package Problem;

public class Problem_3653 {
	public int xorAfterQueries(int[] nums, int[][] queries) {
		int m=(int)1e9+7;
		for(int[] query : queries)
		{
			int l=query[0];
			int r=query[1];
			int k=query[2];
			int v=query[3];
			
			while(l<=r)
			{
				nums[l]=(int)(( (long)(nums[l])*v )%m);
				l+=k;
			}
		
		}
		
		int result=0;
		for(int val : nums)
		{
			result^=val;
		}
		return result;
	}
	public Problem_3653()
	{
		int nums[]={1,1,1},queries[][]={{0,2,1,4}};
		System.out.println(xorAfterQueries(nums, queries));
		
		int a=6-8;
	}
}
