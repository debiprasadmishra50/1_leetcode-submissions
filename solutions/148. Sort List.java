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
    public ListNode sortList(ListNode head) {
//         if(head==null || head.next==null)
//             return head;
        
//         ListNode slow=head;
//         ListNode fast=head.next;
        
//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
//         }
        
//         ListNode temp=slow.next;
//         slow.next=null;
        
//         ListNode l1 = sortList(head);
//         ListNode l2 = sortList(temp);
        
//         return merge2SortedLists(l1,l2);
        
        if (head == null || head.next == null) {
            return head;
        }
​
        var left = new ListNode(Integer.MIN_VALUE);
        var right = new ListNode(Integer.MIN_VALUE);
​
        var l = left;
        var r = right;
​
        var pivot = head.val;
        var node = head.next;
        head.next = null;
​
        var leftSorted = true;
        var rightSorted = true;
​
        while (node != null) {
            var n = node;
            node = node.next;
            n.next = null;
​
            if (n.val < pivot) {
                if (leftSorted && l.val > n.val) {
