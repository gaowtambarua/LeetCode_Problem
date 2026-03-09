package Problem;

import java.util.Arrays;

public class Spiral_Matrix_IV {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val)
		{
			this.val=val;
			this.next=null;
		}
	}
	public int[][] spiralMatrix(int m, int n, ListNode head) {
		int [][] result =new int[m][n];
		int top=0,right=n-1,buttom=m-1,left=0;
		
		
		while(top<=buttom && left<=right)
		{
			for(int j=top;j<=right;j++)
			{
				if(head!=null)
				{
					result[top][j]=head.val;
					head=head.next;
				}
				else
				{
					result[top][j]=-1;
				}
			}
			top++;
			
			for(int i=top;i<=buttom;i++)
			{
				if(head!=null)
				{
					result[i][right]=head.val;
					head=head.next;
				}
				else
				{
					result[i][right]=-1;
				}
			}
			right--;
			
			if(top<=buttom)
			{
				for(int j=right;j>=left;j--)
				{
					if(head!=null)
					{
						result[buttom][j]=head.val;
						head=head.next;
					}
					else
					{
						result[buttom][j]=-1;
					}
				}
				buttom--;
			}
			
			if(left<=right)
			{
				for(int i=buttom;i>=top;i--)
				{
					if(head!=null)
					{
						result[i][left]=head.val;
						head=head.next;
					}
					else
					{
						result[i][left]=-1;
					}
				}
				left++;
			}
			
		}
		
		
		return result;
	}

	public Spiral_Matrix_IV()
	{
		ListNode head=new ListNode(0);
		head.next=new ListNode(1);
		head.next.next=new ListNode(2);
		System.out.println(Arrays.toString(spiralMatrix(1, 4, head)[0]));
	}
}
