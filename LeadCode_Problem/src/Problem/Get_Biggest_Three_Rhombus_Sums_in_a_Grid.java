package Problem;

import java.util.*;
public class Get_Biggest_Three_Rhombus_Sums_in_a_Grid {

	public int[] getBiggestThree(int[][] grid) {

		int m=grid.length;
		int n=grid[0].length;
		TreeSet<Integer> set=new TreeSet<>();

		for(int r=0;r<m;r++)
		{
			for(int c=0;c<n;c++)
			{
				// 0 side rombus
				set.add(grid[r][c]);
				if(set.size()>3)
				{
					set.pollFirst();
				}
				for(int side=1; r-side>=0 && r+side<m && c+side<n && c-side>=0 ;  side++)
				{
					int sum=0;
					for(int k=0;k<=side-1;k++)
					{
						sum+=grid[r-side+k][c+k];  // top to right
						sum+=grid[r+k ][c+side-k]; // right to buttom
						sum+=grid[r+side-k][c-k];  // buttom to left
						sum+=grid[r-k][c-side+k];  // left to top
					}
					set.add(sum);
					if(set.size()>3)
					{
						set.pollFirst();
					}
				}
			}
		}
		m=set.size()-1;
		int [] result=new int[m+1];
		for(int r=m;r>=0;r--)
		{
			result[r]=set.pollFirst();
		}

		return result;
	}


	public Get_Biggest_Three_Rhombus_Sums_in_a_Grid()
	{
		
	}
}
