public class Temp {

  public static class ListNode {

    int val;
    ListNode next;

    public ListNode(int value) {
      val = value;
      next = null;
    }
  }

  public static void printList(ListNode root) {
    System.out.println("Addition of two linked list is : ");
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
    System.out.println();
  }

  public static ListNode mergeTwoLists(
    ListNode root,
    ListNode list1,
    ListNode list2
  ) {
    if (list1 == null && list2 == null) {
      return null;
    } else if (list1 != null && list2 == null) {
      root = new ListNode(list1.val);
      root.next = mergeLastElements(root.next, list1.next);
      return root;
    } else if (list1 == null && list2 != null) {
      root = new ListNode(list2.val);
      root.next = mergeLastElements(root.next, list2.next);
      return root;
    }

    if (list1.val <= list2.val) {
      root = new ListNode(list1.val);
      root.next = mergeTwoLists(root.next, list1.next, list2);
    } else {
      root = new ListNode(list2.val);
      root.next = mergeTwoLists(root.next, list1, list2.next);
    }

    return root;
  }

  public static ListNode mergeLastElements(ListNode root, ListNode list) {
    if (list == null) {
      return null;
    }

    root = new ListNode(list.val);
    root.next = mergeLastElements(root.next, list.next);

    return root;
  }

  public static void main(String[] args) {
    ListNode L1 = new ListNode(-9);
    L1.next = new ListNode(3);
    // L1.next.next = new ListNode(4);
    printList(L1);

    ListNode L2 = new ListNode(5);
    L2.next = new ListNode(7);
    // L2.next.next = new ListNode(4);
    printList(L2);

    ListNode root = mergeTwoLists(null, L1, L2);
    printList(root);
  }
}
