package Graph;
import java.util.*;
public class Problem_841 {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms)
	{
		int n=rooms.size();
		boolean[] visitRoom=new boolean[n];
		
		
		Queue<Integer> qu=new LinkedList<>();
		
		List<Integer> list = rooms.get(0);
		visitRoom[0]=true;
		for(int val : list)
		{
			visitRoom[val]=true;
			qu.offer(val);
		}
		while(!qu.isEmpty())
		{
			int presentRoom=qu.poll();
			for(int val : rooms.get(presentRoom))
			{
				if(!visitRoom[val])
				{
					visitRoom[val]=true;
					qu.offer(val);
				}
			}
		}
		
		for(boolean check : visitRoom)
		{
			if(!check)
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	public Problem_841()
	{
		List<List<Integer>> rooms=new ArrayList<>();
//		rooms.add(new ArrayList<>(Arrays.asList(1,3)));
//		rooms.add(new ArrayList<>(Arrays.asList(3,0,1)));
//		rooms.add(new ArrayList<>(Arrays.asList(2)));
//		rooms.add(new ArrayList<>(Arrays.asList(0)));
//		System.out.println(rooms.get(0));
//		System.out.println(rooms.get(1));
//		System.out.println(rooms.get(2));
//		System.out.println(rooms.get(3));
		rooms.add(new ArrayList<>(Arrays.asList(1)));
		rooms.add(new ArrayList<>(Arrays.asList(2)));
		rooms.add(new ArrayList<>(Arrays.asList(3)));
		rooms.add(new ArrayList<>());
		System.out.println(canVisitAllRooms(rooms));
		
	}
}
