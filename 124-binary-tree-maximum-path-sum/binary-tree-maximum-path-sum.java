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


class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root,max);
        return max[0];
    }
    public int dfs(TreeNode root,int[] max){
        // base
        if(root == null){
            return 0;
        }
        // inductions
        int lm = Math.max(0,dfs(root.left,max));
        int rm = Math.max(0,dfs(root.right,max));

        max[0] = Math.max(max[0],lm + rm + root.val);

        return root.val + Math.max(lm,rm);
    }
}