class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // its a varient of dijekstar becuase single source shportest path with +ve weights
        // i use PQ and a parent array

        // very much similar to normla queue approach but i add only if not visited or visited with less cost now

        ArrayList<ArrayList<int[]>> adjlist = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        for(int i = 0 ;i<=n;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjlist.get(u).add(new int[] {v,w});
        }
        
        int[] parent = new int[n +1 ];
           
        for(int i =1;i<=n;i++){
            parent[i] = Integer.MAX_VALUE;
        }
        parent[k] = 0;
        // source is k
        pq.offer(new int[] { k,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int w = node[1];

            for(int[] adj : adjlist.get(u)){
                int v = adj[0];
                int wtnext = adj[1];

                if(w + wtnext <parent[v]){
                    // now i can offer
                    parent[v] = w + wtnext;
                    pq.offer(new int[] {v ,parent[v]});
                }
            }
        }


        int max = 0;
    for (int i = 1; i <= n; i++) {
            if (parent[i] == Integer.MAX_VALUE) return -1; // Unreachable
            max = Math.max(max, parent[i]);
        }

        return max;
    }
}