package main.geeksforgeek.linklist.singlelinklist.reverse;

import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;
import main.geeksforgeek.linklist.singlelinklist.reverse.Reverse;
import main.geeksforgeek.linklist.singlelinklist.reverse.SolveWithRecursiveWay;

public class Main {

    public static void main(String...s) {

        SingleLinkList p1 =   new SingleLinkList(100);
        SingleLinkList p2 =   new SingleLinkList(200);
        SingleLinkList p3 =   new SingleLinkList(300);
        SingleLinkList p4 =   new SingleLinkList(400);
        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
//        ReverseHelper   helper1 =   new IterativeTester();
//        System.out.println(helper1.performOperation(p1));

        ReverseHelper helper    =   new RecursiveTester();
        System.out.println(helper.performOperation(p1));


    }
}
