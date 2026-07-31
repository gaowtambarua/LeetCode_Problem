package Graph.Hard;

import java.util.*;
public class Problem_332 {

	public List<String> findItinerary(List<List<String>> tickets) {
	       LinkedList<String> result=new LinkedList<String>();
			
			Map<String,PriorityQueue<String>> grp=new HashMap<String,PriorityQueue<String>>();
			for(List<String> ticket: tickets)
			{
				String u=ticket.get(0);
				String v=ticket.get(1);
				grp.computeIfAbsent(u,key->new PriorityQueue<String>()).add(v);
			}
			
			dfs(result,grp,"JFK");
			
			return result; 
	    }
	private void dfs(LinkedList<String> result,Map<String,PriorityQueue<String>> grp,String node)
	{
		while(grp.get(node)!=null&&!grp.get(node).isEmpty())
		{
			String current=grp.get(node).poll();
			dfs(result,grp,current);
		}
		result.addFirst(node);
	}


	public Problem_332()
	{
		List<List<String>> tickets=new ArrayList();
		tickets.add(Arrays.asList("JFK","ATL"));
		tickets.add(Arrays.asList("JFK","SFO"));
		tickets.add(Arrays.asList("SFO","JFK"));
		
		
		System.out.println(findItinerary(tickets));
	}
}
