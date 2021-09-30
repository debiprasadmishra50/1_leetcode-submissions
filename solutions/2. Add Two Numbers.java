/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), head = res;
        
        int rem = 0;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null)
                a = l1.val;
            if (l2 != null)
                b = l2.val;
            
            int sum = a + b + rem;
            
            res.val = sum % 10;
            rem = sum / 10;
            
            if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
                res.next = new ListNode(0);
                res = res.next;
            }
            
            if (l1 != null)
                l1 = l1.next;
            
            if (l2 != null)
                l2 = l2.next;
            
        }
        
        if (rem > 0) {
            res.next = new ListNode(rem);
        }
​
        return head;
    }    
}
