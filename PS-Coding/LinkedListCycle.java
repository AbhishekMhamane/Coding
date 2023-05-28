import java.util.ArrayList;
import java.util.HashMap;

public class LinkedListCycle {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static boolean hasCycle(ListNode head) {
    while (head != null) {
      if (head.val == Integer.MIN_VALUE) return true;
      head.val = Integer.MIN_VALUE;
      head = head.next;
    }

    return false;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
    head.next.next.next.next = head.next;

    System.out.println("Is list have cycle : " + hasCycle(head));
  }
}
