class Solution {
    private static Node root;
    
    Solution(){
        root = new Node();
    }

    //Initialization of TRIE
    class Node{
        Node[] characters = new Node[10]; //0 to 9
        boolean flag = false;
        Node(){
            //Initialize 
        }

        //Common methods
        boolean containsKey(char ch){
            return (characters[ch-'0']!=null);
        }
    
        Node getNode(char ch){
            return characters[ch-'0'];
        }
    
        void putNode(char ch,Node node){
            characters[ch-'0'] = node;
        }
    
        void setEnd(){
            flag = true;
        }
    
        boolean isEnd(){
            return flag;
        }

        //Core Execution Methods
        //insertion of element
        public void insert(String word){
            Node node = root;
            for(int i=0;i<word.length();i++){
                if(!node.containsKey(word.charAt(i))){
                    node.putNode(word.charAt(i), new Node());
                }
                node = node.getNode(word.charAt(i));
            }
            node.setEnd();
        } 
        //find the length of the number
        int check(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                    if(node.containsKey(ch)){
                    node = node.getNode(ch);
                    }else{
                    return i;
                    }
        }
            return word.length();
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new Node();
        Node trie = new Node();
        int maxLength=0;
        //insert elements in TRIE
        for(int array:arr2){
            trie.insert(String.valueOf(array));
        }
        //find the longest positive integer
        for(int array : arr1){
            maxLength=Math.max(maxLength,trie.check(String.valueOf(array)));
        }
        return maxLength;
    }
}