import java.util.*;

class Add_Two_Numbers {

  //created linked list class
  public static class ListNode {

    int val;
    ListNode next;

    public ListNode(int value) {
      val = value;
      next = null;
    }
  }

  //Function for printing linked list
  public static void printList(ListNode root) {
    System.out.println("Addition of two linked list is : ");
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
    System.out.println();
  }

  //Function for doing addition of two lists
  public static ListNode addition(ListNode L1, ListNode L2) {
    int sum = 0, h = 0;
    ListNode root = null, temp = null;
    while (L1 != null && L2 != null) {
      // System.out.println(L1.val+" "+L2.val);

      sum = L1.val + L2.val + h;

      if (sum > 9) {
        if (root == null) {
          root = new ListNode(sum % 10);
          temp = root;
        } else {
          temp.next = new ListNode(sum % 10);
          temp = temp.next;
        }
        // System.out.print(sum%10);
        h = sum / 10;
        sum = 0;
      } else {
        // System.out.print(sum);
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
        // System.out.print(sum%10);
        temp.next = new ListNode(sum % 10);
        temp = temp.next;

        h = sum / 10;
        sum = 0;
      } else {
        //System.out.print(sum);
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
        // System.out.print(sum%10);
        temp.next = new ListNode(sum % 10);
        temp = temp.next;
        h = sum / 10;
        sum = 0;
      } else {
        // System.out.print(sum);
        temp.next = new ListNode(sum);
        temp = temp.next;
        h = 0;
        sum = 0;
      }

      L2 = L2.next;
    }

    if (h != 0) {
      //System.out.print(h);
      temp.next = new ListNode(h);
      temp = temp.next;
    }

    return root;
  }

  //Main method
  public static void main(String[] args) {
    //created linked list one
    ListNode L1 = new ListNode(9);
    L1.next = new ListNode(9);
    L1.next.next = new ListNode(9);
    L1.next.next.next = new ListNode(9);
    L1.next.next.next.next = new ListNode(9);
    L1.next.next.next.next.next = new ListNode(9);
    L1.next.next.next.next.next.next = new ListNode(9);

    //created linked list second
    ListNode L2 = new ListNode(9);
    L2.next = new ListNode(9);
    L2.next.next = new ListNode(9);
    L2.next.next.next = new ListNode(9);

    // ListNode L1 = new ListNode(2);
    // L1.next = new ListNode(4);
    // L1.next.next = new ListNode(3);
    // L1.next.next.next = new ListNode(6);

    // ListNode L2 = new ListNode(5);
    // L2.next = new ListNode(6);
    // L2.next.next = new ListNode(4);
    // L2.next.next.next = new ListNode(9);
    // L2.next.next.next.next = new ListNode(2);

    //called addition function
    ListNode root = addition(L1, L2);

    //printing addition result list
    printList(root);
  }
}
