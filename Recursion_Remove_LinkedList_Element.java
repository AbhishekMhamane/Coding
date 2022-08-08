public class Recursion_Remove_LinkedList_Element {

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

  public static ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;

    if (head.val == val) {
      head = removeElements(head.next, val);
      return head;
    }

    head.next = removeElements(head.next, val);

    return head;
  }

  public static void main(String[] args) {
    ListNode L1 = new ListNode(1);
    L1.next = new ListNode(2);
    L1.next.next = new ListNode(6);
    L1.next.next.next = new ListNode(3);
    L1.next.next.next.next = new ListNode(4);
    L1.next.next.next.next.next = new ListNode(5);
    L1.next.next.next.next.next.next = new ListNode(6);

    printList(L1);

    int val = 6;

    ListNode head = removeElements(L1, val);
    printList(head);
  }
}
