class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size(); // nodes in this level

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // LEAF NODE → answer found
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            depth++; // finished one full level
        }
        return depth;
    }
}
