public class MinimumDepthofBinaryTree {

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

  public static int minDepth(TreeNode root) {
    if (root == null) return 0;
    return calMinDepth(root, 0);
  }

  public static int calMinDepth(TreeNode root, int depth) {
    if (root == null) return Integer.MAX_VALUE;
    if (root.left == null && root.right == null) return depth + 1;

    int lDepth = calMinDepth(root.left, depth + 1);
    int rDepth = calMinDepth(root.right, depth + 1);

    return (lDepth >= rDepth) ? rDepth : lDepth;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.right = new TreeNode(9);
    root.left = new TreeNode(20);
    root.right.right = new TreeNode(15);
    root.right.left = new TreeNode(17);

    int minDepth = minDepth(root);
    System.out.println("minDepth: " + minDepth);
  }
}
