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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // so its the exact tenplet but the catch is that root is fixed and leaf can be anything
        // so now i dont think so we need max[]
        // just return will work
        
        // ist a singke source and multiple destinaon
        
         return solve(root,targetSum,0);
    }
    public boolean solve(TreeNode node,int target,int currsum){
        // base case is clear if im at leaft node and adding up it is maing the sum == target
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            currsum += node.val;
            if(currsum == target) return true;
            else return false;
        }

        currsum += node.val;
        // hypothesis
        boolean left = solve(node.left,target,currsum);
        boolean right = solve(node.right,target,currsum);

        if (left || right){
            return true;
        }
        return false;
    }
}