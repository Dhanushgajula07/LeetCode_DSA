class Solution {
    public String countAndSay(int n) {
        // its more likely the simulation algorithm
        // their are many like design tweer check note

        // here i can use iteration an drecursive approach
        // even though time comnlexity is 10^9 it still passes because itsv not always doubles the next calls

        // i will use nested loops 

        
        String ans = "1";
    if(n == 1) return ans;
        for(int i = 2 ;i<= n;i++){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            char current = ans.charAt(0);

            for(int j =1;j<ans.length();j++){
                // if same as of prev
                if(ans.charAt(j) == current){
                    count++; // just incremet the count
                }
                else{
                    sb.append(count).append(current);
                    count = 1; // add and update the b=next batch
                    current = ans.charAt(j);
                }
            }
            sb.append(count).append(current); // for the final bastch
            ans = sb.toString(); // passed as new ans  to next iteration
        }
        return ans;
    }
}