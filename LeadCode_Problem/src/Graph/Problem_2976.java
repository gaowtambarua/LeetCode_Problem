package Graph;

import java.util.Arrays;

public class Problem_2976 {

	public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		
		int[][] dist=new int[26][26];
		int INF=(int)1e9;
		for(int i=0;i<26;i++)
		{
			Arrays.fill(dist[i], INF);
			dist[i][i]=0;
		}
		
		int size=original.length;
		for(int j=0;j<size;j++)
		{
			int u=original[j]-'a';
			int v=changed[j]-'a';
			int c=cost[j];
			dist[u][v]=Math.min(dist[u][v],c);
		}
		
		for(int k=0;k<26;k++)
		{
			for(int i=0;i<26;i++)
			{
				for(int j=0;j<26;j++)
				{
					if(dist[i][k]!=INF&&dist[k][j]!=INF)
					{
						dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
					}
				}
			}
		}
		
		long result=0;
		size=source.length();
		for(int i=0;i<size;i++)
		{
			int u=source.charAt(i)-'a';
			int v=target.charAt(i)-'a';
			if(dist[u][v]==INF)
			{
				return -1;
			}
			result=result+dist[u][v];
		}
		
		return result;
	}

	public Problem_2976()
	{
		System.out.println(Math.pow(10,6));
	}
}
