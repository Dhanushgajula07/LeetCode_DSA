class Solution {
    public int minAddToMakeValid(String s) {
     int balanced = 0;
     int moves = 0;

     for(char c: s.toCharArray()){
        if(c == '('){
            balanced++;
        }
        else if(c == ')'){
            balanced--;
            if(balanced <0){
                moves++;
                balanced =0;
            }
        }
     }
        return moves + balanced;
     }   
}