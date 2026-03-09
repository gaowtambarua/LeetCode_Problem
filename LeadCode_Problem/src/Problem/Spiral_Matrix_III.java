package Problem;

import java.util.Arrays;

public class Spiral_Matrix_III {


	public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int[][] result=new int[rows*cols][2];

		int[][] direction={
				{0,1},{1,0},{0,-1},{-1,0}
		};
		int index=0,r=rStart,c=cStart;
		result[index++]=new int[]{r,c};
		int step = 1;
		
		while(index<rows*cols)
		{
			for(int d=0;d<4;d++)
			{
				for(int i=0;i<step;i++)
				{
					r+=direction[d][0];
					c+=direction[d][1];
					
					if(r>=0&&r<rows &&c>=0&&c<cols)
					{
						result[index++]=new int[]{r,c};
					}
				}
				if(d==1||d==3)
				{
					step++;
				}
			}
		}
		
		
		
		return result;
	}

	public Spiral_Matrix_III()
	{
		int rows=5,cols=6,rStart=1,cStart=4;
	}

}
