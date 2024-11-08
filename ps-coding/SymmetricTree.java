public class SymmetricTree {
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
    
      public static boolean isSymmetric(TreeNode root) {
        return findIsTreeSymmetric(root.left, root.right);
      }
    
      public static boolean findIsTreeSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
    
        if (left != null && right == null) return false;
    
        if (left == null && right != null) return false;
    
        if (left.val != right.val) return false;
    
        return (
            (findIsTreeSymmetric(left.left, right.right) == true) &&
            (findIsTreeSymmetric(left.right, right.left) == true)
          )
          ? true
          : false;
      }
    
      public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
    
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
    
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
    
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
    
        System.out.println("Is Tree Symmetric : " + isSymmetric(root));
      }

}
