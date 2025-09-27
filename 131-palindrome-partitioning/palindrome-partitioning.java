class Solution {
    public List<List<String>> partition(String s) {
        // so its partiton based recursion
        List<List<String>> ans = new ArrayList<>();
        generate(0, s, new ArrayList<>(), ans);
        return ans;
    }
    public void generate(int idx,String s,ArrayList<String> current,List<List<String>> ans){
        if(idx == s.length()){
            ans.add(new ArrayList<String>(current));
            return;
        }

        for(int i =idx;i<s.length();i++){
            if(isPalindrome(s.substring(idx,i + 1))){
                // pick call remove
                current.add(s.substring(idx,i+1));
                generate(i + 1,s,current,ans);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() -1;

        while( i <  j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}