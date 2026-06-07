package Graph;

public class Problem_1061_DSU {

	class DSU{
		int[] node;
		public DSU()
		{
			node=new int[26];
			for(int i=0;i<26;i++)
			{
				node[i]=i;
			}
		}
		
		private void union(int a, int b)
		{
			int pa=find(a);
			int pb=find(b);
			if(pa<pb)
			{
				node[pb]=pa;
			}
			else if(pb<pa)
			{
				node[pa]=pb;
			}
		}
		
		int find(int x)
		{
			if(node[x]==x)
			{
				return x;
			}
			return find(node[x]);
		}
	}


	public String smallestEquivalentString(String s1, String s2, String baseStr) {

		DSU dsu=new DSU();
		
		int len=s1.length();
		
		for(int i=0;i<len;i++)
		{
			int a=s1.charAt(i)-'a';
			int b=s2.charAt(i)-'a';
			dsu.union(a,b);
		}
		
		StringBuilder result=new StringBuilder();
		for(char ch : baseStr.toCharArray())
		{
			int node=ch-'a';
			char bas=(char)(dsu.find(node)+'a');
			result.append(bas);
		}
		return result.toString();
	}



	public Problem_1061_DSU()
	{
		String s1 = "parker", s2 = "morris", baseStr = "parser";
		System.out.println(smallestEquivalentString(s1, s2, baseStr));
	}
}
