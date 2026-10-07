package Graph;

public class Problem_419 {
	
	
	private void dfs(int i,int j,char[][] board,int m,int n)
	{
		board[i][j]='.';
		
		int[][] dir={{0,1},{1,0}};
		for(int[] d : dir)
		{
			int i_=i+d[0];
			int j_=j+d[1];
			if((i_<m && j_<n) && board[i_][j_]=='X')
			{
				dfs(i_, j_, board, m, n);
			}
		}
	}


	public int countBattleships(char[][] board) {
		int m=board.length;
		int n=board[0].length;
		int count=0;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j]=='X')
				{
					dfs(i,j,board,m,n);
					count++;
				}
			}
		}
		
		
		
		return count;
	}

}
