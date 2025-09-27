class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // so lets solve it using greedy because its the optimisation pattern
        // sort the both
        Arrays.sort(g);
        Arrays.sort(s);

        int m = g.length;
        int n = s.length;

        int i = m-1;
        int j = n-1;

        int count =0;

        while(i >= 0 && j >= 0){
            if(g[i] <= s[j]){
            count++;
            i--;
            j--;
            }
            else if(g[i] > s[j]){
                // i--; // try for lesser greedy children
                // or should i increase the size ?
                i--;
            }
        }
        return count;
    }
}