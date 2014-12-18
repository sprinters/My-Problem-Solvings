package main.geeksforgeek.linklist.singlelinklist.reverse;

import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;
import main.geeksforgeek.linklist.singlelinklist.reverse.Reverse;

/**
 * Created with IntelliJ IDEA.
 * User: sandeepandey
 * Date: 27/10/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class SolveWithIterativeWay implements Reverse {
    @Override
    public SingleLinkList reverse(SingleLinkList head) {

        if(head ==  null || head.getNext()  ==  null) {
            return head;
        }

        SingleLinkList prev =   null;
        SingleLinkList mid  =   head;
        SingleLinkList next =   mid.getNext();
        while (next != null) {
            mid.setNext(prev);

            prev    =   mid;
            mid     =   next;
            next    =   mid.getNext();
        }
        mid.setNext(prev);
        head    =   mid;
        return head;

    }
}
