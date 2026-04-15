package Problem;

public class Problem_221 {


	public int maximalSquare(char[][] matrix) {
		int result=0,
				m=matrix.length,
				n=matrix[0].length;

		int[][] dp=new int[m+1][n+1];

		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				//dp[i-1][j],dp[i][j-1],dp[i-1][j-1]
				 if(matrix[i-1][j-1]!='0')
					{
						int min=Math.min(dp[i-1][j],dp[i][j-1]);
						dp[i][j]=Math.min(min,dp[i-1][j-1])+(matrix[i-1][j-1]-'0');
	                    result=Math.max(result,dp[i][j]);
					}
				
			}
		}

		return result*result;
	}

	public Problem_221()
	{
		char[][] matrix = {
			    {'1','1'},
			    {'1','0'}
			};
		maximalSquare(matrix);
	}
}
