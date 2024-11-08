/**
 * MaximumDepthofBinaryTree
 */
public class MaximumDepthofBinaryTree {

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

  public static int maxDepth(TreeNode root) {
    return calMaxDepth(root, 0);
  }

  public static int calMaxDepth(TreeNode root, int depth) {
    if (root == null) return depth;

    int lDepth = calMaxDepth(root.left, depth + 1);
    int rDepth = calMaxDepth(root.right, depth + 1);

    return (lDepth >= rDepth) ? lDepth : rDepth;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    root.right.right.left = new TreeNode(8);
    root.right.right.left.right = new TreeNode(90);

    int maxDepth = maxDepth(root);
    System.out.println("maxDepth: " + maxDepth);
  }
}
