public class Recursion_Swap_Nodes_In_Pairs {

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

  public static ListNode swapPairs(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;

    int temp = head.next.val;
    head.next.val = head.val;
    head.val = temp;

    head.next.next = swapPairs(head.next.next);

    return head;
  }

  public static void main(String[] args) {
    ListNode L1 = new ListNode(1);
    L1.next = new ListNode(2);
    L1.next.next = new ListNode(3);
    L1.next.next.next = new ListNode(4);
    L1.next.next.next.next = new ListNode(5);
    printList(L1);

    ListNode head = swapPairs(L1);
    printList(head);
  }
}
