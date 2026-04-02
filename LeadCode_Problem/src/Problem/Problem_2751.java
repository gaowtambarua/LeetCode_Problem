package Problem;

import java.util.*;

public class Problem_2751 {

	public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
		
		int n=positions.length;
		Integer [] idx=new Integer [n];
		for(int i=0;i<n;i++)
		{
			idx[i]=i;
		}
		Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);
		Stack<Integer> stack=new Stack<Integer>();
		for(int i : idx)
		{
			if(directions.charAt(i)=='R')
			{
				stack.push(i);
			}
			else
			{
				while(!stack.isEmpty()&& healths[i]>0)
				{
					int top=stack.peek();
					if(healths[top]<healths[i])
					{
						stack.pop();
						healths[i]--;
						healths[top]=0;
					}
					else if(healths[top]>healths[i])
					{
						
						healths[top]--;
						healths[i]=0;
					}
					else
					{
						stack.pop();
						healths[top]=0;
						healths[i]=0;
					}
				}
			}
		}
		
		List<Integer> result=new ArrayList<Integer>();
		for(int h : healths)
		{
			if(h>0)
			{
				result.add(h);
			}
		}
		
		return result;
	}



	public Problem_2751()
	{
		int [][] a={
				{3,0},	
				{5,1},
				{2,2},
				{6,3},
		};
//        		[2, 2]
//				[3, 0]
//				[5, 1]
//				[6, 3]

		int [] positions={3,5,2,6};
		int [] h={10,10,15,12};
		String d="RLRL";
		survivedRobotsHealths(positions, h, d);
	}
}
