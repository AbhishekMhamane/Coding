import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    travelTreeHelper(root, new ArrayList<Integer>(), result);
    return result;
  }

  public static void travelTreeHelper(TreeNode node, List<Integer> path, List<String> res){

    //base condition
    if(node.left==null && node.right==null){
      path.add(node.val);
      res.add(convertPathToString(path));
      path.remove(path.size()-1);
    }

    path.add(node.val);

    // choices
    if(node.left!=null){
      travelTreeHelper(node.left, path,res);
    }
    if(node.right!=null){
      travelTreeHelper(node.right, path,res);
    }
    path.remove(path.size()-1);
  }

  public static String convertPathToString(List<Integer> path){
    StringBuilder sb = new StringBuilder();
    int len = path.size();
    int i=0;
    for (int num : path) {
      if(i==len-1){
        sb.append(num);
        break;
      }
      sb.append(num + "->");
      i++;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);

    List<String> result = binaryTreePaths(root);
    for(String s : result){
      System.out.println(s);
    }
  }
}
