class Trie {
    // its a prefix tree
    // its a retrivel tree
    
    //it will have a node which has 26 child nodes address and a boolean to chekc end of word

    class Node{
        Node[] children;
        boolean eow;
        Node(){
            children = new Node[26];
            // since i check if child is null or no...
            // so i should initialise all 26with null
            for(int i = 0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }
    }

    // declare empty roo
    private Node root;

    public Trie() {
        // 1. i should have empty root
         root = new Node();
    }
    
    public void insert(String word) {
        // so for insertion i will check character by charated if not present tyhen i insert
        // how do i check? if its just tree i will have just lefta and right child 
        // but here i have 26 childerend so i will check childeren[node] != null ?

        // so 1st create a node pointer
        Node node = root;

        // niow char by char
        for(char ch : word.toCharArray()){
            int idx = ch - 'a'; // index to check 
            if(node.children[idx] == null){ // its not present 
                // time to insert the niode
                node.children[idx] = new Node(); // it not their then creat no need to add anything becauyse idx implifies that its that char... so just creat and showung the presence us enought
            }
            node = node.children[idx]; // moving to the child for checking next character
        }
        node.eow = true; // mark wnd of word
    }
    
    public boolean search(String word) {
        // now lets search its the same code but
        // if we reach the end of the string and then we see eow === true then its true
         // so 1st create a node pointer
        Node node = root;

        // niow char by char 
        for(char ch : word.toCharArray()){
            int idx = ch - 'a'; // index to check 
            if(node.children[idx] == null){ // its not present 
                // no need to create just rerurn false
                return false;
            }
            node = node.children[idx]; // moving to the child for checking next character
        }
        if(node.eow == true){
            return true;
        } // mark wnd of word
        return false;
    }
    
    public boolean startsWith(String prefix) {
        // now lets search its the same code but
        // if we reach the end of the string and then we see eow === true then its true
         // so 1st create a node pointer
        Node node = root;

        // niow char by char 
        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a'; // index to check 
            if(node.children[idx] == null){ // its not present 
                // no need to create just rerurn false
                return false;
            }
            node = node.children[idx]; // moving to the child for checking next character
        }
        // if(node.eow != true){
        //     return true;
        // } // mark wnd of word


        // no need to check 
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */