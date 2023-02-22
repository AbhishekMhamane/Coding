public class Recursion_Reverse_LinkedList {

  public static class ListNode {

    int val;
    ListNode next;

    public ListNode(int value) {
      val = value;
      next = null;
    }
  }

  public static void printList(ListNode root) {
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
    System.out.println();
  }

  // public static ListNode reverseList(ListNode head) {

  //   ListNode prev = null;
  //   ListNode nextNode = null;
  //   ListNode current = head;
  //   while(current!=null)
  //   {
  //     nextNode = current.next;
  //     current.next = prev;
  //     prev = current;
  //     current = nextNode;
  //   }
  //   head = prev;
  //   return head;
  // }

  public static ListNode reverseList(ListNode head) {
    if (head.next == null) return new ListNode(head.val);

    ListNode temp = reverseList(head.next);

    ListNode test = temp;

    while (test.next != null) {
      test = test.next;
    }

    test.next = new ListNode(head.val);

    return temp;
  }

  public static void main(String[] args) {
    ListNode L1 = new ListNode(1);
    L1.next = new ListNode(2);
    L1.next.next = new ListNode(3);
    L1.next.next.next = new ListNode(4);
    L1.next.next.next.next = new ListNode(5);

    printList(L1);

    ListNode head = reverseList(L1);
    printList(head);
  }
}
