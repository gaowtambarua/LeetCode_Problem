package DP.Hard;

public class Problem_514 {
	
	 int dp[][];
	    int minimumNumberStep(int rnIdx,int i,int size)
	    {
	        int clockwise=Math.abs(rnIdx-i);
	        int anticlockwise=size-clockwise;
	        return Math.min(clockwise,anticlockwise);
	    }

	    int result(int rnIdx,int kyIdx,String ring,String key)
	    {
	        if(kyIdx>=key.length())
	        {
	            return 0;
	        }
	        if(dp[rnIdx][kyIdx]!=0)
	        {
	            return dp[rnIdx][kyIdx];
	        }
	        int size=ring.length();
	        int minresult=Integer.MAX_VALUE;
	        for(int i=0;i<size;i++)
	        {
	            if(ring.charAt(i)==key.charAt(kyIdx))
	            {
	                int rotate=minimumNumberStep(rnIdx,i,size)+1+result(i,kyIdx+1,ring,key);
	                minresult=Math.min(minresult,rotate);
	            }
	        }
	        dp[rnIdx][kyIdx]=minresult;
	        return minresult;
	    }



	    public int findRotateSteps(String ring, String key) {
	        dp =new int[ring.length()][key.length()];
	        return result(0,0,ring,key);
	    }

}
