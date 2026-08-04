package Graph;

public class Problem_1361 {

	class DSU{
		int[] parent;
		int[] rank;
		public DSU(int n)
		{
			parent=new int[n];
			rank=new int[n];
			for(int i=0;i<n;i++)
			{
				parent[i]=i;
			}
		}
		int find(int x)
		{
			if(parent[x]==x)
			{
				return x;
			}
			return find(parent[x]);
		}
		boolean union(int a,int b)
		{
			int pa=find(a);
			int pb=find(b);
			if(pa==pb)
			{
				return true;
			}
			if(rank[pa]==rank[pb])
			{
				parent[pb]=pa;
				rank[pa]++;
			}
			else if(rank[pa]>rank[pb])
			{
				parent[pb]=pa;
			}
			else if(rank[pa]<rank[pb])
			{
				parent[pa]=pb;
			}
			return false;
		}
	}

	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

		DSU dsu=new DSU(n);
		int[] indegree=new int[n];
		for(int i=0;i<n;i++)
		{
			int leftChildNode=leftChild[i];//v
			int rightildNode=rightChild[i];//v
			if(leftChildNode!=-1)
			{
				indegree[leftChildNode]++;
                if(indegree[leftChildNode]>1)
                {
                    return false;
                }
				if(dsu.union(i, leftChildNode))
				{
					return false;
				}
			}
			if(rightildNode!=-1)
			{
				indegree[rightildNode]++;
                if(indegree[rightildNode]>1)
                {
                    return false;
                }
				if(dsu.union(i, rightildNode))
				{
					return false;
				}
			}
		}
		int rootcount=0;
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==0)
			{
				rootcount++;
			}
		}
		return rootcount==1;   
	}

	public Problem_1361()
	{
		int n=4,l[]={1,-1,3,-1},r[]={2,-1,-1,-1};
		System.out.println(validateBinaryTreeNodes(n, l, r));
	}
}
