package Graph.Hard;
import java.util.*;
public class Problem_514_dijkstra {
	
	
	private int minimumStep(int ringIdx,int keyIdx,int size)
	{
		int clockWise=Math.abs(ringIdx-keyIdx);
		int anticlockWise=size-clockWise;
		return Math.min(clockWise, anticlockWise);
	}

	public int findRotateSteps(String ring, String key) {
		
		int size=ring.length();
		int m=key.length();
		Map<Character,List<Integer>> adj=new HashMap<Character,List<Integer>>();
		for(int i=0;i<size;i++)
		{
			adj.computeIfAbsent(ring.charAt(i),k->new ArrayList<Integer>()).add(i);
		}
		
		boolean[][] visited=new boolean[size][m];
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
		pq.offer(new int[]{0,0,0});
		int result=0;
		while(!pq.isEmpty())
		{
			int[] current=pq.poll();
			int u=current[1];
			if(u==m)
			{
				result=current[2];
				break;
			}
			if(!visited[current[0]][current[1]])
			{
				visited[current[0]][current[1]]=true;
				char ch=key.charAt(u);
				if(adj.containsKey(ch))
				{
					for(int child : adj.get(ch))
					{
						int step=minimumStep(current[0],child,size);
						pq.offer(new int[]{child,u+1,step+current[2]});
					}
				}
			}
		}
		
		return result+m;
	}
	
	public Problem_514_dijkstra()
	{
		findRotateSteps("ring","ad");
		System.out.println("Hellow");
	}
}
