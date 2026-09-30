package DP.Hard;
import java.util.*;
public class Problem_1239 {
	Map<String,Integer> map=new HashMap<String,Integer>();
	private boolean checkDuplicate(String s1,String s2)
	{
		int[] arr=new int[26];
		
		for(char ch : s2.toCharArray())
		{
			if(arr[ch-'a']>0)
			{
				return true;
			}
			arr[ch-'a']++;
		}
		
		for(char ch : s1.toCharArray())
		{
			if(arr[ch-'a']>0)
			{
				return true;
			}
		}
		
		
		return false;
	}
	
	private int solve(int i,List<String>arr,int n,String temp)
	{
		if(i>=n)
		{
			return temp.length();
		}
		
//		String k=temp+"#"+i;
		
		StringBuilder key=new StringBuilder();
		key.append(temp).append('#').append(i);
		String k=new String(key);
		
		
		if(map.containsKey(k))
		{
			return map.get(k);
		}
//		temp#i
		
		
		int left=0;
		int right=0;
		
		if(checkDuplicate(temp,arr.get(i)))
		{
			right=solve(i+1, arr, n, temp);
		}
		else 
		{
			left=solve(i+1, arr, n, temp+arr.get(i));
            right=solve(i+1, arr, n, temp);
		}
		
		
		int ans=Math.max(left,right);
		map.put(k,ans);
		return map.get(k);
	}
	
	
	
	public int maxLength(List<String> arr) {
		
		
		int n=arr.size();
		String temp="";
		
		
		return solve(0,arr,n,temp);
	}
}