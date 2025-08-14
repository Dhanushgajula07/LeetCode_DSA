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
//     public int minDepth(TreeNode root) {
//         return solve(root);
//     }
//     private static int solve (TreeNode root){
//         if(root == null) return 0;
//          if (root.left == null) return 1 + solve(root.right);
//          if (root.right == null) return 1 + solve(root.left);
//         int left = solve(root.left);
//         int right = solve(root.right);
//         return 1 + Math.min(left,right);
//     }
// }
class Solution {
    public int minDepth(TreeNode root) {
        return bfs(root);
    }

    public int bfs(TreeNode root) {
        if (root == null) return 0; // Handle empty tree

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode polled = q.poll();

                // Check if it's a leaf node
                if (polled.left == null && polled.right == null) {
                    return level;
                }

                if (polled.left != null) q.offer(polled.left);
                if (polled.right != null) q.offer(polled.right);
            }

            level++; // Increase after finishing one level
        }

        return level;
    }
}
