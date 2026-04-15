package Problem;
import java.util.*;
public class Problem_199 {
	
	public class TreeNode{
		int val=0;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val)
		{
			this.val=val;
		}
	}
	public void PreOrder(TreeNode root,List<Integer> result,int count)
	{
		if(root==null)
		{
			return ;
		}
		if(!(count<result.size()))
		{
			result.add(root.val);
		}
		PreOrder(root.right,result,count+1);
		PreOrder(root.left,result,count+1);
	}
	
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result=new ArrayList<>();
		PreOrder(root,result,0);
		
		return result;
	}


	public Problem_199()
	{
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println(0<list.size());
	}
}
