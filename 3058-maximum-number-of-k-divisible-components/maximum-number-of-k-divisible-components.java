class Solution {
    int count = 0;
    int k;
    int[] values;
    List<List<Integer>> adj;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        return count + 1;   // always count + 1
    }

    private long dfs(int node, int parent) {
        long sum = values[node]; // use long to prevent overflow
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            long childSum = dfs(neighbor, node);
            if (childSum % k == 0) {
                count++;  // can cut here
            } else {
                sum += childSum; // cannot cut, pass up
            }
        }
        return sum;
    }
}
