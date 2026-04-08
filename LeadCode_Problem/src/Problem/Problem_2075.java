package Problem;

import java.util.Arrays;

public class Problem_2075 {

	public String decodeCiphertext(String encodedText, int rows) {
		
//		int n=encodedText.length();
//		int colums=n/rows;
//		char grid[][]=new char[rows][colums];
//		int count=0;;
//		for(int i=0;i<rows;i++)
//		{
//			for(int j=0;j<colums;j++)
//			{
//				grid[i][j]=encodedText.charAt(count);
//				count++;
//			}
//		}
//		String result="";
//		for(int i=0;i<colums;i++)
//		{
//			
//			int c=i;
//			int r=0;
//			while(r<rows&&c<colums)
//			{
//				result+=grid[r][c];
//				r++;
//				c++;
//			}
//		}	
//		return result;
		
		
		int n=encodedText.length();
		int colums=n/rows;
		
		String result="";
		for(int i=0;i<colums;i++)
		{
			int r=i;
			while(r<n)
			{
				result+=encodedText.charAt(r);
				r+=colums+1;
			}
		}
		
		
		
		
		
		return result;
	}


	public Problem_2075()
	{
		String encodedText = "ch   ie   pr";
		int rows = 3;
		System.out.println(decodeCiphertext(encodedText, rows));
	}
}
