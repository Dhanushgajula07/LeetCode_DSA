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

    // now since i have both the methods fro max and creaitng trie 
    // i will ise one by one number to get the max of all

    public int findMaximumXOR(int[] nums) {
        // their are 2 steps of solving this prioblem /
        // 1. build the tree
        // 2. loop through the numbers and doing canculation  technique

        // despite any problme core logic is asame

        Trie trie = new Trie();
        for(int num : nums){
            trie.insert(num);
        }

        int max = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
                max = Math.max(max, trie.max(nums[i]));
        }
        return max;
    }
}