package Graph;
import java.util.*;
public class Problem_1976 {
	
	
	int dijkstra(List<List<int[]>> adj,int s,int d)
    {
        int mod=(int) 1e9+7;

        long[] result=new long[d];
        long[] dist=new long[d];
        Arrays.fill(dist,Long.MAX_VALUE);

        PriorityQueue<long[]> pq=new PriorityQueue<long[]>((a,b)->Long.compare(a[1],b[1]));
        dist[s]=0;
        pq.offer(new long[]{0,0});
        result[s]=1;

        while(!pq.isEmpty())
        {
            long[] cur=pq.poll();
            int u=(int)cur[0];
            long t=cur[1];

            for(int[] child : adj.get(u))
            {
                int v=(int)child[0];
                long t2=child[1];

                if(t+t2<dist[v])
                {
                    dist[v]=(t+t2);
                    result[v]=result[u];
                    pq.offer(new long[] {v,dist[v]});
                }
                else if(t+t2==dist[v])
                {
                     result[v]=(result[v]+result[u])%mod;
                }

            }

        }

        return (int)result[d-1];
    }


    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<int[]>());
        }

        for(int[] road : roads)
        {
            int u=road[0];
            int v=road[1];
            int t=road[2];
            adj.get(u).add(new int[]{v,t});
            adj.get(v).add(new int[]{u,t});
        }

        return dijkstra(adj,0,n);
    }
	
	
}
