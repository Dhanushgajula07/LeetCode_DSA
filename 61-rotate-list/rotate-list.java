// class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if (head == null || head.next == null || k == 0) return head;

//         // Step 1: Count length of list
//         int length = getLength(head);
//         k = k % length; // Rotating by length has no effect

//         if (k == 0) return head;

//         // Step 2: Reverse the entire list
//         head = reverse(head);

//         // Step 3: Get kth node (this will become the new tail)
//         ListNode kth_node = getKthNode(head, k);
//         ListNode next_start = kth_node.next;

//         // Step 4: Break the list into two parts
//         kth_node.next = null;

//         // Step 5: Reverse both parts
//         ListNode firstPart = reverse(head);         // First k nodes
//         ListNode secondPart = reverse(next_start);  // Remaining nodes

//         // Step 6: Connect them
//         getTail(firstPart).next = secondPart;

//         return firstPart;
//     }

//     // Helper: Reverse linked list
//     private static ListNode reverse(ListNode head) {
//         ListNode prev = null, curr = head;

//         while (curr != null) {
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         return prev;
//     }

//     // Helper: Get length of list
//     private static int getLength(ListNode head) {
//         int count = 0;
//         while (head != null) {
//             count++;
//             head = head.next;
//         }
//         return count;
//     }

//     // Helper: Get kth node (0-indexed)
//     private static ListNode getKthNode(ListNode head, int k) {
//         while (head != null && k > 1) {
//             head = head.next;
//             k--;
//         }
//         return head;
//     }

//     // Helper: Get tail node
//     private static ListNode getTail(ListNode head) {
//         if (head == null) return null;
//         while (head.next != null) {
//             head = head.next;a
//         }
//         return head;
//     }
// }


// dont actually needd tail taraversel 


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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count length of list
        int length = getLength(head);
        k = k % length;
        if (k == 0) return head;

        // Step 2: Reverse the entire list
        head = reverse(head);

        // Step 3: Get kth node (this will become new tail)
        ListNode kthNode = getKthNode(head, k);
        ListNode nextStart = kthNode.next;
        kthNode.next = null; // Split into two parts

        // Step 4: Reverse both parts
        ListNode firstPart = reverse(head);           // First k nodes
        ListNode tailOfFirstPart = head;              // 'head' is now tail of reversed part
        ListNode secondPart = reverse(nextStart);     // Remaining nodes

        // Step 5: Connect both parts
        tailOfFirstPart.next = secondPart;

        return firstPart;
    }

    private static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode getKthNode(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }
}
