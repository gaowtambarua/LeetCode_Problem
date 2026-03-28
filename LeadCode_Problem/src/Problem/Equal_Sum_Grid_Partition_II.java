package Problem;
import java.util.*;

public class Equal_Sum_Grid_Partition_II {
	long total=0;
	private void reverse(int[][] grid)
	{
		int left=0,right=grid.length-1,cSize=grid[0].length;
		while(left<right)
		{
			int[] temp = grid[left];
			grid[left] = grid[right];
			grid[right] = temp;
			left++;
			right--;
		}
	}
	private boolean checkResult(int[][] grid)
	{
		int m=grid.length;
		int n=grid[0].length;
		
		long top=0;
		Set<Long> set=new HashSet<>();
		for(int i=0;i<m-1;i++)
		{
			for(int j=0;j<n;j++)
			{
				top+=grid[i][j];
				set.add((long)grid[i][j]);
			}
			long buttom=total-top;
			long dif=top-buttom;
			
			if(dif==0)
			{
				return true;
			}
			if(dif==(long)grid[0][0])
			{
				return true;
			}
			if(dif==(long)grid[0][n-1])
			{
				return true;
			}
			if(i>0 && n>1 && set.contains(dif))
			{
				return true;
			}
			if(grid[i][0]==dif)
			{
				return true;
			}
		}
		return false;
	}
	public boolean canPartitionGrid(int[][] grid) {
		int m=grid.length;
		int n=grid[0].length;
		int[][] transFrom=new int[n][m];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				total+=grid[i][j];
				transFrom[j][i]=grid[i][j];
			}
		}
		if(checkResult(grid))
		{
			return true;
		}
		reverse(grid);
		if(checkResult(grid))
		{
			return true;
		}

		////////////////////////
		
		if(checkResult(transFrom))
		{
			return true;
		}
		reverse(transFrom);
		if(checkResult(transFrom))
		{
			return true;
		}
		return false;
	}


	public Equal_Sum_Grid_Partition_II()
	{
		int[][] grid={
				//				{100000,86218,100000}
				{1,2,4},
				{1,6,6},
				{5,6,7}
		};
		System.out.println(canPartitionGrid(grid));

	}
}
