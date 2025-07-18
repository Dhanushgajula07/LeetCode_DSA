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
 */class Solution {
        public int maxPathSum(TreeNode root) {
        // main catch is that node can appear atmopst once..
        // and also path might ot might not pass thorugh the root
        // ans its any non empty path

        // its like if the answer from left or right is going  -ve then we just return that node
        // its of type any node to node
        // and we also want the max global var or int[] max

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        solve(root,max);
        return max[0];
        }
        public int solve(TreeNode node,int[] max){
            // so this the templet
            // int return,
            // max[] actual answer if any to any
            // solve method with IBH---> 
            // now get the temp answer and also check can you be he bigger answer

            // base case
            if(node == null){
                return 0;
            }

            // left and rigth
            int left = Math.max(0,solve(node.left,max));

            int right = Math.max(0,solve(node.right,max));


            // it does not fallow the tree rules
            int temp = node.val + left + right;
            max[0] = Math.max(max[0],temp);

            return node.val + Math.max(left,right);
        }
 }