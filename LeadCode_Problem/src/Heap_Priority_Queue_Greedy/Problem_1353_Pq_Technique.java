package Heap_Priority_Queue_Greedy;

import java.util.*;

public class Problem_1353_Pq_Technique {

	public int maxEvents(int[][] events) {
        int n=events.length;
			
			int i=0;
			int count=0;
			Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
			int day=events[0][0];
			PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->Integer.compare(a[1],b[1]));
			while(i<n || !pq.isEmpty())
			{
				
				if(pq.isEmpty())
				{
					day=events[i][0];
				}
				while(i<n && events[i][0]==day)
				{
					pq.offer(events[i]);
					i++;
				}
				if(!pq.isEmpty())
				{
					pq.poll();
					count++;
				}
				day++;
	            while(!pq.isEmpty()&&pq.peek()[1]<day)
	            {
	                pq.poll();
	            }
			}
		
	        return count;
   }

public Problem_1353_Pq_Technique()
{
	PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->Integer.compare(a[0],b[0]));
	pq.offer(new int[]{3,4});
	pq.offer(new int[]{2,7});
	pq.offer(new int[]{1,3});
	System.out.println(Arrays.toString(pq.poll()));
	System.out.println(Arrays.toString(pq.poll()));
	System.out.println(Arrays.toString(pq.poll()));
}
}
