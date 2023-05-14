public class PathSum {

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

  public static boolean checkHasPathSum(
    TreeNode root,
    int targetSum,
    int calSum
  ) {
    if (root == null) return false;

    int sum = root.val + calSum;

    if (
      sum == targetSum && root.left == null && root.right == null
    ) return true;

    if (
      checkHasPathSum(root.left, targetSum, sum) ||
      checkHasPathSum(root.right, targetSum, sum)
    ) return true;

    return false;
  }

  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    return checkHasPathSum(root, targetSum, 0);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(-2);
    root.right = new TreeNode(-3);

    System.out.println("Has Target Sum : " + hasPathSum(root, -5));
  }
}
