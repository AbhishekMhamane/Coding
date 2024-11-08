import java.util.ArrayList;
import java.util.List;

/**
 * BinaryTreeInorderTraversal
 */
public class BinaryTreeInorderTraversal {

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

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    List<Integer> result = inorderTraversal(root);
    System.out.println("Result: " + result);
  }
}
