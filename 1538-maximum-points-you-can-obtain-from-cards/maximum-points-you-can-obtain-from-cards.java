class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // so basically i know tryhe approach its prefix sum + sliding window

        int n = cardPoints.length;
        if(n < k) return 0;

        // constant window
        int max = Integer.MIN_VALUE;

        int current = 0;
        for(int i = 0;i<k;i++){
            current += cardPoints[i];
        }
        // for noe this is max
        max = current;
        
        // now r-- l--
        int l = k - 1, r = n -1;
        while(l >= 0){
            current -= cardPoints[l];
            l--;
            current += cardPoints[r];
            r--;

            max = Math.max(max,current);
        }
        return max;
    }
}