package Problem;

import java.util.Arrays;

public class Problem_3474 {
	
	public boolean isSame(char[] word,String str2,int i,int m)
	{
		for(int j=0;j<m;j++)
		{
			if(word[i]!=str2.charAt(j))
			{
				return false;
			}
			i++;
		}
		return  true;
	}

	public String generateString(String str1, String str2) {
		
		int n=str1.length();
		int m=str2.length();
		int N=n+m-1;
		char word[]=new char[N];
		Arrays.fill(word,'$');
		for(int i=0;i<n;i++)
		{
			int i_=i;
			if(str1.charAt(i)=='T')
			{
				for(int j=0;j<m;j++)
				{
					if(word[i_]!='$' && word[i_]!=str2.charAt(j))
					{
						return "";
					}
					
					word[i_]=str2.charAt(j);
					i_++;
				}
			}
		}
		boolean canChange[]=new boolean[N];
		for(int i=0;i<N;i++)
		{
			if(word[i]=='$')
			{
				word[i]='a';
				canChange[i]=true;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			if(str1.charAt(i)=='F')
			{
				if(isSame(word,str2,i,m))
				{
					boolean isChange=false;
					for(int j=i+m-1;j>=i;j--)
					{
						if(canChange[j])
						{
							word[j]='b';
							isChange=true;
							break;
						}
					}
					if(!isChange)
					{
						return "";
					}
				}
			}
		}
		
		
		return new String(word);
	}

	public Problem_3474()
	{
		char[] a={'a','b'};
		
	}
}
