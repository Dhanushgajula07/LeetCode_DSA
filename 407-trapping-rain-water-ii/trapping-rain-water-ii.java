class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0; // no water can be trapped

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // 1️⃣ Add all boundary cells to min-heap
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int water = 0;

        // 2️⃣ BFS from lowest boundary
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
                visited[nx][ny] = true;

                // if current boundary is higher than neighbor, water is trapped
                water += Math.max(0, h - heightMap[nx][ny]);

                // push the higher of boundary or neighbor
                pq.offer(new int[]{nx, ny, Math.max(h, heightMap[nx][ny])});
            }
        }

        return water;
    }
}
