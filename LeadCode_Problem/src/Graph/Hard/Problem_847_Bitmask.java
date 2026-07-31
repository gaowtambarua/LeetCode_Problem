package Graph.Hard;
import java.util.*;
public class Problem_847_Bitmask {
	
	public int shortestPathLength(int[][] graph) {
		int n=graph.length;
		if(n<=1)
		{
			return 0;
		}
		Queue<int[]> qu=new LinkedList<int[]>();
		int tergetBitmask=(1<<n)-1;
		boolean[][] visited=new boolean[n][tergetBitmask+1];
		for(int i=0;i<n;i++)
		{
			for(int node : graph[i])
			{
				int currentbitmask=1<<i|1<<node;
				qu.add(new int[]{node,currentbitmask});
				visited[node][currentbitmask]=true;
			}
			
		}
		int path=1;
		while(!qu.isEmpty())
		{
			int size=qu.size();
			
			while(size-->0)
			{
				int[] current=qu.poll();
				int curnode=current[0];
				int curmask=current[1];
				if(curmask==curmask)
				{
					return path;
				}
				for(int childNode : graph[curnode])
				{
					int mask=1<<childNode|curmask;
					if(!visited[childNode][mask])
					{
						visited[childNode][mask]=true;
						qu.add(new int[]{childNode,mask});
					}
				}
			}
			path++;
		}
		
		return n;
	}
	
	public Problem_847_Bitmask()
	{
//		int[][] graph = {
//			    {1, 2},    // 0
//			    {0, 3, 4}, // 1
//			    {0, 5},    // 2
//			    {1},       // 3
//			    {1, 6},    // 4
//			    {2},       // 5
//			    {4}        // 6
//			};
		int[][] graph ={{1},{0}};
		System.out.println(shortestPathLength(graph));
	}
}
