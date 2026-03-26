package Problem;

import java.util.Arrays;

public class Count_the_Number_of_Substrings_With_Dominant_Ones {
	public int numberOfSubstrings(String s) {
		int n=s.length(),result=0;
		int[] prefix=new int[n+1];
		prefix[0]=-1;
		for(int i=0;i<n;i++)
		{
			if(i==0||s.charAt(i-1)=='0')
			{
				prefix[i+1]=i;
			}
			else
			{
				prefix[i+1]=prefix[i];
			}
		}
		for(int r=1;r<=n;r++)
		{
			int zero=s.charAt(r-1)=='0'?1:0;
			int l=r,one=0;
			while(l>0&&zero*zero<=n)
			{
				one=r-prefix[l]-zero;
				if(one>=zero*zero)
				{
					result+=Math.min(l-prefix[l],one-zero*zero+1);
				}
				l=prefix[l];
				zero++;
			}
		}
		
		
		
		return result;
	}
	public Count_the_Number_of_Substrings_With_Dominant_Ones()
	{
		String s="101101";

		System.out.println(numberOfSubstrings(s));
	}
}
