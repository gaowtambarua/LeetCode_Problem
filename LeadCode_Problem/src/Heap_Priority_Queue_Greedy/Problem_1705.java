package Heap_Priority_Queue_Greedy;
import java.util.*;
public class Problem_1705 {




	public int eatenApples(int[] apples, int[] days) {
        int n=apples.length;
        int day=0;
        int eat=0;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->Integer.compare(a[1],b[1]));
        while(!pq.isEmpty()|| day<n)
        {
            if(day<n && days[day]>0)
            {
                pq.offer(new int[]{apples[day],day+days[day]});
            }
            if(!pq.isEmpty())
            {
                int[] current=pq.poll();
                eat++;
                current[0]--;
                if(current[0]>0)
                {
                    pq.offer(current);
                }
            }
            day++;
            while(!pq.isEmpty() && pq.peek()[1]<=day)
            {
                pq.poll();
            }
        }
        return eat;
    }

}
