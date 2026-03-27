package Problem;

import java.util.Arrays;

public class Equal_Sum_Grid_Partition_I {


	public boolean canPartitionGrid(int[][] grid) {
		
		int m=grid.length,n=grid[0].length;
        long totalsum=0;
		int [] row=new int[m],col=new int[n];
		for(int r=0;r<m;r++)
		{
			for(int c=0;c<n;c++)
			{
				totalsum+=grid[r][c];
				row[r]+=grid[r][c];
				col[c]+=grid[r][c];
			}
		}
		if(totalsum%2!=0)
		{
			return false;
		}
		long upper=0;
		for(int i=0;i<m-1;i++)
		{
			upper+=row[i];
			if(upper==totalsum-upper)
			{
				return  true;
			}
		}
		long left=0;
		for(int j=0;j<n-1;j++)
		{
			left+=col[j];
			if(left==totalsum-left)
			{
				return true;
			}
		}
		return false;
	}

	public Equal_Sum_Grid_Partition_I()
	{
		int [][] grid={{54756,54756}};
		
		System.out.println(canPartitionGrid(grid));
	}
}
