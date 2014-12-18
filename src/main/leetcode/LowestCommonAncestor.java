package main.leetcode;

import main.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LowestCommonAncestor {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.


        ListNode advance =   null;
        ListNode current =   head;
        ListNode previous    =   null;

        int count    =   0;

        if(isThereKMoreNode(head,k)) {

            while(current != null && count < k) {
                advance  =   current.next;
                current.next =   previous;

                previous =   current;
                current  =   advance;
                count++;
            }

            if(advance != null) {
                head.next    =   reverseKGroup(advance,k);
            }
            return previous;

        } else {
            return head;
        }


    }

    public boolean isThereKMoreNode(ListNode start,int windowSize) {

        int count   =   0;
        while(start != null && count < windowSize) {
            start   =   start.next;
            count++;
        }

        return count>=windowSize;
    }


}