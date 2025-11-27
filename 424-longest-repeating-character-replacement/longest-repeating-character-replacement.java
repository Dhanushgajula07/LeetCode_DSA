// class Solution {
//     public int characterReplacement(String s, int k) {
//         // brute force
//         int n = s.length();
//         int max = 0;
//         for(int i = 0;i<n;i++){
//             for(int j = 0;j<n;j++){
//                 // for each sub string
//                 // get max frequency

//                 int max_freq = getMaxFreq(s,i,j);

//                 if((j - i + 1) - max_freq <= k){
//                     max = Math.max(max,j-i+1);
//                 }
//             }
//         }

//         return max;
//     }

//     private int getMaxFreq(String s, int l,int r){
//         int max = 0;
//         int[] freq = new int[256];

//         while(l<=r){
//             freq[s.charAt(l) - 'A']++;
//             max = Math.max(max,freq[s.charAt(l) - 'A']);
//             l++;
//         }

//         return max;
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {
        // now lets optimise our approach 
        // i should do it in one go
        // so i shoulde remember the freq and also shring when its not valid
        // what is not valid when changes required > k

        int n = s.length();
        int[] freq = new int[256];
        int max = 0;
        int maxFreq = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
            int changes = (i - l + 1) - maxFreq;
            // now shrink
            while ((i - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            max = Math.max(max, i - l + 1);
        }

        return max;
    }
}