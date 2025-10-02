class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = 0;
        int full = numBottles;
        int empty = 0;

        while(full >  0){
            total += full; // drink all the full bottles
            empty += full; // all full becomes empty
            // now all the full bottels becomes empty
            
            if(empty >= numExchange){
            empty -= numExchange;
            full = 1;
            numExchange++;
            }
            else{
                break;
            }
        }
        return total;
    }
}

