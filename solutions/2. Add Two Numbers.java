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
