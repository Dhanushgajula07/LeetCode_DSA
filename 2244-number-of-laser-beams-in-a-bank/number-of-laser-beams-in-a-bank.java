class Solution {
    public int numberOfBeams(String[] bank) {
     // start from the right start 
        int n = bank.length;
        // code to chck weather that bank[i] has 1's or no
        // if yes how many
        int start=0;
        int prev = 0;
        while(start < n){
            prev = getCount(bank[start]);
            if(prev > 0) break;
            start++;
        }
        int ans = 0;
        for(int i = start + 1;i<n;i++){
            int count = getCount(bank[i]);
            if(count > 0){
            ans += prev * count;
            prev = count;
            }
        }
        return ans;   
    }
    public int getCount(String str){
        int count = 0;
        for(char c : str.toCharArray()){
            if(c == '1'){
                count++;
            }
        }
        return count;
    }
}