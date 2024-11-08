import java.util.*;

public class Recursion_Palindrome_LinkedList {

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

  public static boolean isPalindrome(ListNode head) {
    if (head == null) return false;
    Queue<Integer> queue = new LinkedList<Integer>();

    return isPalindromeCheck(queue, head);
  }

  public static boolean isPalindromeCheck(Queue<Integer> queue, ListNode head) {
   
    if (head == null) return true;

    queue.add(head.val);

    boolean isCheck = isPalindromeCheck(queue, head.next);

    int front = queue.poll();

    if (isCheck && (front == head.val)) return true;

    return false;
  }

  public static void main(String[] args) {
    ListNode L1 = new ListNode(1);
    L1.next = new ListNode(2);
    L1.next.next = new ListNode(1);

    printList(L1);

    boolean head = isPalindrome(L1);
    System.out.println(head);
  }
}
