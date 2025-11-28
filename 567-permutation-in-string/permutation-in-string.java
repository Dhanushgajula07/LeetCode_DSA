class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // so all the chars should be present
        int m = s1.length();
        int n = s2.length();
        if(n < m) return false;

        // its a constant wondow
        int [] pattern  = new int[26];
        for(int i =0;i<m;i++){
            pattern[s1.charAt(i) - 'a']++;
        }

        int[] current = new int[26];

        for(int i = 0;i<m;i++){
            current[s2.charAt(i) - 'a']++;
        }

        if( Arrays.equals(pattern, current)) return true;

        int l = 0;
        for(int i = m;i<n;i++){
            current[s2.charAt(l) - 'a']--;
            current[s2.charAt(i) - 'a']++;
            if( Arrays.equals(pattern, current)) return true;
            l++;
        }

        return false;
    }
}