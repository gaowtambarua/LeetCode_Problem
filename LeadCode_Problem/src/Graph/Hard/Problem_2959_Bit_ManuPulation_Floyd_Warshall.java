package Graph.Hard;

import java.util.Arrays;

public class Problem_2959_Bit_ManuPulation_Floyd_Warshall {

	public int numberOfSets(int n, int maxDistance, int[][] roads) {
		int count=0;
		int INF=(int)1e9;
		
		for(int set=0;set<Math.pow(2,n);set++)
		{
			int[][] dist=new int[n][n];
			for(int i=0;i<n;i++)
			{
				Arrays.fill(dist[i],INF);
				dist[i][i]=0;
			}
			
			for(int[] road: roads)
			{
				int u=road[0];
				int v=road[1];
				int cost=road[2];
				if( ( (set>>u)  &1)==1 &&( (set>>v) &1 )==1)
				{
					dist[u][v]=Math.min(dist[u][v],cost);
					dist[v][u]=Math.min(dist[v][u],cost);
				}
			}
			
			 for(int k=0;k<n;k++)// intermediate
		        {
		        	for(int i=0;i<n;i++)// source
		        	{
		        		for(int j=0;j<n;j++)// destination
		        		{
		        			dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
		        		}
		        	}
		        }
			
			
			boolean chk=true;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if( ( (set>>i)  &1)==1 &&( (set>>j) &1 )==1)
					{
						if(dist[i][j]>maxDistance)
						{
							chk=false;
							break;
						}
					}
				}
				if(!chk)
				{
					break;
				}
			}
			if(chk)
			{
				count++;
			}
		}
		
		
		return count;
	}
}
