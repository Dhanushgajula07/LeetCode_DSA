/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// class Solution {
//     public Node copyRandomList(Node head) {
//         // 1. we will solve it using the simple and intutive hashmap approach
//         // we create a hashmpa and link randomes and next and retur head copy
//         HashMap<Node, Node> map = new HashMap<>();
//         Node curr = head;

//         while(curr != null){
//             Node temp = new Node(curr.val);
//             map.put(curr,temp);
//             curr = curr.next;
//         }

//         curr = head;

//         while(curr != null){
//             Node temp = map.get(curr);

//             temp.next = map.get(curr.next);
//             temp.random = map.get(curr.random);
//             curr = curr.next;
//         }

//         return map.get(head);
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        // now lets solve it using just o(1) time 
        // so we will use the reviring approach
        // by insertng node and link randomes and then link next

        Node curr = head;

        while(curr != null){
            // create a copy 
            Node copy = new Node(curr.val);

            // now lets link
            Node fut = curr.next;
            curr.next = copy;
            copy.next = fut;

            curr = fut;
        } 

        // now lets link randomes
        curr = head;
        while(curr != null){
            Node fut = curr.next;
            if(curr.random != null)
            fut.random = curr.random.next;
            else
            fut.random = null;
            curr = curr.next.next;
        }

        curr = head;
         Node dummyNode = new Node(-1);
    // Initialize a result pointer
    Node res = dummyNode;
        while(curr != null){
            
            res.next = curr.next;
            res = res.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummyNode.next;
    }
}