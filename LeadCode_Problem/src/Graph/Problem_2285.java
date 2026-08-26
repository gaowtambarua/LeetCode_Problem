package Graph;
import java.util.*;
public class Problem_2285 {

	public long maximumImportance(int n, int[][] roads) {
		int[] indegree=new int[n];
		for(int[] road : roads)
		{
			int u=road[0];
			int v=road[1];
			indegree[u]++;
			indegree[v]++;
		}
		Arrays.sort(indegree);
		long result=0;
		for(int i=0;i<n;i++)
		{
			result+=(long)(i+1)*indegree[i];
		}
		return result;
	}

	public Problem_2285()
	{
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>();
	}
}
