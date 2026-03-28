package Function;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Reverse {

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
	private void reverse2(int[][] a)
	{
		int left=0,right=a.length-1;
		while(left<right)
		{
			int []temp=Arrays.copyOf(a[left],a[left].length);
			a[left]=Arrays.copyOf(a[right],a[right].length);
			a[right]=Arrays.copyOf(temp,temp.length);
			left++;
			right--;
		}
	}



	public Reverse()
	{
		int[][] a={
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
//		//		List<int[]> list=Arrays.asList(a);
//		//		Collections.reverse(list);
//		//		
//		//		
//		//		System.out.println(Arrays.toString(list.get(0)));
//		//		System.out.println(Arrays.toString(list.get(1)));
//		//		System.out.println(Arrays.toString(list.get(2)));
//		
//		
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//
//		System.out.println();
//		reverse(a);
//
//		//// Memory te man change hoi na//ager data thake  
//		
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//		
//		System.out.println();
//		reverse2(a);
//
//		//// Memory te man change hoi //new data jukto hoi
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
		
		
		
		
		////
		
		int aa[]={1,2};
		int b[]={3,5};
		//aa=b;
		//System.out.println(Arrays.toString(aa));
		//b[0]=10;
		
		int[] temp = b;
        b = aa;
		//aa = temp;
		aa[0]=10;
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(aa));
		
	}
}
