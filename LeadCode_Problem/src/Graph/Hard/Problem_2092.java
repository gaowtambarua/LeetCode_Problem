package Graph.Hard;
import java.util.*;
public class Problem_2092 {

	public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

		List<Integer> result=new ArrayList<Integer>();
		List<List<int[]>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<int[]>());
		}
		
		for(int[]meeting : meetings)
		{
			int x=meeting[0];
			int y=meeting[1];
			int time=meeting[2];
			
			adj.get(x).add(new int[]{y,time});
            adj.get(y).add(new int[]{x,time});
		}
		Queue<int[]> qu=new LinkedList<int[]>();
		qu.offer(new int[]{0,0});
		qu.offer(new int[]{firstPerson,0});
		
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		dist[firstPerson]=0;
		while(!qu.isEmpty())
		{
			int size=qu.size();
			while(size-->0)
			{
				int[] current=qu.poll();
				int u=current[0];
				int curentTime=current[1];
                if(curentTime>dist[u])
                {
                    continue;
                }
				for(int[] child : adj.get(u))
				{
					int v=child[0];
					int childTime=child[1];
					if(childTime<dist[v]&&childTime>=curentTime)
					{
						dist[v]=childTime;
						qu.offer(new int[]{v,childTime});
					}
				}
			}
		}
		
        for (int i = 0; i < n; i++) {

		    if (dist[i] != Integer.MAX_VALUE) {
		        result.add(i);
		    }
		}
		
	

		return result;
	}
}
