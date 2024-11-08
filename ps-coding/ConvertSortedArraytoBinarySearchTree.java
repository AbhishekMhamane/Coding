import java.util.ArrayList;
import java.util.List;

public class ConvertSortedArraytoBinarySearchTree {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    doInorderTraversal(root, result);

    return result;
  }

  public static void doInorderTraversal(TreeNode root, List<Integer> result) {
    if (root == null) return;

    doInorderTraversal(root.left, result);

    result.add(root.val);

    doInorderTraversal(root.right, result);
  }

  public static TreeNode sortedArrayToBST(int[] nums) {
    return calculateSquenceOfNodes(nums, 0, nums.length - 1);
  }

  public static TreeNode calculateSquenceOfNodes(
    int nums[],
    int left,
    int right
  ) {
    if (left > right) return null;

    int mid = (left + right) / 2;

    TreeNode node = new TreeNode(nums[mid]);

    node.left = calculateSquenceOfNodes(nums, left, mid - 1);
    node.right = calculateSquenceOfNodes(nums, mid + 1, right);

    return node;
  }

  public static void main(String[] args) {
    int nums[] = { 0, 1, 2, 3, 4, 5 };
    TreeNode root = sortedArrayToBST(nums);
    List<Integer> result = inorderTraversal(root);
    System.out.println("Result: " + result);
  }
}
