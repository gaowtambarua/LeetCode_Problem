package Graph.Hard;
import java.util.*;
import java.util.Arrays;

public class Problem_1368 {

	public int minCost(int[][] grid) {
		
		int m=grid.length;
		int n=grid[0].length;
		
		int[][] result=new int[m][n];
		int[][] dir=new int[][]{
				{0,1},
				{0,-1},
				{1,0},
				{-1,0}
			};
		
		for(int i=0;i<m;i++)
		{
			Arrays.fill(result[i],(int)1e9);
		}
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->Integer.compare(a[2],b[2]));
		pq.offer(new int[]{0,0,0});
		result[0][0]=0;
		boolean[][] visited=new boolean[m][n];
		
		while(!pq.isEmpty())
		{
			int[] current=pq.poll();
			int x=current[0];
			int y=current[1];
			int w=current[2];
			if( (x==m-1) && (y==n-1) )
			{
				return result[x][y];
			}
			visited[x][y]=true;
			for(int i=0;i<4;i++)
			{
				
				int dx=dir[i][0];
				int dy=dir[i][1];
				dx=x+dx;
				dy=y+dy;
				if( (dx>=0&&dx<m)&&(dy>=0&&dy<n) && !visited[dx][dy] )
				{
					int gridDir=grid[x][y];
					int cost=(gridDir-1)==i?0:1;
					cost=w+cost;
					if(cost<result[dx][dy])
					{
						result[dx][dy]=cost;
						pq.offer(new int[]{dx,dy,cost});
					}
				}
			}
		}
		
		return result[m-1][n-1];
	}
}
