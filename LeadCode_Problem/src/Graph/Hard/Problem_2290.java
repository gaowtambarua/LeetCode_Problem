package Graph.Hard;
import java.util.*;
public class Problem_2290 {
	
	int constance=(int)1e5;
	int[][] directions=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
	
	private int dijkstra(int[][]grid,int s1,int s2,int m,int n)
	{
		int[][] dist=new int[m][n];
		for(int i=0;i<m;i++)
		{
			Arrays.fill(dist[i], constance);
		}
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->Integer.compare(a[2],b[2]));
		pq.offer(new int[]{0,0,0});
		dist[0][0]=0;
		
		while(!pq.isEmpty())
		{
			int[] current=pq.poll();
			int x1=current[0];
			int y1=current[1];
			int w1=current[2];
			
			for(int[] direction: directions)
			{
				int x=direction[0]+x1;
				int y=direction[1]+y1;
				
				if(x>=0&&x<m && y>=0&&y<n)
				{
					if(dist[x1][y1]+grid[x][y]<dist[x][y])
					{
						dist[x][y]=dist[x1][y1]+grid[x][y];
						pq.offer(new int[]{x,y,dist[x][y]});
					}
				}
			}
		}
		
		
		return dist[m-1][n-1];
	}
	public int minimumObstacles(int[][] grid) {
		int m=grid.length;
		int n=grid[0].length;
		
		int s1=0;
		int s2=0;
		
		int result=dijkstra(grid,s1,s2,m,n);
				
		return result;
	}

}
