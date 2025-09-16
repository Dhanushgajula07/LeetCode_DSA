class Solution {
    public void setZeroes(int[][] matrix) {
        int col =1;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] ==0){ // if need mnarking
                    matrix[i][0] = 0; // mark row no problem
                    if(j != 0){ // mark col only its its not the 1st col
                        matrix[0][j] = 0;
                    }
                    else{ // need extra var because iotys a conflict while marking all zeros
                        col = 0;
                    }
                }
            }
        }

        // now lets solve it 
        // 1. 1st mark a smnaller square
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] ==0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 2. lets mark the 1st row

        if(matrix[0][0] == 0){
            for(int i = 0;i<n;i++){
                matrix[0][i] = 0;
            }
        }

        //3. lets mark the 1st col
        if(col == 0){
            for(int i = 0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}