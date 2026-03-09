package Problem;
import java.util.*;
public class Longest_Balanced_Subarray_I {

	/////////////////// Using Brute Force

	//	public int longestBalanced(int[] nums) {
	//		int n=nums.length,maxLn=0;
	//		
	//		for(int i=0;i<n;i++)
	//		{
	//			Set<Integer> setEven=new HashSet<>();
	//			Set<Integer> setOdd=new HashSet<>();
	//			for(int j=i;j<n;j++)
	//			{
	//				if(!setEven.contains(nums[j])||!setOdd.contains(nums[j]))
	//				{
	//					if(nums[j]%2==0)
	//					{
	//						setEven.add(nums[j]);
	//					}
	//					else
	//					{
	//						setOdd.add(nums[j]);
	//					}
	//				}
	//				if(setEven.size()==setOdd.size())
	//				{
	//					maxLn=Math.max(maxLn,j-i+1);
	//				}
	//			}
	//		}
	//		
	//		return maxLn;
	//	}


	/////////////////// Using Segment Tree
	int maxLen=0;
	public int longestBalanced(int[] nums) {
		int len=nums.length;
		
		for(int i=0;i<len;i++)
		{
			Set<Integer> setEven=new HashSet<>();
			Set<Integer> setOdd=new HashSet<>();
			buildSegmentTree(setEven,setOdd,nums,i,len-1);
			if(len-i==maxLen)
			{
				return maxLen;
			}
			break;
		}
		
		return maxLen;
	}
	public void buildSegmentTree(Set<Integer> setEven,Set<Integer> setOdd,int[] nums,int left,int right)
	{
		if(left==right)
		{
			if(nums[left]%2==0)
			{
				setEven.add(nums[left]);
			}
			else
			{
				setOdd.add(nums[left]);
			}
			return;
		}
		int mid=left+(right-left)/2;
		buildSegmentTree(setEven, setOdd, nums, left, mid);
		System.out.println(setEven);
		System.out.println(setOdd);
		System.out.println(maxLen+" "+left+" "+right+" ");
		System.out.println();
		buildSegmentTree(setEven, setOdd, nums, mid+1, right);
		if(setEven.size()==setOdd.size())
		{
			maxLen=Math.max(maxLen,right-left+1);
		}
		
	}

	public Longest_Balanced_Subarray_I()
	{
		int [] nums={7,7,10,4};
		System.out.println(longestBalanced(nums));
	}
}
