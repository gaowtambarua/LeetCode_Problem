package Graph;
import java.util.*;
public class Problem_752 {

	
	public int openLock(String[] deadends, String target) {
		
		Queue<char[]> qu=new LinkedList<char[]>();
		qu.offer(new char[]{'0','0','0','0'});
		Set<String> visited=new HashSet<String>(Arrays.asList(deadends));
		if(visited.contains("0000"))
		{
			return -1;
		}
		
		visited.add("0000");
		int step=0;
		while(!qu.isEmpty())
		{
			int size=qu.size();
			while(size-->0)
			{
				char[] cur=qu.poll();
				if(target.equals(String.valueOf(cur)))
				{
					return step;
				}
				
				for(int i=0;i<4;i++)
				{
					char[] next=cur.clone();
					char ch = next[i];
					next[i]=(char)((ch == '0') ? '9' : ch - 1);
					String antiClockwise=String.valueOf(next);
					if(!visited.contains(antiClockwise))
					{
						visited.add(antiClockwise);
						qu.offer(next);
					}
					
					
					char[] next2=cur.clone();
					ch = next2[i];
					next2[i]=(char)((ch == '9') ? '0' : ch + 1);
					String clockwise=String.valueOf(next2);
					if(!visited.contains(clockwise)){
						visited.add(clockwise);
						qu.offer(next2);
					}
				}
			}
			step++;
		}
		
		return -1;
	}


	public Problem_752()
	{
		char ch='2'+1;
		System.out.println(ch);
	}
}
