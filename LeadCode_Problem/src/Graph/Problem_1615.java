package Graph;
import java.util.*;
public class Problem_1615 {

	public int maximalNetworkRank(int n, int[][] roads) {
		HashMap<Integer,List<Integer>> adj=new HashMap<Integer,List<Integer>>();
		int result=0;
		for(int[] road: roads)
		{
			int u=road[0];
			int v=road[1];
			adj.computeIfAbsent(u,key->new ArrayList<Integer>()).add(v);
			adj.computeIfAbsent(v,key->new ArrayList<Integer>()).add(u);
		}
		
		for(int i=0;i<n-1;i++)
		{
			List<Integer> listU=adj.get(i);
			int listUsize=0;
			if(listU!=null)
			{
				listUsize=listU.size();
			}
			for(int j=i+1;j<n;j++)
			{
				List<Integer> listV=adj.get(j);
				int listVsize=0;
				if(listV!=null)
				{
					listVsize=listV.size();
					listVsize=listV.contains(i)?listVsize-1:listVsize;
				}
				result=Math.max(result,listUsize+listVsize);
			}
		}
		
		return result;
	}

	public Problem_1615()
	{
		int[][] roads={{0,1},{0,3},{1,2},{1,3}};
		int n=4;
		System.out.println(maximalNetworkRank(n, roads));
	}
}
