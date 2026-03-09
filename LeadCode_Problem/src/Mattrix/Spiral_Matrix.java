package Mattrix;
import java.util.*;
public class Spiral_Matrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0)
		{
			return result;
		}
		int m=matrix.length,n=matrix[0].length;
		int top=0,right=n-1;
		int left=0,bottom=m-1;
		
		
		while(left<=right&&top <= bottom )
		{
			for(int j=top;j<=right;j++)
			{
				result.add(matrix[top][j]);
			}
			top++;
			for(int i=top;i<=bottom;i++)
			{
				result.add(matrix[i][right]);
			}
			right--;
			
			if(top<=bottom)
			{
				for(int j=right;j>=left;j--)
				{
					result.add(matrix[bottom][j]);
				}
				bottom--;
			}
			
			if(left<=right)
			{
				for(int i=bottom;i>=top;i--)
				{
					result.add(matrix[i][left]);
				}
				left++;
			}
			
		}
		
		
		
		return result;
	}

	public Spiral_Matrix ()
	{
		int[][] matrix={
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12},
				{13,14,15}
		};
		System.out.println(spiralOrder(matrix));
	}
}
