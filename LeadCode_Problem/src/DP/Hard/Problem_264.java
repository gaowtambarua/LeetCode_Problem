package DP.Hard;

public class Problem_264 {

	public int nthUglyNumber(int n) {
		
		int[] memory=new int[n+1];
		memory[1]=1;
		
		int i2=1;
		int i3=1;
		int i5=1;
		
		for(int i=2;i<=n;i++)
		{
			int p2=memory[i2]*2;
			int p3=memory[i3]*3;
			int p5=memory[i5]*5;
			int min=Math.min(p2,Math.min(p3, p5));
			memory[i]=min;
			
			if(p2==min)
			{
				i2++;
			}
			if(p3==min)
			{
				i3++;
			}
			if(p5==min)
			{
				i5++;
			}
		}
		
		return memory[n];
	}

	public Problem_264()
	{

	}
}
