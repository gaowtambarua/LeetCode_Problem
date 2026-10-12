package Heap_Priority_Queue_Greedy;

public class Problem_11 {
	 public int maxArea(int[] height) {
	        int left=0;
	        int right=height.length-1;
	        int result=0;
	        while(left<right){
	            int min_hight=Math.min(height[left],height[right]);
	            result=Math.max(result,min_hight*(right-left));

	            if(min_hight==height[left])
	            {
	                left++;
	            }
	            else if(min_hight==height[right])
	            {
	                right--;
	            }

	        }

	        return result;
	    }
}
