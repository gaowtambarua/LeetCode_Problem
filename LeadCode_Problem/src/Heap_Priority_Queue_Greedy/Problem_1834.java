package Heap_Priority_Queue_Greedy;

import java.util.*;

public class Problem_1834 {





	public int[] getOrder(int[][] tasks) {
		
		int n=tasks.length;
		int[][] temp=new int[n][3];
		for(int i=0;i<n;i++)
		{
			temp[i][0]=tasks[i][0];
			temp[i][1]=tasks[i][1];
			temp[i][2]=i;
		}
		Arrays.sort(temp,(a,b)->Integer.compare(a[0],b[0]));
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(
				(a,b)->{
					if(a[1]!=b[1])
					{
						return Integer.compare(a[1],b[1]);
					}
					return Integer.compare(a[2],b[2]);
				}
				);
		
		int[] result=new int[n];
		int j=0;
		int i=0;
		int d=temp[0][0];
		while(!pq.isEmpty()||i<n)
		{
			if(pq.isEmpty())
			{
				d=Math.max(d,temp[i][0]);
			}
			while(i<n && temp[i][0]<=d)
			{
				pq.offer(temp[i]);
				i++;
			}
			if(!pq.isEmpty())
			{
				int[] current=pq.poll();
				d=d+current[1];
				result[j]=current[2];
				j++;
			}
		}
		
		return result;
	}


	public Problem_1834()
	{
		int[][] ar={{44,41},{72,27},{37,51},{37,33}};
		getOrder(ar);

	}

}
