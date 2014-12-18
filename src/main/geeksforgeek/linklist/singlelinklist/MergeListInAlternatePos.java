package main.geeksforgeek.linklist.singlelinklist;

public class MergeListInAlternatePos {


    public SingleLinkList merge(SingleLinkList first,SingleLinkList second) {

        SingleLinkList  p1  =   null;
        SingleLinkList  p2  =   null;

        SingleLinkList  nextp1  =   null;
        SingleLinkList  nextp2   =   null;


        p1= first;
        p2=second;
        while(p1 != null && p2 != null) {

            //save next pointers
            nextp1  =   p1.getNext();
            nextp2  =   p2.getNext();

            // exchange pointers in place
            p1.setNext(p2);
            p2.setNext(nextp1);

            // update both pointers

            p1= nextp1;
            p2=nextp2;
        }
        // update second pointer of the list here
        return null;
    }
}
