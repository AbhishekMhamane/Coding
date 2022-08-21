import java.util.*;

public class Reorder_List {

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

  public static void reorderList(ListNode head) {
    ArrayList<Integer> st = new ArrayList<Integer>();

    ListNode temp = head;

    while (temp != null) {
      st.add(temp.val);
      temp = temp.next;
    }

    int i = 0;
    int n = st.size() - 1;
    boolean check = false;

    while (head != null) {
      if (check) {
        //System.out.println(st.get(n));
        head.val = st.get(n);
        check = false;
        n--;
      } else {
        //System.out.println(st.get(i));
        head.val = st.get(i);
        check = true;
        i++;
      }
      head = head.next;
    }
  }

  public static void main(String[] args) {
    ListNode L1 = new ListNode(1);
    L1.next = new ListNode(2);
    L1.next.next = new ListNode(3);
    L1.next.next.next = new ListNode(4);
    L1.next.next.next.next = new ListNode(5);
    L1.next.next.next.next.next = new ListNode(6);

    printList(L1);
    ListNode head = L1;
    reorderList(head);
    printList(L1);
  }
}
