
class Add_Two_Numbers {

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

  public static ListNode addition(ListNode L1, ListNode L2) {
    int sum = 0, h = 0;
    ListNode root = null, temp = null;
    while (L1 != null && L2 != null) {

      sum = L1.val + L2.val + h;

      if (sum > 9) {
        if (root == null) {
          root = new ListNode(sum % 10);
          temp = root;
        } else {
          temp.next = new ListNode(sum % 10);
          temp = temp.next;
        }
        h = sum / 10;
        sum = 0;
      } else {
        if (root == null) {
          root = new ListNode(sum);
          temp = root;
        } else {
          temp.next = new ListNode(sum);
          temp = temp.next;
        }

        h = 0;
        sum = 0;
      }

      L1 = L1.next;
      L2 = L2.next;
    }

    while (L1 != null) {
      sum = L1.val + h;

      if (sum > 9) {
        temp.next = new ListNode(sum % 10);
        temp = temp.next;

        h = sum / 10;
        sum = 0;
      } else {
        temp.next = new ListNode(sum);
        temp = temp.next;

        h = 0;
        sum = 0;
      }

      L1 = L1.next;
    }

    while (L2 != null) {
      sum = L2.val + h;

      if (sum > 9) {
        temp.next = new ListNode(sum % 10);
        temp = temp.next;
        h = sum / 10;
        sum = 0;
      } else {
        temp.next = new ListNode(sum);
        temp = temp.next;
        h = 0;
        sum = 0;
      }

      L2 = L2.next;
    }

    if (h != 0) {
      temp.next = new ListNode(h);
      temp = temp.next;
    }

    return root;
  }

  public static void main(String[] args) {
    ListNode L1 = new ListNode(9);
    L1.next = new ListNode(9);
    L1.next.next = new ListNode(9);
    L1.next.next.next = new ListNode(9);
    L1.next.next.next.next = new ListNode(9);
    L1.next.next.next.next.next = new ListNode(9);
    L1.next.next.next.next.next.next = new ListNode(9);

    ListNode L2 = new ListNode(9);
    L2.next = new ListNode(9);
    L2.next.next = new ListNode(9);
    L2.next.next.next = new ListNode(9);

    ListNode root = addition(L1, L2);
    printList(root);
  }
}
