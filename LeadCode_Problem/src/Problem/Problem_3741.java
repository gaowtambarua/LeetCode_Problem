package Problem;
import java.util.*;
public class Problem_3741 {

	public int minimumDistance(int[] nums) {
		int n=nums.length,result=Integer.MAX_VALUE;
		Map<Integer,List<Integer>> map=new HashMap<Integer, List<Integer>>();
		for(int k=0;k<n;k++)
		{
//			if(!map.containsKey(nums[k]))
//			{
//				map.put(nums[k],new ArrayList<>());
//			}
//			map.get(nums[k]).add(k);
			
			map.computeIfAbsent(nums[k],key->new ArrayList<Integer>()).add(k);
			
			
			List<Integer> list=map.get(nums[k]);
			int size=list.size();
			if(size>=3)
			{
				int i=size-3;
				result=Math.min(result,2*(list.get(size-1)-list.get(i)));
			}
		}
		return result==Integer.MAX_VALUE?-1:result;
	}

	public Problem_3741()
	{
		int [] nums={1,1,2,3,2,1,2};
		System.out.println(minimumDistance(nums));
		
	}
}
