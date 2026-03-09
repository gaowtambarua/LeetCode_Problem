package Mattrix;
import java.util.*;
public class Game_of_Life {

	public void gameOfLife(int[][] board) {

		int m=board.length,n=board[0].length;

		// Direction for 8 naighbors
		int [][] dirs={
				{-1,-1},{-1,0},{-1,1},
				{0,-1},        {0,1},
				{1,-1}, {1,0}, {1,1},
		};


		// Step 1: Apply rules using temporary states
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int liveNightbors=0;

				for(int[] d: dirs)
				{
					int x=i-d[0];
					int y=j-d[1];
					if(x>=0&&x<m && y>=0&&y<n)
					{
						if(board[x][y]==1||board[x][y]==-1)
						{
							liveNightbors++;
						}
					}
				}
				if(board[i][j]==1)
				{
					if(liveNightbors<2||liveNightbors>3)
					{
						board[i][j]=-1;
					}
				}
				else
				{
					if(liveNightbors==3)
					{
						board[i][j]=2;
					}
				}
			}
		}
		
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j]==-1)
				{
					board[i][j]=0;
				}
				else if(board[i][j]==2)
				{
					board[i][j]=1;
				}
			}
		}

	}
	public Game_of_Life()
	{
		int[][] board={
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0},
		};
		gameOfLife(board);
	}
}
