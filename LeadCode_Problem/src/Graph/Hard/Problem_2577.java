package Graph.Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_2577 {

	int constance=(int)1e9;
	int[][] directions=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
	
	public int minimumTime(int[][] grid) {
		
		int n=grid.length;
		int m=grid[0].length;
		
		if(grid[0][1]>1&&grid[1][0]>1)
		{
			return -1;
		}
		
		int[][] result=new int[n][m];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(result[i],constance);
		}
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->Integer.compare(a[2],b[2]));
		pq.offer(new int[]{0,0,0});
		result[0][0]=0;
		boolean[][] visited=new boolean[n][m];
		
		while(!pq.isEmpty())
		{
			int[] current=pq.poll();
			int y=current[0];
			int x=current[1];
			int t=current[2];
			visited[y][x]=true;
			if(y==n-1&&x==m-1)
			{
				return t;
			}
			
			for(int[] dir : directions)
			{
				int y2=dir[0]+y;
				int x2=dir[1]+x;
				
				if((y2>=0&&y2<n && x2>=0 && x2<m) && (!visited[y2][x2]))
				{
					if((t+1>=grid[y2][x2]) && (t+1<result[y2][x2]) )
					{
						result[y2][x2]=t+1;
						pq.offer(new int[]{y2,x2,result[y2][x2]});
					}
					else if((t+1<grid[y2][x2]))
					{
						int dif=grid[y2][x2]-t;
						if(dif%2==0 && grid[y2][x2]+1<result[y2][x2])
						{
							result[y2][x2]=grid[y2][x2]+1;
							pq.offer(new int[]{y2,x2,result[y2][x2]});
						}
						else if(dif%2==1&&grid[y2][x2]<result[y2][x2])
						{
							result[y2][x2]=grid[y2][x2];
							pq.offer(new int[]{y2,x2,result[y2][x2]});
						}
					}
					
				}
				
				
			}
		}
		
		return result[n-1][m-1];
	}
	
	
	public Problem_2577()
	{
		int[][] a={{0,1,5},{0,2,10}};
		
		minimumTime(a);
	}

}
