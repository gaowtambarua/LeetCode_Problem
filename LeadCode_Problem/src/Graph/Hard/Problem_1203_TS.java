package Graph.Hard;
import java.util.*;
public class Problem_1203_TS {
	
	public List<Integer> topoSort(List<List<Integer>> itegrap,int[] itemIndegree,int size)
	{
		Queue<Integer> qu=new LinkedList<Integer>();
		for(int i=0;i<size;i++)
		{
			if(itemIndegree[i]==0)
			{
				qu.offer(i);
			}
		}
		List<Integer> topo=new ArrayList<Integer>();

		while(!qu.isEmpty())
		{
			int node=qu.poll();
			topo.add(node);
			for(int child : itegrap.get(node))
			{
				itemIndegree[child]--;
				if(itemIndegree[child]==0)
				{
					qu.add(child);
				}
			}
		}

		return topo.size()<size?new LinkedList<Integer>():topo;
	}


	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
		for(int i=0;i<n;i++)
		{
			if(group[i]==-1)
			{
				group[i]=m++;
			}
		}

		List<List<Integer>> itegrap=new ArrayList<>();
		int[] itemIndegree=new int[n];
		for(int i=0;i<n;i++)
		{
			itegrap.add(new ArrayList<>());
		}

		List<List<Integer>> groupgrap=new ArrayList<>();
		int[] groupIndegree=new int[m];
		for(int i=0;i<m;i++)
		{
			groupgrap.add(new ArrayList<>());
		}


		for(int i=0;i<n;i++)
		{
			for(int prev : beforeItems.get(i))
			{
				itegrap.get(prev).add(i);
				itemIndegree[i]++;

				if(group[i]!=group[prev])
				{
					groupgrap.get(group[prev]).add(group[i]);
					groupIndegree[group[i]]++;
				}
			}
		}

		//// step_TopoSOrt Call
		List<Integer> itemSort=topoSort(itegrap,itemIndegree,n);
		List<Integer> groupSort=topoSort(groupgrap,groupIndegree,m);
		if(itemSort.isEmpty()||groupSort.isEmpty())
		{
			return new int[0];
		}

		Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();

		for(int item : itemSort)
		{
			map.computeIfAbsent(group[item],
					key->new ArrayList<Integer>()
					).add(item);
		}

		List<Integer> ans=new ArrayList<Integer>();
		int[] result=new int[n];

		for(int grp : groupSort)
		{
			if(map.containsKey(grp))
			ans.addAll(map.get(grp));
		}
		for (int i = 0; i < n; i++)
		{
			result[i] = ans.get(i);
		}
		return result;
	}
	
	public Problem_1203_TS()
	{
		List<Integer> list=new ArrayList<Integer>();
		for(int i : list)
		{
			System.out.println(i);
		}
		System.out.println("Hellow");
	}
}
