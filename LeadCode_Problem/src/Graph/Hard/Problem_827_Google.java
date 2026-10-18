package Graph.Hard;
import java.util.*;
public class Problem_827_Google {
	 int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

	    private int dfs(int[][] grid,int n,int id,int r ,int c)
	    {        
	        int size=1;
	        grid[r][c]=id;
	        for(int[] dir : directions)
	        {
	            int i=dir[0]+r;
	            int j=dir[1]+c;

	            if(i>=0 && i<n && j>=0 && j<n && grid[i][j]==1)
	            {
	                size+=dfs(grid,n,id,i,j);
	            }
	        }
	        return size;
	    }

	    private int findLargeIsland(int[][] grid, int r,int c,int n,Map<Integer,Integer> mp)
	    {
	        Set<Integer> set=new HashSet<Integer>();
	        for(int[] dir : directions)
	        {
	            int i=dir[0]+r;
	            int j=dir[1]+c;

	            if(i>=0 && i<n && j>=0 && j<n && grid[i][j]!=0)
	            {
	                set.add(grid[i][j]);
	            }
	        }
	        int islandSize=1;
	        for(int val : set)
	        {
	            islandSize+=mp.get(val);
	        }
	        return islandSize;
	    }

	    public int largestIsland(int[][] grid) {
	        int n=grid.length;
	        int id=2;
	        Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
	         int result=0;
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                if(grid[i][j]==1)
	                {
	                    int size=dfs(grid,n,id,i,j);
	                    mp.put(id,size);
	                    result=Math.max(size,result);
	                    id++;
	                }
	            }
	        }
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                if(grid[i][j]==0)
	                {
	                    result=Math.max(result,findLargeIsland(grid,i,j,n,mp));
	                }
	            }
	        }

	        return result;

	    }
}
