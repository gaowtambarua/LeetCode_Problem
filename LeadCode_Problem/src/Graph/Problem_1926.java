package Graph;
import java.util.*;
public class Problem_1926 {
	
	public int nearesExit(char[][] maze, int[] entrance)
	{
//		{'+','+',   '.',   '+'},
		
//		{'.','.',   '.',   '+'},
		
//		{'+','+',   '+',   '.'}
		
		int m=maze.length;
		int n=maze[0].length;
		
		Queue<int[]> qu=new LinkedList<>();
		qu.offer(new int[]{entrance[0],entrance[1],0});
		
		int[][] dir={
				{-1,0},
				{1,0},
				{0,-1},
				{0,1},
		};
		
		boolean[][] visited=new boolean[m][n];
		
		while(!qu.isEmpty())
		{
			int[] present=qu.poll();
			int pr=present[0];
			int pc=present[1];
			int count=present[2];
			
			if((pr==0||pr==m-1||pc==0||pc==n-1)&&(pr!=entrance[0]||pc!=entrance[1]))
			{
				return count;
			}
			
			for(int[] d: dir)
			{
				int dr=d[0]+pr;
				int dc=d[1]+pc;
				
				if((dr>=0&&dr<m&&dc>=0&&dc<n) && (maze[dr][dc]=='.'&& !visited [dr][dc]) )
				{
					qu.offer(new int[]{dr,dc,count+1});
					visited[dr][dc]=true;
				}
			}
			
		}
		
		
		return -1;
	}
	
	public Problem_1926()
	{
		char[][] maze={
				
				{'+','+','.','+'},
				{'.','.','.','+'},
				{'+','+','+','.'}
				
		};
		
		
		int[] entrannce=new int[]{1,2};
		
		
		
		System.out.println(nearesExit(maze, entrannce));
	}
}
