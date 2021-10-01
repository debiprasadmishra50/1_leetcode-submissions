        
//      ListNode slow = head, fast = head;
//      while (fast.next != null && fast.next.next != null) {
//          slow = slow.next;
//          fast = fast.next.next;
//      }
        
//      ListNode rev = reverseList(slow.next);
    
//      ListNode cur = head;
//      while (rev != null) {
//          if (rev.val != cur.val)
//              return false;
//          rev = rev.next;
//          cur = cur.next;
//      }
//      return true;
        
        ListNode curr = head;
        ListNode prev = head;
        ListNode next = head;
        ListNode fast = head;
        while(fast != null && fast.next!=null){
            fast=fast.next.next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(fast!=null){
            curr=curr.next;
        }
        while(curr!=null){
            if(curr.val!=prev.val){
                return false;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return true;
    }
    
    private static ListNode reverseList(ListNode node) {
        ListNode prev = null, next = null, cur = node;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
