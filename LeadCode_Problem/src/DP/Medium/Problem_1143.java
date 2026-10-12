package DP.Medium;
import java.util.*;
public class Problem_1143 {

	int m;
	int n;
	int[][] dp;
	int solve(String text1,String text2,int i,int j)
	{
		if(i>=m||j>=n)
		{
			return 0;
		}
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
		}
		if(text1.charAt(i)==text2.charAt(j))
		{
			return dp[i][j]=1+solve(text1,text2,i+1,j+1);
		}
		int a=solve(text1,text2,i+1,j);
		int b=solve(text1,text2,i,j+1);
		
		return dp[i][j]=Math.max(a,b);
		
	}

	public int longestCommonSubsequence(String text1, String text2) {
		
		m=text1.length();
		n=text2.length();
		dp=new int[m][n];
		
		for(int i=0;i<m;i++)
		{
			Arrays.fill(dp[i],-1);
		}
		
		return solve(text1,text2,0,0);
	}

}
