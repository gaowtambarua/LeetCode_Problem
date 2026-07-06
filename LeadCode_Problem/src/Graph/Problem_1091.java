package Graph;
import java.util.*;
public class Problem_1091 {

	public int shortestPathBinaryMatrix(int[][] grid) {
	       int[][] dir={
	                        {0,1},
	                        {0,-1},

	                        {-1,-1},
	                        {-1,1},
	                        {-1,0},
	                        
	                        {1,1},
	                        {1,-1},
	                        {1,0},
	                        
	                   };
			int n=grid.length;
			if(grid[0][0]!=0||grid[n-1][n-1]!=0)
			{
				return -1;
			}
			Queue<int[]> qu=new LinkedList<int[]>();
			qu.offer(new int[]{0,0});
			grid[0][0]=1;
			int len=0;
			while(!qu.isEmpty())
			{
				int size=qu.size();
				while(size>0)
				{
					int[] cur=qu.poll();
					for(int[] curDir : dir)
					{
						int x=cur[0]+curDir[0];
						int y=cur[1]+curDir[1];
						if(cur[0]==n-1&&cur[1]==n-1)
						{
	                        len=len+1;
							return len;
						}
						if(x>=0&&x<n && y>=0 && y<n&&grid[x][y]==0)
						{
							qu.offer(new int[]{x,y});
							grid[x][y]=1;
						}
					}
					size--;
				}
				len++;
				
			}
			return -1; 
	    }


	public Problem_1091()
	{
		int [][] a={{0}};
		
		System.out.println(shortestPathBinaryMatrix(a));
	}
}
