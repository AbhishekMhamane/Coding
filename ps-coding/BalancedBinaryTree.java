/**
 * BalancedBinaryTree
 */
public class BalancedBinaryTree {

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

  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    boolean isLeftBalanced = isBalanced(root.left);
    boolean isRightBalanced = isBalanced(root.right);

    int lCount = calculateHeight(root.left, 0);
    int rCount = calculateHeight(root.right, 0);

    if (
      (
        (lCount == rCount || (lCount - 1) == rCount || (rCount - 1) == lCount)
      ) &&
      isLeftBalanced &&
      isRightBalanced
    ) return true;

    return false;
  }

  public static int calculateHeight(TreeNode root, int count) {
    if (root == null) return count;

    int lCount = calculateHeight(root.left, count + 1);
    int rCount = calculateHeight(root.right, count + 1);

    return (lCount >= rCount) ? lCount : rCount;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);

    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println("Is tree balanced : " + isBalanced(root));
  }
}
