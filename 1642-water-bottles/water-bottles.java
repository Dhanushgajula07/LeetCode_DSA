class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int full = numBottles;
        int empty = 0;

        while(full >  0){
            total += full; // drink all the full bottles
            empty += full; // all full becomes empty
            // now all the full bottels becomes empty
            full = empty / numExchange;
            empty = empty % numExchange;
        }
        return total;
    }
}