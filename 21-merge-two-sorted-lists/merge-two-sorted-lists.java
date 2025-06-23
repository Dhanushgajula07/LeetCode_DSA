// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//     // dummmy node
//     ListNode dummy = new ListNode(-1);
//     ListNode pointer = dummy;

//     while(l1 != null && l2 != null){
//         if(l1.val <= l2.val){
//             pointer.next = l1;
//             pointer = l1;
//             l1 = l1.next;
//         }
//         else if(l2.val < l1.val){
//             pointer.next = l2;
//             pointer = l2;
//             l2 = l2.next;
//         }
//     }
//     if(l1 != null){
//         pointer.next =l1;
//     }
//     if(l2 != null){
//         pointer.next = l2;
//     }
//     return dummy.next;
//     }
// }

class Solution {
   
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
           ListNode dummy = new ListNode(-1);
         ListNode node = dummy;
    // any code you are dealing with while(node != null) can be solved using recursion
        helper(l1,l2,node);
        return dummy.next;    
    }
    private void helper(ListNode l1, ListNode l2,ListNode node){
        // base
        if(l1 == null && l2 == null) return;
        if(l1 == null){
            node.next = l2;
            return;
        }
        if(l2 == null){
            node.next = l1;
            return;
        }
        if(l1.val <= l2.val){
            node.next = l1;
            l1 = l1.next;
            helper(l1,l2,node.next);
        }        
        else{
            node.next = l2;
            l2 = l2.next;
            helper(l1,l2,node.next);
        }
    }
}