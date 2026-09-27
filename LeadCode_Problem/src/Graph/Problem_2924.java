package Graph;

public class Problem_2924 {

	public int findChampion(int n, int[][] edges) {
		int champion=-1;
		int[] indegree=new int[n];
		for(int[] edge : edges)
		{
			int u=edge[0];
			int v=edge[1];
			indegree[v]++;
		}
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==0)
			{
				champion=i;
				count++;
			}
			if(count>1)
			{
				return -1;
			}
		}
		
		return champion;
	}

	public Problem_2924()
	{

	}
}
