package main.geeksforgeek.linklist.singlelinklist.swap;

import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;


public abstract class AbstractSwapInPairs implements SwapInGeneralWay {
    @Override
    public SingleLinkList swapWithGeneralWay(SingleLinkList singleLinkList, int windowSize) {
        return swapWithPairs(singleLinkList,2);
    }

    protected abstract SingleLinkList swapWithPairs(SingleLinkList singleLinkList, int windowSize);
}
