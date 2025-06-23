// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         // next kth elemnt size
//         int k = 2;
//         // create temp
//         ListNode temp = head;
//         ListNode prev = null;
//         while(temp != null){

//             // get kTh element
//             ListNode kTHNode = count(temp,k);

//             // check if valid 
//             if(kTHNode == null){
//                 // if last
//                 if(prev != null){
//                     prev.next = temp;
//                 }
//                 // if 1st becuse we are not making new node we are just making use of curr list
//                     break;
//             }

//             // valid k
//             // now remoove kthnext but save 
//             ListNode next_start = kTHNode.next;
//             kTHNode.next = null;



//             // now its seperatedd  we can reverse
//             ListNode  reversed_head = reverse(temp);

//             // now what if iam at 1st set

//             if(temp == head){
//                 head = reversed_head;
//                 // no prev so no probelm 
//                 // ii should connect the 
//                 // back and shift temp and copy back of present set as prev
//             }else{
//                 prev.next = reversed_head;
//             }
//             prev = temp;
//             temp = next_start;
//         }

//         return head;
//     }
//     // Reverses a linked list and returns the new head
//     private static ListNode reverse(ListNode head) {
//         ListNode prev = null;
//         ListNode curr = head;

//         while (curr != null) {
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         return prev; // New head of the reversed list
//     }

//     // Returns the kth node from the current head if it exists; otherwise, returns null
//     private static ListNode count(ListNode head, int k) {
//         k--; // We're already at position 1 (head), so move k-1 steps ahead

//         while (head != null && k > 0) {
//             head = head.next;
//             k--;
//         }

//         return head; // If we successfully reached the kth node, return it; else, null
//     }
// }


class Solution {
    public ListNode swapPairs(ListNode head) {
        // base case: no pair to swap
        // best part is that thinking recusrively will solve the work
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        // Recursively call for the remaining list after the first two
        ListNode remaining = swapPairs(second.next);

        // Reverse current pair
        second.next = first;
        first.next = remaining;

        return second; // new head of this swapped pair
    }
}
