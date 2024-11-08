public class DeleteLeavesWithAGivenValue {

   public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
   }

  public static TreeNode removeLeafNodes(TreeNode root, int target) {

     //base conditions
    if(root == null) return null;
    if(root.left == null && root.right == null && root.val == target) return null;

    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    return ((root.left == null && root.right == null && root.val == target) ? null : root);
  }

  public static void printTree(TreeNode root) {
    if(root == null) return;
    printTree(root.left);
    System.out.print(root.val+" ");
    printTree(root.right);
  }

  public static void main(String[] args) {

     int target = 2;

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);

    System.out.println("Before removing leaf nodes with value "+target+" :");
    printTree(root);
    TreeNode result = removeLeafNodes(root, target);
    System.out.println("\nAfter removing leaf nodes with value "+target+" :");
    printTree(result);

  }
}
