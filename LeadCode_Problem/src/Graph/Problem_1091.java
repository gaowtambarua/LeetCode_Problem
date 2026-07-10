package Graph;
import java.util.*;
public class Problem_1091 {
	/////////////////////////////// its bfs
	//	public int shortestPathBinaryMatrix(int[][] grid) {
	//	       int[][] dir={
	//	                        {0,1},
	//	                        {0,-1},
	//
	//	                        {-1,-1},
	//	                        {-1,1},
	//	                        {-1,0},
	//	                        
	//	                        {1,1},
	//	                        {1,-1},
	//	                        {1,0},
	//	                        
	//	                   };
	//			int n=grid.length;
	//			if(grid[0][0]!=0||grid[n-1][n-1]!=0)
	//			{
	//				return -1;
	//			}
	//			Queue<int[]> qu=new LinkedList<int[]>();
	//			qu.offer(new int[]{0,0});
	//			grid[0][0]=1;
	//			int len=0;
	//			while(!qu.isEmpty())
	//			{
	//				int size=qu.size();
	//				while(size>0)
	//				{
	//					int[] cur=qu.poll();
	//					for(int[] curDir : dir)
	//					{
	//						int x=cur[0]+curDir[0];
	//						int y=cur[1]+curDir[1];
	//						if(cur[0]==n-1&&cur[1]==n-1)
	//						{
	//	                        len=len+1;
	//							return len;
	//						}
	//						if(x>=0&&x<n && y>=0 && y<n&&grid[x][y]==0)
	//						{
	//							qu.offer(new int[]{x,y});
	//							grid[x][y]=1;
	//						}
	//					}
	//					size--;
	//				}
	//				len++;
	//				
	//			}
	//			return -1; 
	//	    }


	//////////////////// using  Dijkstra O((V + E) log V)

	public int shortestPathBinaryMatrix(int[][] grid) {
		int n=grid.length;

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

		if(grid[0][0]!=0||grid[n-1][n-1]!=0)
		{
			return -1;
		}

		int[][] dist=new int[n][n];
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
		pq.offer(new int[]{0,0,1});
		dist[0][0]=1;
		grid[0][0]=1;
		while(!pq.isEmpty())
		{
			int[]  cur=pq.poll();
			if(cur[0]==n-1&&cur[1]==n-1)
			{
				return dist[n-1][n-1];
			}
			for(int[] curDir : dir)
			{
				int x=cur[0]+curDir[0];
				int y=cur[1]+curDir[1];
				if(x>=0&&x<n && y>=0 && y<n&&grid[x][y]==0)
				{
					pq.offer(new int[]{x,y,cur[2]+1});
					grid[x][y]=1;
					dist[x][y]=cur[2]+1;
				}

			}
		}

		return -1;
	}


	public Problem_1091()
	{
		int [][] a={{0}};

		System.out.println(shortestPathBinaryMatrix(a));
	}
}
