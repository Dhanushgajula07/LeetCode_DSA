class Solution {
    public String minWindow(String s, String t) {
        // lets build the pattern 1st
        int[] t_freq = new int[256];
        for(int i = 0;i<t.length();i++){
            t_freq[t.charAt(i)]++;
        }

        int required = 0;
        for(int i : t_freq){
            if(i > 0){
                required++;
            }
        }

        int [] s_freq = new int[256];
        int formed = 0;

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        // now lest do the thing
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            s_freq[c ]++;

            if(t_freq[c] > 0 && t_freq[c] == s_freq[c]){
                formed++;
            }

            while(l <= i && formed == required){
                // save and shrink
                
                if((i - l + 1) < minLen){
                    minLen = i - l + 1;
                    minLeft = l;
                }
                char cc = s.charAt(l);
                s_freq[cc]--;
                if(t_freq[cc] > 0 && s_freq[cc] < t_freq[cc]){
                    formed--;
                }
                l++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}