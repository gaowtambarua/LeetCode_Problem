package Monotonic_Queue_Stack.Hard;
import java.util.*;
public class Problem_239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n=nums.length;
		int[] result=new int[n-k+1];
		
		int left=0;
		Deque<Integer> qu=new ArrayDeque<>();
		int idx=0;
		for(int i=0;i<n;i++)
		{
			if(i-idx==k)
			{
				qu.poll();
			}
			
			while(!qu.isEmpty()&& nums[qu.peekLast()]<nums[i])
			{
				qu.pollLast();
			}
			qu.offer(i);
			
			if(i-left+1==k)
			{
				result[left]=nums[qu.peek()];
				left++;
				idx=qu.peek();
			}
			
		}
		System.out.println(Arrays.toString(result));
		
		return result;
	}
	
	public Problem_239()
	{
//		ArrayDeque<Integer> dq=new ArrayDeque<Integer>();
//		dq.offer(1);
//		dq.offer(2);
//		dq.offer(3);
//		while(!dq.isEmpty())
//		{
//			System.out.println(dq.pollLast());
//		}
//		
		maxSlidingWindow(new int[]{3,4,2,3,1},3);
	}
}
