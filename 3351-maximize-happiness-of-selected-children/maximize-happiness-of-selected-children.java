class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        int count = 0;
        int i = happiness.length - 1;

        while (k > 0 && i >= 0) {
            long curr = happiness[i] - count;
            if (curr <= 0) break;
            sum += curr;
            count++;
            i--;
            k--;
        }
        return sum;
    }
}