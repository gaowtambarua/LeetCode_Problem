package Problem;

import java.util.Arrays;

public class Spiral_Matrix_II {
	public int[][] generateMatrix(int n) {
		int[][] result=new int[n][n];
		int element=1;
		int top=0,right=n-1;
		int left=0,buttom=n-1;
		
		while(top<=buttom && left<=right)
		{
			for(int j=top;j<=right;j++)
			{
				result[top][j]=element++;
			}
			top++;
			for(int i=top;i<=buttom;i++)
			{
				result[i][right]=element++;
			}
			right--;
			if(top<=buttom)
			{
				for(int j=right;j>=left;j--)
				{
					result[buttom][j]=element++;
				}
				buttom--;
			}
			if(left<=right)
			{
				for(int i=buttom;i>=top;i--)
				{
					result[i][left]=element++;
				}
				left++;
			}
		}
		
		return result;
	}

	public Spiral_Matrix_II()
	{
		for(int [] v : generateMatrix(3))
		{
			System.out.println(Arrays.toString(v));
		}
	}
}
