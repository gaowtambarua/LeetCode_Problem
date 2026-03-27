package Problem;

public class Partition_List {
	
	class ListNode{
		int val;
		ListNode next;
		ListNode(int val)
		{
			this.val=val;
			this.next=null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if(head==null)
		{
			return null;
		}
		ListNode dummy1=new ListNode(0),dummy2=new ListNode(0),first=new ListNode(0),second=new ListNode(0);
		dummy1=first;
		dummy2=second;
		while(head!=null)
		{
			
			if(head.val>=x)
			{
				second.next=new ListNode(head.val);
				second=second.next;
			}
			else
			{
				first.next=new ListNode(head.val);
				first=first.next;
			}
			head=head.next;
		}
		first.next=dummy2.next;	
		
		return dummy1.next;
	}

	public Partition_List()
	{
		ListNode head=new ListNode(1);
		head.next=new ListNode(4);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(2);
		head.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next=new ListNode(2);
		
		
		partition(head,5);
	}
}
