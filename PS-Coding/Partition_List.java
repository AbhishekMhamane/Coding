// 86. Partition List
// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

public class Partition_List {

  public static class ListNode {

    int val;
    ListNode next = null;

    ListNode(int data) {
      this.val = data;
      this.next = null;
    }
  }

  public static void printListNode(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }

  public static ListNode partition(ListNode head, int x) {
    ListNode h1 = null, h2 = null, minHead = null, maxHead = null;

    while (head != null) {
      if (head.val < x) {
        if (minHead == null) {
          minHead = new ListNode(head.val);
          h1 = minHead;
        } else {
          ListNode newNode = new ListNode(head.val);
          minHead.next = newNode;
          minHead = newNode;
        }
      } else if (head.val >= x) {
        if (maxHead == null) {
          maxHead = new ListNode(head.val);
          h2 = maxHead;
        } else {
          ListNode newNode = new ListNode(head.val);
          maxHead.next = newNode;
          maxHead = newNode;
        }
      }

      head = head.next;
    }

    if (h1 != null && h2 != null) {
      minHead.next = h2;
      return h1;
    } else if (h1 != null && h2 == null) {
      return h1;
    } else if (h1 == null && h2 != null) {
      return h2;
    }

    return null;
  }

  public static void main(String args[]) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);

    int x = 3;
    System.out.println("Given singly linked list :");
    printListNode(head);
    System.out.println("X value : " + x);

    System.out.println("Partitioned list ");
    ListNode resultHead = partition(head, x);
    printListNode(resultHead);
  }
}
