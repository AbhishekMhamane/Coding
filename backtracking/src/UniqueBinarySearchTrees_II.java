import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class UniqueBinarySearchTrees_II {

    public class TreeNode {
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

    // Solution 1
  public List<TreeNode> generateTrees(int n) {
      List<TreeNode>  result = new ArrayList<>();
      List<Integer> numMap = new ArrayList<>();
      Set<String> uniqueTrees = new HashSet<>();
      // add all the numbers from 1 to n
      for(int i=1; i<=n; i++){
        numMap.add(i);
      }
      generateTreesHelper(0, n, uniqueTrees, numMap, result);
      return result;
  }

  public void generateTreesHelper(int index, int n, Set<String> uniqueTrees,List<Integer> numMap, List<TreeNode>  result){
    //base condition
    if(index == n) {
      TreeNode rootNode = createBST(numMap);
      if (rootNode != null) {
        String serializedTree = serializeTree(rootNode);
        if (!uniqueTrees.contains(serializedTree)) {
          result.add(rootNode);
          uniqueTrees.add(serializedTree);
        }
      }
      return;
    }
    Set<Integer> set = new HashSet<>();
    //choices
    for(int i=index; i<n; i++){
      if(!set.contains(numMap.get(i))){
        set.add(numMap.get(i));
        Collections.swap(numMap,index,i);
        generateTreesHelper(index+1, n, uniqueTrees, numMap, result);
        Collections.swap(numMap,index,i);
      }
    }
  }

  public String serializeTree(TreeNode root) {
    if (root == null) {
      return "#";
    }
    return root.val + "," + serializeTree(root.left) + "," + serializeTree(root.right);
  }

  public TreeNode createBST(List<Integer> numMap){
      TreeNode root = null;
      for(int i : numMap){
        root = insertNode(root, i);
      }
      return root;
  }

  public TreeNode insertNode(TreeNode root, int num){
    if(root == null) return new TreeNode(num);
    if(num < root.val) root.left = insertNode(root.left, num);
    else if(num > root.val) root.right = insertNode(root.right, num);
    return root;
  }

  public void printBST(TreeNode treeNode){
      if(treeNode == null){
        System.out.print("null->");
        return;
      }
     System.out.print(treeNode.val + "->");
     printBST(treeNode.left);
     printBST(treeNode.right);
  }

  // solution 2
  public List<TreeNode> generateTrees2(int n) {
    return generateTreesHelper2(1, n);
  }

  public List<TreeNode> generateTreesHelper2(int start, int end){

    List<TreeNode>  result = new ArrayList<>();
    //base condition
    if(start > end) {
      result.add(null);
      return result;
    }
    //choices
    for(int i=start; i<=end; i++){
      List<TreeNode> leftTree = generateTreesHelper2(start, i-1);
      List<TreeNode> rightTree = generateTreesHelper2(i+1, end);

      for(TreeNode left : leftTree){
        for(TreeNode right : rightTree){
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          result.add(root);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    UniqueBinarySearchTrees_II bst = new UniqueBinarySearchTrees_II();
//    System.out.println(bst.generateTrees(3));
    System.out.println(bst.generateTrees2(3));
  }
}
