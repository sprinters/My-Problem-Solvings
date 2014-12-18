package main.leetcode;

public class EnrichedTreeNode {

    public EnrichedTreeNode left   =   null;
    public EnrichedTreeNode right   =   null;
    public boolean isVisited        =   false;
    public int val                  =   0;


    public EnrichedTreeNode(int val,boolean isVisited) {
        this.val    =   val;
        this.isVisited  =   isVisited;
    }
}
