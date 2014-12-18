package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class RotateByRight {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        ListNode head   =   null;
        int     k       =   0;
        out.printLine(rotateRight(head,k));


    }

    public ListNode rotateRight(ListNode head, int k) {


        // add some base test case here

        if(head ==   null || k <=0)  return  head;

        int nodeCount      =    count(head);

        k                   =  nodeCount % k;

        if(k<=0) {
            return head;
        }

        ListNode advance    =   head;
        ListNode current    =   head;
        ListNode previous   =   null;

        //

        for(int i   =1 ; i < k ; i++) {
            advance =   advance.next;
        }

        while(advance.next != null) {
            advance =   advance.next;
            previous    =   current;
            current =   current.next;
        }


        previous.next   =   null;
        advance.next    =   head;

        head    =   current;

        return head;

    }

    public int count(ListNode start) {
        int count   =   0;
        while(start != null) {
             start  =   start.next;
            count++;
        }

        return count;
    }
}
