import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InfectedBinaryTree {

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

    private static int maxDistance = 0;
    public static int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return maxDistance;
    }

    public static int traverse(TreeNode root, int start) {

        int depth =0;

        if(root == null) return depth;

        int leftDepth = traverse(root.left,start);
        int rightDepth = traverse(root.right,start);

        if(root.val == start){
            maxDistance = Math.max(leftDepth,rightDepth);
            depth = -1;
        }else if(leftDepth>=0 && rightDepth>=0){
            depth = Math.max(leftDepth,rightDepth) + 1;
        }else{
            int calDist = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(calDist,maxDistance);
            depth = Math.min(leftDepth,rightDepth) - 1;
        }

        return depth;
    }
    public static void main(String[] args) {

        // tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        int time = amountOfTime(root,3);

        System.out.println(time);

    }
}
