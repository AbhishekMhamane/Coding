import java.util.ArrayList;
import java.util.List;

public class PathSum_II {

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


  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    pathSumHelper(root, new ArrayList<Integer>(), result, targetSum);
    return result;
  }

  public static void pathSumHelper(TreeNode root, List<Integer> temp, List<List<Integer>> result, int targetSum){

    //base condition
    if(root == null) return;
    if(root.left == null && root.right==null){
      temp.add(root.val);
      calculateSum(temp, targetSum, result);
      temp.remove(temp.size()-1);
      return;
    }

    // add current node value to temp list
    temp.add(root.val);

    // choices
    pathSumHelper(root.left, temp, result, targetSum);
    pathSumHelper(root.right, temp, result, targetSum);

    // remove current node from temp list
    temp.remove(temp.size()-1);
  }

  public static void calculateSum(List<Integer> temp, int targetSum, List<List<Integer>> result){
      int sum = 0;
      for(int i : temp){
        sum = i + sum;
      }
      if(sum == targetSum){
        result.add(new ArrayList<>(temp));
      }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);

    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right= new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);

//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);

    System.out.println(pathSum(root, 22));
  }
}
