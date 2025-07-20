/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// class Solution {
//     public int maxDepth(TreeNode root) {
//         return dfs(root,0);
//     }
//     private static int dfs(TreeNode root,int height){
//         // get left height
//         // get right hright
//         // max of it


//         // base
//         if(root == null) return height;
//         int left = dfs(root.left,height + 1);
//         int right = dfs(root.right,height + 1);
//         return Math.max(left,right);
//     }
// }


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root);
    }
    public int dfs(TreeNode node){
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        return 1 + Math.max(left,right);
    }
}