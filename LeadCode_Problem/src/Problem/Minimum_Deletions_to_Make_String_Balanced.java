package Problem;
import java.util.*;
public class Minimum_Deletions_to_Make_String_Balanced {

	public Minimum_Deletions_to_Make_String_Balanced()
	{
		 String s = "aababbab";
		 System.out.println(minimumDeletions(s));
	}

//	public int minimumDeletions(String s) {
//		Stack<Character> st=new Stack();
//		int count=0;
//		for(char ch : s.toCharArray())
//		{
//			if(ch=='b')
//			{
//				st.push(ch);
//			}
//			else if(ch=='a')
//			{
//				if(st.contains('b'))
//				{
//					st.pop();
//					count++;
//				}
//			}
//		}
//		return count;
//	}
	
	public int minimumDeletions(String s) {
		int count=0,delete=0;
		for(char ch : s.toCharArray())
		{
			if(ch=='b')
			{
				count++;
			}
			else if(ch=='a')
			{
				delete=Math.min(count,delete+1);
			}
		}
		return delete;
    }
}
