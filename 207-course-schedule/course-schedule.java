class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // so its clearly topo sort
        // create an adjlist // and an indegree array

        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0;i< numCourses;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adjlist.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        } 
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int adj : adjlist.get(node)){
                // visit all its nrighbours and all only if their indegree is 0
                indegree[adj]--;
                if(indegree[adj] == 0){
                    q.offer(adj);
                }
            }
        }

        return ans.size() == numCourses;
    }
}