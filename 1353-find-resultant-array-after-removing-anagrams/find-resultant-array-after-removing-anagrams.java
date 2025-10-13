class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        // its better to add all now and delete becaus eof methods
        for(String str : words){
            ans.add(str);
        }

        for(int i = 1;i<ans.size();i++){
            if(isAnagram(ans.get(i-1),ans.get(i))){
                ans.remove(i);
                i--; // not to skip all other
            }
        }

        return ans;
    }
    public boolean isAnagram(String str1,String str2){
        // base case
        int n = str1.length();
        int n1 = str2.length();

        if(n != n1) return false;
        int [] freq = new int[26];

        for(char c : str1.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : str2.toCharArray()){
            freq[c - 'a']--;
            if(freq[c - 'a'] <0){
                return false;
            }
        }

        return true;
    }
}