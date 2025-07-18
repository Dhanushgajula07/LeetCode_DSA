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
    private HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        // so basically its a typr of node by node travrsal 
        // i taverse one node and i skip next adjacent nodes
        // if i dont then i can still pick the next

        // its of type not leaf to leaf 
        // not any node to any
        // but its all nodes

        // i have a CHIOCE OF pick or no pick
        // if i pick i should go left.left and left.right (offcourse check the valid condition)
        // same foe right sub tree also

        // now come 2nd step
        // return or max?
        // max is used if any path might have answer but here we have only one so return

        return dfs(root); 
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        if(memo.containsKey(node)){
            return memo.get(node);
        }
        // pick
        int pick = node.val;
        if(node.left != null){
            pick += dfs(node.left.left) + dfs(node.left.right); 
        }
        if(node.right != null){
            pick += dfs(node.right.left) + dfs(node.right.right);
        }

        int nopick = 0 + dfs(node.left) + dfs(node.right);

        int ans = Math.max(pick,nopick);
        memo.put(node,ans);
        return ans;
    }
}