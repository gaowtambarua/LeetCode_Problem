package Problem;
import java.util.*;
public class Binary_Watch {

	public List<String> readBinaryWatch(int turnedOn) {
		List<String> result=new ArrayList<>();
		for(int i=0;i<=11;i++)
		{
			for(int j=0;j<=59;j++)
			{
				int bitTotal=Integer.bitCount(i)+Integer.bitCount(j);
				if(turnedOn==bitTotal)
				{
					String h=""+i,m=""+j;
					m=m.length()==1?"0"+m:m;
					result.add(h+":"+m);
				}
			}
		}
		return result;
	}
	public Binary_Watch()
	{
		System.out.println(readBinaryWatch(1));
	}
}
