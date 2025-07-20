/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        return dfs(root,p,q);
    }
    public TreeNode dfs(TreeNode node, TreeNode p,TreeNode q){
        if(node == null || node == p || node == q){
            return node;
        }
        TreeNode left  = dfs(node.left,p,q);
        TreeNode right = dfs(node.right,p,q);
        if(left != null && right != null){
            return node;
        } 
        if(left == null){
            return right;
        }
        else{
            return left;
        }
    }
}