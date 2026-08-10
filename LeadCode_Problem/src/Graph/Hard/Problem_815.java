package Graph.Hard;
import java.util.*;
public class Problem_815 {

	public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
        {
            return 0;
        }
		int routeSize=routes.length;
		Map<Integer,List<Integer>> adj=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<routeSize;i++)
		{
			for(int travel : routes[i])
			{
				adj.computeIfAbsent(travel,key->new ArrayList<Integer>()).add(i);
			}
		}
		Queue<Integer> qu=new LinkedList<Integer>();
		if(adj.containsKey(source))
		{
			qu.addAll(adj.get(source));
		}
		boolean[] visited=new boolean[routeSize];
		int count=0;
		while(!qu.isEmpty())
		{
			int quSize=qu.size();
			count++;
			while(quSize-->0)
			{
				int bus=qu.poll();
				visited[bus]=true;
				for(int travel : routes[bus])
				{
					if(adj.containsKey(travel))
					{
						for(int child : adj.get(travel))
						{
							if(!visited[child])
							{
								qu.offer(child);
                                visited[child]=true;
							}
							if(travel==target)
							{
								return count;
							}
						}
					}
				}
			}
		}
		return -1;
	}

	public Problem_815()
	{

	}
}
