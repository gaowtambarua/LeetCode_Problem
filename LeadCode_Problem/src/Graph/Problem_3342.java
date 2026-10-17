package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_3342 {
public int minTimeToReach(int[][] moveTime) {
		
		int n=moveTime.length;
		int m=moveTime[0].length;
		
		int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
		
		int[][] dist=new int[n][m];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(dist[i],Integer.MAX_VALUE);
		}
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->Integer.compare(a[2],b[2]));
		pq.offer(new int[]{0,0,0});
		dist[0][0]=0;
		
		while(!pq.isEmpty())
		{
			int cur[]=pq.poll();
			int r=cur[0];
			int c=cur[1];
			int curTime=cur[2];
			
			if(r==n-1 && c==m-1)
			{
				return curTime;
			}
			
			for(int[] dir : directions)
			{
				int i=dir[0]+r;
				int j=dir[1]+c;
				if(i>=0&&i<n && j>=0 && j<m)
				{
					int step=i+j;
					int moveSecond=(step%2==0)? 2 : 1;
					int wait=Math.max(moveTime[i][j]-curTime,0);
					int ariveTIme=curTime+wait+moveSecond;
					if(ariveTIme<dist[i][j])
					{
						dist[i][j]=ariveTIme;
						pq.offer(new int[]{i,j,ariveTIme});
					}
				}
			}
			
		}
		
		return dist[n-1][m-1];
	}
}
