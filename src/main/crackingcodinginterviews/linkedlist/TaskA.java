package main.crackingcodinginterviews.linkedlist;

import main.leetcode.ListNode;

/**
 * * @author sandeepandey
 */
public class TaskA {

    public static void main(String...s) {

        TaskA taskA =   new TaskA();
        taskA.getCorruptedNode(null);

    }

    public ListNode getCorruptedNode(ListNode head) {

        ListNode slow   =   head;
        ListNode fast   =   head;
        while(fast.next != null) {
            slow    =   slow.next;
            fast    =   fast.next.next;
            if(slow ==  fast) {
                break;
            }

        }
        //Error case,check whether is no loop in the linked list.
        if(fast.next == null) {
            return head;
        }

        slow    =   head;
        while(slow != fast) {
            slow    =   slow.next;
            fast    =   fast.next;
        }

        return fast;
    }


}
