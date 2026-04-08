package Problem;

import java.util.*;

public class Problem_735 {
	public int[] asteroidCollision(int[] asteroids) {
		int n=asteroids.length;
		Stack<Integer> idx=new Stack<Integer>();
		for(int i=0;i<n;i++)
		{
			if(asteroids[i]>0)
			{
				idx.push(i);
			}
			else
			{
				while(!idx.isEmpty()&&asteroids[i]<0)
				{
					int top=idx.peek();
					int size=asteroids[top]+asteroids[i];
					if(size>0)
					{
						asteroids[i]=0;
					}
					else if(size<0)
					{
						asteroids[top]=0;
						idx.pop();
					}
					else
					{
						asteroids[i]=0;
						asteroids[top]=0;
					}
				}
					
			}
		}
		List<Integer> list=new ArrayList<Integer>();
		for(int val : asteroids)
		{
			if(val!=0)
			{
				list.add(val);
			}
		}
		int[] result=new int[list.size()];
		int i=0;
		for(int val : list)
		{
			result[i]=val;
			i++;
		}
 		return result;
	}
	public Problem_735()
	{
		int[] asteroids={5,10,-5};
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}
}
