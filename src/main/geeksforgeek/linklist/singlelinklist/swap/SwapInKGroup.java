package main.geeksforgeek.linklist.singlelinklist.swap;

import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;

public class SwapInKGroup implements SwapInGeneralWay {

    @Override
    public SingleLinkList swapWithGeneralWay(SingleLinkList singleLinkList, int windowSize) {

        SingleLinkList start    =   singleLinkList;
        SingleLinkList prev     =   null;
        SingleLinkList first    =   start;
        SingleLinkList second   =   null;
        int count               =   0;
        if(isThereKNodeMore(first,windowSize)) {

            while(first != null && count < windowSize) {
                second  =   first.getNext();
                first.setNext(prev);
                prev    =   first;
                first   =   second;
                count++;
            }
            if(second != null) {
                start.setNext(swapWithGeneralWay(second,windowSize));
            }
            return prev;
        } else {
             return start;
        }







    }

    public boolean isThereKNodeMore(SingleLinkList head,int windowSize) {

        SingleLinkList current  =   head;
        int sizeRequired    =   windowSize;
        int count           =   0;

        while(current != null && count < windowSize) {
            count++;
            current =   current.getNext();
        }
        return count>=windowSize;

    }
}
