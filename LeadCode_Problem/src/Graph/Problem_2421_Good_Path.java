package Graph;
import java.util.*;
public class Problem_2421_Good_Path {
	
	
	class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n)
        {
            parent=new int[n];
            rank=new int[n];

            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
        }

        int find(int x)
        {
            if(parent[x]==x)
            {
                return x;
            }
            return find(parent[x]);
        }

        void union(int a,int b)
        {
            int pa=find(a);
            int pb=find(b);

            if(rank[pa]>rank[pb])
            {
                parent[pb]=pa;
            }
            else if(rank[pa]<rank[pb])
            {
                parent[pa]=pb;
            }
            else
            {
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n=vals.length;
        int result=n;
        Map<Integer,List<Integer>> value_to_node=new TreeMap<Integer,List<Integer>>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            value_to_node.computeIfAbsent(vals[i],key->new ArrayList<Integer>()).add(i);
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        DSU dsu=new DSU(n);
        for(Map.Entry<Integer,List<Integer>> entry : value_to_node.entrySet())
        {
            List<Integer> nodes=entry.getValue();
            for(int node : nodes)
            {
                for(int child : adj.get(node))
                {
                    if(visited[child])
                    {
                        dsu.union(node,child);
                    }
                }
                visited[node]=true;
            }
            PriorityQueue<Integer> parents=new PriorityQueue<Integer>();
             for(int node : nodes)
             {
                parents.add(dsu.find(node));
             }

             int preNode=parents.poll();
             int count=1;
             while(!parents.isEmpty())
             {
                int nextNode=parents.poll();
                if(preNode==nextNode)
                {
                    count++;
                }
                else
                {
                    result+=count*(count-1)/2;
                    preNode=nextNode;
                    count=1;
                }
             }
             result+=count*(count-1)/2;
        }

        return result;
    }



	public Problem_2421_Good_Path()
	{
		
		 Map<Integer, String> map = new HashMap<>();

	        map.put(100, "A");
	        map.put(2, "B");
	        map.put(55, "C");
	        map.put(1, "D");
	        map.put(999, "E");
	        map.put(23, "F");

	        for(Map.Entry<Integer,String> entry : map.entrySet())
	        {
	            System.out.println(entry.getKey() + " -> " + entry.getValue());
	        }
	}
}
