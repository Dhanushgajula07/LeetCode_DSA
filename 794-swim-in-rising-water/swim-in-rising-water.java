// class Solution {
//     class custome{
//         int [] index;
//         int time;
//         custome(int[] index,int time){
//             this.index = index;
//             this.time = time;
//         }
//     }
// public int swimInWater(int[][] grid) {
//     // so the thing to remember is about time and how it increass
//     // so its finding the shortest path --> dijkstra
//     // lets use pq and a custome class that sorts on next time
//     int m = grid.length;
//     int n = grid[0].length; 
//         int[][] directions = {{+1,0},{-1,0},{0,+1},{0,-1}};
//         boolean[][] visited = new boolean[m][n];
//         PriorityQueue<custome> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.time,b.time));
//         pq.add(new custome(new int[]{0,0}, grid[0][0]));

//         while(!pq.isEmpty()){
//             custome curr = pq.poll();
//             int i = curr.index[0];
//             int j = curr.index[1];
//             int past_time = curr.time;
//             if(visited[i][j]) continue;
//             visited[i][j] = true;
//             // i can all 4 direcvtoins
//             if(i == m-1 && j == n- 1){
//                 // goal reached
//                 return past_time;
//             }

//             for(int [] dir : directions){
//                 int ni = i + dir[0];
//                 int nj = j + dir[1];
//                 int newTime = 0;
//                 if(ni >= 0 && nj >= 0 && ni < m && nj <n && !visited[ni][nj]){ // valid dir
//                 if(grid[ni][nj] > past_time){
//                     newTime = Math.max(past_time , grid[ni][nj]);
//                     pq.add(new custome( new int[]{ni,nj} , newTime));
//                 }
//                 else{
//                     pq.add(new custome(  new int[]{ni,nj}, past_time));
//                 }
//                 }
//             }
//         }

//         return 0;
//     }
// }

class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 1. find
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        //2. union by size
        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return;

            if (size[pu] > size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int swimInWater(int[][] grid) {
        // so the thing to remember is about time and how it increass
        // so its finding the shortest path --> dijkstra
        // lets use pq and a custome class that sorts on next time

        // its perfrctly a minimum spanning tree // kruskals algo
        // sort.. pick one by one
        // if both are same that mean connected
        // then just return else connect and continue

        // 1. lets convert 2d to list 
        // easy sort ( i * n + j) sort based on grid
        // sort it then pick one and then explore all ist 4 directions 
        // if next <. curr then union
        // check if both are under same cmponent then return ans

        
        int m = grid.length;
        int n = grid[0].length;
        DSU dsu = new DSU(m * n );
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++)
            list.add( i * n + j);
        }

        Collections.sort(list, (a,b) -> grid[a  / n][a%n] - grid[b / n][b%n]);


        int[][] directions = {{+1,0},{-1,0},{0,-1},{0,+1}};

        for(Integer position : list){
            int r = position / n;
            int c = position % n;

            // loop all the side
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                // cehck valid
                if(nr>=0 && nc>=0 && nr<m && nc < n){
                    if(grid[nr][nc] <= grid[r][c]){
                        // union
                        dsu.union((r * m + c),(nr * m + nc));
                    }
                }
            }
            if(dsu.find(0) == dsu.find(n * n - 1)){
                return grid[r][c];
            }
        }
            return -1;
    }
}