//                     //search starting from the head
//                     ListNode ptr = head;
//                     while(ptr.next!=null && ptr.next.val < curr.val)
//                         ptr = ptr.next;
//                     ListNode temp = ptr.next;
//                     ptr.next = curr;
//                     curr.next = temp;
//                 }
//                 curr = prev.next;
//             } else {
//                 curr = curr.next;
//                 prev = prev.next;
//             }
//         }
//        return head;
        
        
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
