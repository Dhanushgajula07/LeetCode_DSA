class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[] building = new int[m]; // columns bbecause buildings

        //edge
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        // ist find for ist row on each col
        for (int j = 0; j < m; j++) {
            building[j] = matrix[0][j] - '0';
        }
        // call for 1st
        ans = get_MAH(building, m);

        // now lets add builddengs on bottom
        // add only  if down is 1 else complete 0

        // fom row 1 to n
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    building[j] = 0;
                } else {
                    building[j] += 1;
                }
            }

            ans = Math.max(ans, get_MAH(building, m));
        }

        return ans;
    }

    private static int get_MAH(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // should be MIN_VALUE
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) { // loop until n (add extra iteration to flush)
            int currHeight = (i == n) ? 0 : arr[i]; // treat end as zero to flush stack

            // conflict: current height breaks previous increasing bars
            while (!st.isEmpty() && arr[st.peek()] >= currHeight) {
                int idx = st.pop(); // index of popped bar
                int height = arr[idx];

                int nsl = (st.isEmpty()) ? -1 : st.peek(); // NSL is index below in stack
                int nsr = i; // current i is NSR

                int width = nsr - nsl - 1; // width formula
                int area = height * width;

                if (area > maxi)
                    maxi = area;
            }
            st.push(i);
        }

        return maxi;
    }
}

//     ✨ Your intuition summarized:
// When you’re iterating through the array:

// \U0001f449 Every time you try to push a new element into the stack, you are essentially saying:
// “Hey, let me stand here taller than whoever is behind me.”

// BUT

// ➡️ If a conflict occurs (i.e., current element is smaller than the top of the stack):

// That means → The element at the top of the stack can’t extend further right because you’ve found a smaller height that will block it.

// Therefore, you are the NSR (Next Smaller to Right) for that element.

// And for that popped element, its NSL is whoever is underneath it in the stack (since the stack maintains increasing order from bottom to top).

// can reuse nsl and nsr same stack

//     private static int get_MAH(int []arr,int n){
//     // NSL
//     // NSR
//     // width
//     // area
//     // max_area

//     // NSL
//     ArrayList<Integer> nsl_list = new ArrayList<>();
//     Stack<int[]> nsl = new Stack(); // val,index
//    // left ---> 
//     for(int i=0;i<n;i++){ // greater so remove >=
//         while(!nsl.isEmpty() && nsl.peek()[0] >= arr[i]){
//             nsl.pop();
//         }
//         if(nsl.isEmpty()){
//             nsl_list.add(-1);
//         }
//         else{
//             nsl_list.add(nsl.peek()[1]);
//         }

//         nsl.push(new int[]{arr[i],i});
//     }

//         // NSR
//         ArrayList<Integer> nsr_list = new ArrayList<>();
//         Stack<int[]> nsr = new Stack(); // val,index
//        // <--- right
//         for(int i = n-1;i>=0;i--){ // greater so remove >=
//             while(!nsr.isEmpty() && nsr.peek()[0] >= arr[i]){
//                 nsr.pop();
//             }
//             if(nsr.isEmpty()){
//                 nsr_list.add(n);
//             }
//             else{
//                 nsr_list.add(nsr.peek()[1]);
//             }

//             nsr.push(new int[]{arr[i],i});
//         }
//         // reverse
//         Collections.reverse(nsr_list);

//         // ans array
//         int[] ans = new int[n];
//         int maxi = Integer.MIN_VALUE;
//         for(int i =0;i<arr.length;i++){
//             int val = (nsr_list.get(i) - nsl_list.get(i)) - 1;
//             int area = val * arr[i];
//             maxi = Math.max(area,maxi);
//         }

//         return maxi;
//     }
// }
