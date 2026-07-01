package Graph;
import java.util.*;
public class Problem_399 {
	
	class Pair
	{
		String v;
		double d;
		public Pair(String v,double d)
		{
			this.v=v;
			this.d=d;
		}
	}
	
	double dfs(Map<String,List<Pair>> adj,String src,String dis,List<String> visited,double ans)
	{
		visited.add(src);
		if(src.equals(dis))
		{
			return 1.0;
		}
		for(Pair child : adj.get(src))
		{
			String v=child.v;
			double d=child.d;
			if(!visited.contains(v))
			{
				ans=dfs(adj, v, dis, visited, ans);
				if(ans!=-1.0)
				{
					return ans*d;
				}
			}
			
		}
		
		return -1.0;
		
	}
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		
		Map<String,List<Pair>> adj=new HashMap<String,List<Pair>>();
		int n=values.length;
		for(int i=0;i<n;i++)
		{
			String u=equations.get(i).get(0);
			String v=equations.get(i).get(1);
			double d=values[i];
			adj.computeIfAbsent(u,key->new ArrayList<Pair>()).add(new Pair(v,d));
			adj.computeIfAbsent(v,key->new ArrayList<Pair>()).add(new Pair(u,1/d));
		}
		double[] result= new double[queries.size()];
		int i=0;
		for(List<String> querie : queries)
		{
			String u=querie.get(0);
			String d=querie.get(1);
			double ans=-1.0;
			if(adj.containsKey(u))
			{
				List<String> visited=new ArrayList<String>();
				ans=dfs(adj,u,d,visited,ans);
			}
			result[i]=ans;
			i++;
		}
		
		return result;
	}

	public Problem_399()
	{
		List<Integer> adj=new ArrayList<>();
		adj.add(10);
		adj.add(34);
		System.out.println("aad"=="aa");
	}
}
