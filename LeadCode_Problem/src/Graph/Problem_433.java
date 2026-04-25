package Graph;
import java.util.*;
public class Problem_433 {

	public int minMutation(String startGene, String endGene, String[] bank) {
		Set<String> bankSet=new HashSet<String>(Arrays.asList(bank));
		if(!bankSet.contains(endGene))
		{
			return -1;
		}

		char[] genes={'A','C','G','T'};
		Queue<String> queue=new LinkedList<>();
		Set<String> visited=new HashSet<>();

		queue.offer(startGene);
		visited.add(startGene);
		int mutations=0;
		while(!queue.isEmpty())
		{
			int size=queue.size();

			for(int i=0;i<size;i++)
			{
				String current=queue.poll();

				char[] currentArray=current.toCharArray();
				if(current.equals(endGene))
				{
					return mutations;
				}
				for(int j=0;j<currentArray.length;j++)
				{
					char oldChar=currentArray[j];
					for(char gene : genes)
					{
						currentArray[j]=gene;
						String muted=new String(currentArray);
						if(!visited.contains(muted)&&bankSet.contains(muted))
						{
							visited.add(muted);
							queue.offer(muted);
						}
					}
					 currentArray[j] = oldChar; 
				}
			}
			
			mutations++;
		}

		return -1;
	}


	public Problem_433()
	{

	}
}
