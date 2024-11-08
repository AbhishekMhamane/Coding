/**
 * RemoveDuplicatesFromSortedList
 */
public class RemoveDuplicatesFromSortedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode deleteDuplicates(ListNode head) {

    if(head==null || head.next == null ) return head;

    ListNode tempNode = head;
    ListNode test = null;

    while(tempNode != null )
    {
        test = tempNode.next;

        while(test!=null && test.val == tempNode.val)
        {
            test = test.next;
        }

        tempNode.next = test;
        tempNode = tempNode.next;
    }

    return head;
  }

  public static void printList(ListNode head)
  {
    while(head!=null)
    {
        System.out.println(head.val+" ");
        head = head.next;
    }
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(3);
    
    head = deleteDuplicates(head);
    printList(head);

  }
}
