package main.geeksforgeek.linklist.singlelinklist.swap;

import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;

public class Main {

    public static void main(String[] args) {

        SingleLinkList p1 =   new SingleLinkList(100);
        SingleLinkList p2 =   new SingleLinkList(200);
        SingleLinkList p3 =   new SingleLinkList(300);
        SingleLinkList p4 =   new SingleLinkList(400);
        SingleLinkList p5 =   new SingleLinkList(500);

        SingleLinkList p6 =   new SingleLinkList(600);

        SingleLinkList p7 =   new SingleLinkList(700);

        SingleLinkList p8 =   new SingleLinkList(800);

        SingleLinkList p9 =   new SingleLinkList(900);
        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p5);
        p5.setNext(p6);
        p6.setNext(p7);
        p7.setNext(p8);
        p8.setNext(p9);
        p9.setNext(null);

        SwapInGeneralWay letsSwaps  =   new SwapInKGroup();
        System.out.println(letsSwaps.swapWithGeneralWay(p1,3));
    }
}
