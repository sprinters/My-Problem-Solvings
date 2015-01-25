package main.crackingcodinginterviews.linkedlist;

import main.leetcode.ListNode;

/**
 * * @author sandeepandey
 */
public class ReverseLinkedList {

    public static void main(String...s) {
        ReverseLinkedList reverseLinkedList =   new ReverseLinkedList();
        reverseLinkedList.doSolve(null);
    }

    private void doSolve(ListNode head) {
        ListNode reverseList    =   reverseUsingRecursion(head);


    }

    private ListNode reverseUsingRecursion(ListNode head) {

        if(head ==  null) {
            return null;
        }

        ListNode remainingList  =   reverseUsingRecursion(head.next);

        ListNode current    =   remainingList;
        while(current.next != null) {
            current =   current.next;
        }
        current.next    =   head;
        head.next   =   null;
        return current;


    }
}
