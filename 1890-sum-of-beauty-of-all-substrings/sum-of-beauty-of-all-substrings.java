class Solution {
    public int beautySum(String s) {
        // so its constraint is < 500 so we can use brute force
        // generate all substring
        // and for each substring we will find the beauty and sum it up with the valuse
        int sum = 0;

        int n = s.length();
        for(int i=0;i<n;i++){
            int[] fre = new int[26];
            for(int j = i;j<n;j++){
                // substrings created 
                // now for each sub string get max frequency and min frequency
                fre[s.charAt(j) - 'a']++;

            int max = 0, min = Integer.MAX_VALUE;
            for (int f : fre) {
                if (f > 0) {
                    max = Math.max(max, f);
                    min = Math.min(min, f);
                }
            }
                sum += max - min;
            }
        }
        return sum;
    }
}