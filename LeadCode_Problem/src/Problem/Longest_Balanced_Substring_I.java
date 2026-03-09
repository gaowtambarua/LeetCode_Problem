package Problem;

public class Longest_Balanced_Substring_I {

	public boolean checkBalance(int[] count)
	{
		int common=0;
		for(int i=0;i<26;i++)
		{
			if(count[i]==0)
			{
				continue;
			}
			else if(common==0)
			{
				common=count[i];
			}
			else if(common!=count[i])
			{
				return false;
			}
		}
		return true;
	}
	public int longestBalanced(String s) {
		int maxLen=0,len=s.length();
		for(int i=0;i<len;i++)
		{
			int [] count=new int[26];
			for(int j=i;j<len;j++)
			{
				char ch=s.charAt(j);
				count[ch-'a']++;
				if(checkBalance(count))
				{
					maxLen=Math.max(maxLen, j-i+1);
				}
			}
		}
		return maxLen;
	}
	
	
	public Longest_Balanced_Substring_I()
	{
		String s="aba";
		System.out.println(longestBalanced(s));
	}
}
