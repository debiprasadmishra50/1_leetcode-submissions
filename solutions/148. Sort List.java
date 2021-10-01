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
    public ListNode sortList(ListNode head) {
//         if(head==null || head.next==null)
//             return head;
        
//         ListNode slow=head;
//         ListNode fast=head.next;
        
//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
//         }
        
//         ListNode temp=slow.next;
//         slow.next=null;
        
//         ListNode l1 = sortList(head);
//         ListNode l2 = sortList(temp);
        
//         return merge2SortedLists(l1,l2);
        
        if (head == null || head.next == null) {
            return head;
        }

        var left = new ListNode(Integer.MIN_VALUE);
        var right = new ListNode(Integer.MIN_VALUE);

        var l = left;
        var r = right;

        var pivot = head.val;
        var node = head.next;
        head.next = null;

        var leftSorted = true;
        var rightSorted = true;

        while (node != null) {
            var n = node;
            node = node.next;
            n.next = null;

            if (n.val < pivot) {
                if (leftSorted && l.val > n.val) {
                    leftSorted = false;
                }
                l.next = n;
                l = l.next;
            } else {
                if (rightSorted && r.val > n.val) {
                    rightSorted = false;
                }
                r.next = n;
                r = r.next;
            }
        }

        left = left.next;
        right = right.next;

        if (!leftSorted) {
            left = sortList(left);
        }

        if (!rightSorted) {
            right = sortList(right);
        }

        if (left != null) {
            var end = left;
            while (end.next != null) {
                end = end.next;
            }
            end.next = head;
            head.next = right;
            return left;
        } else {
            head.next = right;
            return head;
        }
    }
    
    public ListNode merge2SortedLists(ListNode l1, ListNode l2){
        
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next=l1;
                dummy=dummy.next;
                l1=l1.next;
            }
            else{
                dummy.next=l2;
                dummy=dummy.next;
                l2=l2.next;
            }
        }
        
        if(l1==null){
            dummy.next=l2;
        }else{
            dummy.next=l1;
        }
        
        return head.next;
    }
}
