package Graph;
import java.util.*;
public class Problem_1557 {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		int[] indegree=new int[n+1];
		for(List<Integer> edge : edges)
		{
			int v=edge.get(1);
			indegree[v]++;
		}
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==0)
			{
				result.add(i);
			}
		}
		return result;
	}


	public Problem_1557()
	{

	}
}
