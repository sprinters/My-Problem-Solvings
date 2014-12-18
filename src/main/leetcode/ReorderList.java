package main.leetcode;


public class ReorderList {
    public static void main(String...s) {



    }

    public void solve(ListNode head) {
         reorderList(head);
    }

    /**
     * How this algorithm proceed ?
     *
     * lets break the whole list into two part.
     * >> head... mid and mid+1...last
     * >> reverse the first part..
     * >> mid...head and mid+1...end
     *
     * >> now start merging mid to mid+1
     *  mid+1 to mid+2
     *
     *  In this way we can achieve the following algorithm
     * @param head
     */
    public void reorderList(ListNode head) {

    }

}
