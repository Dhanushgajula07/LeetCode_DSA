class Solution {
        class Node{
        // it has 2 nodelinks
        Node []  links = new Node[2];

        // mehtod to check if already prestn or no
        boolean contains(int num){
            return links[num] != null;
        }

        // methiod to set
        void set(int num,Node node){
            links[num] = node;
        }

        // method to get the node ehich is set
        Node get(int num){
            return links[num];
        }
    }

    class Trie{
        Node root = new Node();
        public void insert(int num){
            Node node = root;
            for(int i =31;i>=0;i--){
                int bit = (num >> i) & 1;
                if(!node.contains(bit)){
                    // create 
                    node.set(bit,new Node());
                }
                node = node.get(bit);
            }
        }
        // since you have a tree lest try to find the max which value is X
        // this is inside the Trie class
        public int max(int num){
            Node node = root;
            int max = 0;
            for(int i =31;i>=0;i--){
                int bit = (num >> i) & 1;
                int oppositebit = 1 - bit;
                if(node.contains(oppositebit)){
                    max |= (1 << i);// set the bit
                    node = node.get(oppositebit);
                }
                else{
                    node = node.get(bit);
                }
            }
            return max;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        // Store original index because we'll sort queries
        int[][] extendedQueries = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            extendedQueries[i][0] = queries[i][0]; // x
            extendedQueries[i][1] = queries[i][1]; // m
            extendedQueries[i][2] = i;             // original index
        }

        // Sort queries based on m (the upper bound constraint)
        Arrays.sort(extendedQueries, (a, b) -> Integer.compare(a[1], b[1]));

        Trie trie = new Trie();
        int[] ans = new int[queries.length];
        int index = 0;

        for (int[] query : extendedQueries) {
            int x = query[0];
            int m = query[1];
            int qIndex = query[2];

            // Insert only numbers ≤ m into the trie
            while (index < nums.length && nums[index] <= m) {
                trie.insert(nums[index]);
                index++;
            }

            if (index == 0) {
                // No elements ≤ m
                ans[qIndex] = -1;
            } else {
                ans[qIndex] = trie.max(x);
            }
        }

        return ans;
    }
}