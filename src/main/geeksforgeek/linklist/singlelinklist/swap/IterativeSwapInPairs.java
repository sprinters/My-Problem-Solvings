package main.geeksforgeek.linklist.singlelinklist.swap;

import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;

public class IterativeSwapInPairs extends AbstractSwapInPairs {
    @Override
    protected SingleLinkList swapWithPairs(SingleLinkList singleLinkList, int two) {

        SingleLinkList start    =   singleLinkList;

        if(start    ==  null || start.getNext() == null) {
            return start;
        }

        SingleLinkList first    =   start;
        SingleLinkList second   =   first.getNext();
        first.setNext(second.getNext());
        second.setNext(first);
        SingleLinkList previous =   first;
        first   =   first.getNext();
        start   =   second;

        while(first != null && first.getNext() != null) {

            second  =   first.getNext();
            first.setNext(second.getNext());
            second.setNext(first);
            previous.setNext(second);

            previous    =   first;
            first       =   first.getNext();
        }

        return start;

    }
}
