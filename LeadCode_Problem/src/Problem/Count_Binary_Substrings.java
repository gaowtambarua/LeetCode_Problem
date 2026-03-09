package Problem;

public class Count_Binary_Substrings {
	public int countBinarySubstrings(String s) {
    	int pre=0,cur=1,result=0;
	for(int i=1;i<s.length();i++)
	{
		if(s.charAt(i)==s.charAt(i-1))
		{
			cur++;
		}
		else
		{
			result=Math.min(cur, pre)+result;
			pre=cur;
			cur=1;
		}
	}
	result=Math.min(cur, pre)+result;
	return result;
}
}
