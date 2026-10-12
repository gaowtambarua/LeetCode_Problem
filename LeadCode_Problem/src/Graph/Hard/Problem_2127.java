package Graph.Hard;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.util.*;
public class Problem_2127 {



	public int maximumInvitations(int[] favorite) {
		
		int n=favorite.length;
		
		Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<n;i++)
		{
			int u=i;
			int v=favorite[i];
			
			map.computeIfAbsent(v,key->new ArrayList<Integer>()).add(u);
		}
		
		int longestCycle=0;
		int happyCycle=0;
		
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				int curNode=i;
				int curNodeCount=0;
				Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
				while(!visited[curNode])
				{
					visited[curNode]=true;
					mp.put(curNode,curNodeCount);
					
					int nextNode=favorite[curNode];
					curNodeCount+=1;
					
					if(mp.containsKey(nextNode))
					{
						int cyleLength=curNodeCount-mp.get(nextNode);
						longestCycle=Math.max(longestCycle,cyleLength);
						if(cyleLength==2)
						{
							boolean[] visit=new boolean[n];
							visit[curNode]=true;
                            visit[nextNode]=true;
							happyCycle+=2+bfs(curNode,map,visit)+bfs(nextNode,map,visit);
						}
					}
					curNode=nextNode;
				}
			}
		}
		
		
		return Math.max(happyCycle,longestCycle);
		
	}
	
	private int bfs(int node,Map<Integer,List<Integer>> adj,boolean[] visited)
	{
		
		visited[node]=true;
		int maxDistance=0;
		Queue<int[]> qu=new LinkedList<int[]>();
		qu.offer(new int[]{node,0});
		while(!qu.isEmpty())
		{
			int[] currentNode=qu.poll();
			int u=currentNode[0];
			int dist=currentNode[1];
			if(adj.containsKey(u))
			{
				for(int v : adj.get(u))
				{
					if(!visited[v])
					{
						visited[v]=true;
						qu.offer(new int[]{v,dist+1});
						maxDistance=Math.max(maxDistance,dist+1);
					}
				}
			}
		}
		
		return maxDistance;
	}



}
