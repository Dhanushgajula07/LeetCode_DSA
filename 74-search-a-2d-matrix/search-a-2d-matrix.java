class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // so this is the concept that i got in Amazon interview and i did not get it right 
        // that time but now i got it

        // row = mid / m;
        // col = mid % m;
        // m = no of cols
        // n =no of rows
        // and apply binary search for arr[row][col] and manuplate low and high
        // low = 0 
        // high = n + m - 1 -> because when you flattern that many no of elements you get

        int n = matrix.length;
        int m = matrix[0].length;

        // edghe case
        if(n == 0 || m == 0) return false;
        int low = 0;
        int high = n * m - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            // now get the row and col of that row
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return false;
    }
}