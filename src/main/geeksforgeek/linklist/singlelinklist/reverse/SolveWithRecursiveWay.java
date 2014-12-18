package main.geeksforgeek.linklist.singlelinklist.reverse;


import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;

public class SolveWithRecursiveWay implements Reverse {

    @Override
    public SingleLinkList reverse(SingleLinkList head) {

        if(head ==  null || head.getNext() == null) {
            return head;
        }

        SingleLinkList remainingList    =   reverse(head.getNext());

        //find tail of this reverse list
        SingleLinkList  current         =   remainingList;
        while(current.getNext() != null) {
            current =   current.getNext();
        }

        current.setNext(head);
        head.setNext(null);
        return remainingList;
    }
}
