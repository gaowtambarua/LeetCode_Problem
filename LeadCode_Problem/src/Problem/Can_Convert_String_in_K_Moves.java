package Problem;

public class Can_Convert_String_in_K_Moves {

	public boolean canConvertString(String s, String t, int k) {
		if(s.length()!=t.length())
		{
			return false;
		}
		int[] count= new int[26];
		for(int j=0;j<s.length();j++)
		{
			int diff=t.charAt(j)-s.charAt(j);
			if(diff==0)
			{
				continue;
			}
			else if(diff<0)
			{
				diff=diff+26;
			}
			int totalTime=diff+26*count[diff];
			if(totalTime>k)
			{
				return false;
			}
			count[diff]++;
		}
		return true;
	}
	public Can_Convert_String_in_K_Moves()
	{
		String s="aab",t="bbb";
		int k=10;
		System.out.println(canConvertString(s, t, k));
	}
}
