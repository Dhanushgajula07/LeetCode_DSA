// class Solution {
//     public int countCollisions(String directions) {
//         int n = directions.length();
//         int left = 0, right = n - 1;
//         // Skip all leading 'L'
//         while (left < n && directions.charAt(left) == 'L') left++;
//         // Skip all trailing 'R'
//         while (right >= 0 && directions.charAt(right) == 'R') right--;
//         int collisions = 0;
//         // All cars in between that are not 'S' will eventually collide
//         for (int i = left; i <= right; i++) {
//             if (directions.charAt(i) != 'S') collisions++;
//         }
//         return collisions;
//     }
// }


class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        int collisions = 0;
        for(char curr : directions.toCharArray()){
            if(curr == 'R'){
                st.push('R');
            }
            else if(curr == 'L'){
                // if its empty just add
                if(st.isEmpty()){
                    st.push('L');
                }
                else if(!st.isEmpty() && st.peek() =='R'){
                    // thry colode so 
                    collisions += 2;
                    st.pop();
                    // After collision, both become stationary
                    while (!st.isEmpty() && st.peek() == 'R') {
                        collisions++;
                        st.pop();
                    }
                    st.push('S');
                }
                else if(!st.isEmpty() && st.peek() == 'S'){
                    collisions += 1;
                    st.push('S');
                }
            }
            else if(curr == 'S'){
                while(!st.isEmpty() && st.peek() == 'R'){
                    st.pop();
                    collisions++;
                }
                st.push('S');
            }
        }

        return collisions;
    }
}

