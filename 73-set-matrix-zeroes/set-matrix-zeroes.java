class Solution {
    public void setZeroes(int[][] matrix) {
     // so i can solve it with 2 * O(M * n)  Time and O(M) +O(N) Space
     int m = matrix.length; // rows
     int n = matrix[0].length; // colms
     int[] rows = new int[m];
     int[] colm = new int[n];

     // now traverse and mark the row and colums
     for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(matrix[i][j] == 0){
                rows[i] = -1;
                colm[j] = -1;
            }
        }
     }

     // now traverse again and if you see its row or colm as -1 fill back to 0

     for(int i= 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(rows[i] == -1 || colm[j] == -1){
                matrix[i][j] = 0;
            }
        }
     }
    }
}