package Graph.Hard;
import java.util.*;
public class Problem_446 {


	//	public int numberOfArithmeticSlices(int[] nums) {
	//        int n=nums.length;
	//			
	//			Map<Long,Integer> map []=new HashMap[n];
	//			for(int i=0;i<n;i++)
	//			{
	//				map[i]=new HashMap<Long,Integer>();
	//			}
	//			int result=0;
	//			for(int j=1;j<n;j++)
	//			{
	//				for(int i=0;i<j;i++)
	//				{
	//					long dif =(long)  nums[i] - nums[j];
	//					if(map[i].containsKey(dif))
	//					{
	//						int present_value=map[i].get(dif);
	//						result+=present_value;
	//
	//	                    if(map[j].containsKey(dif))
	//	                    {
	//	                        map[j].put(dif,map[j].get(dif)+present_value+1);
	//	                    }
	//	                    else
	//	                    {
	//	                        map[j].put(dif,present_value+1);
	//	                    }
	//
	//					}
	//					else
	//					{
	//                         if(map[j].containsKey(dif))
	//                         {
	//                            map[j].put(dif,map[j].get(dif)+1);
	//                         }
	//                         else
	//                         {
	//                            map[j].put(dif,1);
	//                         }
	//					}
	//				}
	//			}
	//			
	//			return result;  
	//    }


	////////////////////////////////////////////////////////////////////////////////////////////////////

	public int numberOfArithmeticSlices(int[] nums) {
		int n=nums.length;

		Map<Long,Integer> map []=new HashMap[n];
		for(int i=0;i<n;i++)
		{
			map[i]=new HashMap<Long,Integer>();
		}
		int result=0;
		for(int j=1;j<n;j++)
		{
			for(int i=0;i<j;i++)
			{
				long dif =(long)  nums[i] - nums[j];
				int count=map[i].getOrDefault(dif,0);
				map[j].put(dif,
						map[j].getOrDefault(dif,0)+count+1
						);
				result+=count;
			}
		}

		return result;  
	}



}
