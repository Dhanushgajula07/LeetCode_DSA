class Solution {
    public int largestRectangleArea(int[] heights) {
        // so ist NSL and NSR
        // and get the right - left -1 = len
        // wid = len * arr[i]
        ArrayList<Integer> NSL = getNSL(heights);
        ArrayList<Integer> NSR = getNSR(heights);
        int n = heights.length;
        int[] length = new int[n];
        for(int i = 0;i<n;i++){
            length[i] = NSR.get(i) - NSL.get(i) - 1;
        }

        // ans
        int ans = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            int val = length[i];
            int area = val * heights[i];
            ans = Math.max(ans,area);
        }

        return ans;
    }
    private  ArrayList<Integer> getNSL(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        for(int i =0;i<arr.length;i++){
            while(!st.isEmpty() && st.peek()[0] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                list.add(-1); // -1 fro LEFT
            }
            else{
                list.add(st.peek()[1]);
            }
            st.push(new int[] { arr[i],i});
        }
        return list;
    }
    private ArrayList<Integer> getNSR(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        for(int i =arr.length - 1;i >= 0;i--){

            while(!st.isEmpty() && st.peek()[0] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                list.add(arr.length); // -1 fro LEFT
            }
            else{
                list.add(st.peek()[1]);
            }
            st.push(new int[] { arr[i],i});
        }
        Collections.reverse(list);
        return list;
    }  
}