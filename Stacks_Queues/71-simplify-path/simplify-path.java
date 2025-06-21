class Solution {
    public String simplifyPath(String path) {
        // asked by Amazon Bro
        Stack<String> st = new Stack<>();
        String[] arr = path.split("/");
        StringBuilder sb = new StringBuilder();

        for(String s : arr){
            if(s.equals(".") || s.equals("")){
            continue;
        }
        else if(s.equals("..")){
            if(!st.isEmpty()) st.pop();
        }
        else{
            st.push(s);
        }
        }

        
    // we just iterate the stack
    for (String dir : st) {
    sb.append('/').append(dir);
}

   //  sb.reverse();
    if(sb.length() == 0) return "/";
    return sb.toString();
    }
}