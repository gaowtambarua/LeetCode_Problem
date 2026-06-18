package Problem;
import java.util.*;
public class Problem_133 {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	Map<Node,Node> set=new HashMap<Node,Node>();
	void dfs(Node node,Node cloneNode)
	{
		for(Node n : node.neighbors)
		{
			if(!set.containsKey(n))
			{
				Node clone=new Node(n.val);
				set.put(n,clone);
				cloneNode.neighbors.add(clone);
				dfs(n,clone);
			}
			else
			{
				cloneNode.neighbors.add(set.get(n));
			}
			
		}
	}
	
	public Node cloneGraph(Node node) {
		if(node==null)
		{
			return null;
		}
		Node cloneNode=new Node(node.val);
		set.put(node,cloneNode);
		dfs(node,cloneNode);
		return cloneNode;
	}


	public Problem_133()
	{
		
	}
}
