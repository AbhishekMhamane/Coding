import java.util.ArrayList;

public class LeafSimilarTrees {

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

      public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

          ArrayList<Integer> list1 = getLeftToRightList(root1);
          ArrayList<Integer> list2 = getLeftToRightList(root2);

          if(list1.equals(list2)) return true;

          return false;
      }

      public static ArrayList<Integer> getLeftToRightList(TreeNode root){

          ArrayList<Integer> list = new ArrayList<>();

          travelInorder(list,root);

          return list;
      }

      public static void travelInorder(ArrayList<Integer> list, TreeNode root){

          if(root == null) return;

          if(root.left == null && root.right == null){
              list.add(root.val);
          }

          travelInorder(list,root.left);
          travelInorder(list,root.right);
      }

      public static void main(String[] args) {

          // 1st tree
          TreeNode root1 = new TreeNode(3);
          root1.left = new TreeNode(5);
          root1.left.left = new TreeNode(6);
          root1.left.right = new TreeNode(2);
          root1.left.right.left = new TreeNode(7);
          root1.left.right.right = new TreeNode(4);

          root1.right = new TreeNode(1);
          root1.right.left = new TreeNode(9);
          root1.right.right = new TreeNode(8);

          // 2nd tree
          TreeNode root2 = new TreeNode(3);
          root2.left = new TreeNode(5);
          root2.left.left = new TreeNode(6);
          root2.left.right = new TreeNode(2);
          root2.left.right.left = new TreeNode(7);
          root2.left.right.right = new TreeNode(4);

          root2.right = new TreeNode(1);
          root2.right.left = new TreeNode(9);
          root2.right.right = new TreeNode(8);

          System.out.println(leafSimilar(root1,root2));
      }
}
