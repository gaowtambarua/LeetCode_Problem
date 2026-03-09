package Problem;

import java.util.Arrays;

public class Minimum_Removals_to_Balance_Array {

	public int minRemoval(int[] nums, int k) {
		Arrays.sort(nums);
		int n=nums.length,left=0,maxLen=0;
		for(int right=0;right<n;right++)
		{
			
			while((long)nums[right]>(long)nums[left]*k)
			{
				left++;
			}
			maxLen=Math.max(maxLen,(right-left)+1);
		}
		
		return n-maxLen;
	}

	public Minimum_Removals_to_Balance_Array()
	{
		int [] nums={2,1,5};
		int k=2;
		System.out.println(minRemoval(nums, k));
	}
}
