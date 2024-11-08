import java.util.Stack;

public class DoubleNumberRepresentedLinkedList {

  public static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  static Stack<Integer> stackIn = new Stack<>();
  static Stack<Integer> stackOut = new Stack<>();

  public static ListNode doubleIt(ListNode head) {

    //Calculate the double linked list
    getDoubleLinkedList(head);

    //Create the linked list from stack
    ListNode result = createList(head);

    return result;
  }

  public static void getDoubleLinkedList(ListNode head){

    //add the linked list to stack
    while(head != null){
      stackIn.push(head.val);
      head = head.next;
    }

    int carry = 0;

    while(!stackIn.isEmpty()){
      int num = stackIn.pop();
      int doubleNum = num * 2 + carry;

      if(doubleNum > 9){
        carry = doubleNum / 10;
        doubleNum = doubleNum % 10;
      }else{
        carry = 0;
      }
      stackOut.push(doubleNum);
    }

    if(carry > 0){
      stackOut.push(carry);
    }

  }

  public static ListNode createList(ListNode head){
    ListNode current = head;
    ListNode prev = null;

    while (!stackOut.isEmpty()){
      int num = stackOut.pop();

      if(current == null){
        current = new ListNode(num);
        if(prev != null){
          prev.next = current;
        }
      }else{
        current.val = num;
      }

      prev = current;
      current = current.next;
    }

    return head;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {

    int[] numbers = {3,4,5,4,2,5,5,9,9,9};
    ListNode head = new ListNode(numbers[0]);
    ListNode current = head;

    for (int i = 1; i < numbers.length; i++) {
      current.next = new ListNode(numbers[i]);
      current = current.next;
    }

    System.out.println("LinkedList Before Deletion a node : ");
    printList(head);

    System.out.println("LinkedList After Double it  : ");
    ListNode result = doubleIt(head);
    printList(result);

  }
}
