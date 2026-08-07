package Graph.Hard;
import java.util.*;
public class Problem_2050_Topo_Logical_sort {

	int topSort(int n,List<List<Integer>> adj,int[] time,int[] indegree)
	{
		Queue<Integer> qu=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==0)
			{
				qu.offer(i);
			}
		}
		int[] findResult=Arrays.copyOf(time,n);
		int result=0;
		while(!qu.isEmpty())
		{
			int u=qu.poll();
			result = Math.max(result, findResult[u]);
			for(int child : adj.get(u))
			{
				int temp=findResult[u]+time[child];
				findResult[child]=Math.max(findResult[child],temp);
				indegree[child]--;
				if(indegree[child]==0)
				{
					qu.offer(child);
				}
			}
		}
		return result;
	}

	public int minimumTime(int n, int[][] relations, int[] time) {

		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}
		int[] indegree=new int[n];
		for(int[] edge : relations)
		{
			int u=edge[0]-1;
			int v=edge[1]-1;
			adj.get(u).add(v);
			indegree[v]++;
		}

		return topSort(n,adj,time,indegree);
	}

	public Problem_2050_Topo_Logical_sort()
	{
		int [][] relation={{2,1}};
		int[] time={10000,10000};
		int n=2;

		System.out.println(minimumTime(n, relation, time));
	}
}
