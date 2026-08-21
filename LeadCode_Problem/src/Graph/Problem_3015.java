package Graph;

import java.util.Arrays;

public class Problem_3015 {
	public int[] countOfPairs(int n, int x, int y) {
		int[] result=new int[n];
		int INF=(int)1e9;
		int[][] dist=new int[n+1][n+1];
		for(int i=0;i<=n;i++)
		{
			Arrays.fill(dist[i], INF);
			dist[i][i]=0;
		}
		for(int i=1;i<n;i++)
		{
			dist[i][i+1]=1;
			dist[i+1][i]=1;
		}
		dist[x][y]=1;
		dist[y][x]=1;
		
		for(int k=1;k<=n;k++)
		{
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					if(i==j)
					{
						continue;
					}
					else
					{
						dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
					}
				}
			}
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i==j)
				{
					continue;
				}
				int val=dist[i][j];
				result[val-1]++;
			}
		}
		
		return result;
	}
}
