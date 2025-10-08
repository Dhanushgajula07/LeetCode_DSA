


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // Start by giving 1 candy to everyone

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        // Right to left with sum
        int total = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            total += candies[i];
        }

        return total;
    }
}




// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int up = 0 ,down = 0,peek = 0;
//         int total = 1;

//         for(int i = 1;i<n;i++){
//             // 3 conditions
//             if(ratings[i] > ratings[i-1]){
//                 down = 0;
//                 up++;
//                 peek = up;
//                 total += up + 1;
//             }
//             else if(ratings[i] == ratings[i-1]){
//                 up = down = peek = 0;
//                 total += 1;
//             }
//             else{ // ratings[i] < ratings[i - 1];
//                 up = 0;
//                  down++;
//                  total += down;
//                  if(down > peek){
//                     total += 1;
//                  }
//             }
//         }

//         return total;
//     }
// }