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
    public ListNode insertionSortList(ListNode head) {
//         ListNode prev = head;
//         ListNode curr = prev.next;
        
//         if(head==null || head.next==null) 
//             return head;
        
//         while(curr != null) {
//             if(curr.val < prev.val) {
//                 prev.next = curr.next;
//                 if(curr.val <= head.val) {
//                     curr.next = head;
//                     head = curr;
//                 } else {
//                     //search starting from the head
//                     ListNode ptr = head;
//                     while(ptr.next!=null && ptr.next.val < curr.val)
//                         ptr = ptr.next;
//                     ListNode temp = ptr.next;
//                     ptr.next = curr;
//                     curr.next = temp;
//                 }
//                 curr = prev.next;
//             } else {
//                 curr = curr.next;
//                 prev = prev.next;
//             }
//         }
//        return head;
        
        
        ListNode start = new ListNode();
        start.next = head;
        ListNode curr = head, prev = start;
        while(curr != null){
            if(curr.next != null && (curr.next.val < curr.val)){
                // Insertion 
                while(prev.next != null && (prev.next.val < curr.next.val))
                    prev = prev.next;
                ListNode temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;
                prev = start;
            } else
                curr = curr.next;
        }
        return start.next;
    }
}
