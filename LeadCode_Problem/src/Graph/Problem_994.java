package Graph;
import java.util.*;
public class Problem_994 {
	
	Queue<int[]> qu=new LinkedList<int[]>();

	
	int  bfs(int[][] grid,int m,int n)
	{
		int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
		int count=0;
		
		while(!qu.isEmpty())
		{
			int size=qu.size();
			while(size-->0)
			{
				int[] current=qu.poll();
				int i=current[0];
				int j=current[1];
		
				for(int[] d : dir)
				{
					int r=i+d[0];
					int c=j+d[1];
					
					if((r>=0 && r<m) && (c>=0 && c<n) && grid[r][c]==1)
					{
						qu.offer(new int[]{r,c});
						grid[r][c]=2;
					}
					
				}
			}
			count++;
		}
        return count-1;
	}
	public int orangesRotting(int[][] grid) {
		
		int m=grid.length;
		int n=grid[0].length;
        int result=0;
		for(int i=0;i<m;i++)
		{
			for (int j=0;j<n;j++)
			{
				if(grid[i][j]==2)
				{
					qu.offer(new int[]{i,j});
				}
			}
		}
		if(!qu.isEmpty())
		{
			result=bfs(grid,m,n);
		}
		for(int i=0;i<m;i++)
		{
			for (int j=0;j<n;j++)
			{
				if(grid[i][j]==1)
				{
					return -1;
				}
			}
		}
		
		
		return result;
	}

}
