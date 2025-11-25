class NumMatrix {
    // we creat a prefix sum in o(m*n) and then from that i can use that to get sum in o(1)
    // https://youtu.be/KE8MQuwE2yA
    int[][] prefSum ;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // for easy edge case easy calculation

        prefSum = new int[m+1][n+1];


        for(int i= 0;i<m;i++){
            // calculate the values for that row
            int rowSum = 0;
            for(int j =0;j<n;j++){
                rowSum += matrix[i][j];
                // now to store we store in row + 1 and col + 1
                // so our prefix sum of top is also not row - 1
                // but just row and col
                int above = prefSum[i][j + 1];
                prefSum[i + 1][j + 1] = above + rowSum;
            }
        }
        
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // now we can do some math
        int totalSum = prefSum[row2 + 1][col2 + 1];

        // now get the sum for the 
        int top = prefSum[row1][col2 + 1];
        int left = prefSum[row2 + 1][col1];
        int leftCorner = prefSum[row1][col1];

        return totalSum - top - left + leftCorner;
    }
}