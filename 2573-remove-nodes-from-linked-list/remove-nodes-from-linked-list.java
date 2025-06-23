/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        // my 1st thought was to implemet monoyonic satck and remove if st.ppek() <= curr
        // but then i should convert to linked list 

        if(head == null) return null;
        // lets try 
        Stack<Integer> st = new Stack<>();
        while(head != null){
            int val = head.val;
            while(!st.isEmpty() && st.peek() < val){
                st.pop();
            }
            st.push(val);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        for(Integer it : st){
            ListNode curr = new ListNode(it);
            node.next = curr;
            node = node.next;
        }
        return dummy.next;

        // tc = O(n) + O(n)
        // sc = O(n) + O(n) dummy node
    }
}