package main.leetcode;

/**
 * * @author sandeepandey
 */
public class AddTwoNumber {


    private static ListNode resultNode = new ListNode(-1);
    public static void main(String...s) {

        AddTwoNumber addTwoNumber   =   new AddTwoNumber();
        ListNode first  =   new ListNode(9);
        first.next = new ListNode(9);
        first.next.next =   new ListNode(9);

        ListNode second =        new ListNode(9);
        second.next = new ListNode(9);
        second.next.next = new ListNode(9);

        addTwoNumber.addTwoNumbers(first,second);

        resultNode  =   resultNode.next;
        while(resultNode != null) {
            System.out.println(resultNode.val+" ");
            resultNode = resultNode.next;
        }

    }

    public void addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head       =   resultNode;
        addTwoNumbers(l1, l2, l1, l2, head, 0);
    }

    private void addTwoNumbers(ListNode first, ListNode second, ListNode firstAt,
                                   ListNode secondAt, ListNode resultList,int carry) {

        //handle base case
        // if firstAt is null and secondAt is null and there is no carry

        if(firstAt  ==  null && secondAt == null && carry == 0) {
            return ;
        }

        int fromFirst   =   getNullSafeValue(firstAt);
        int fromSecond  =   getNullSafeValue(secondAt);

        int toAddInResultList   =   (fromFirst + fromSecond + carry)%10;
        int toMove              =   (fromFirst + fromSecond + carry)/10;
        ListNode listNode       =   new ListNode(toAddInResultList);
        resultList.next         =   listNode;
        addTwoNumbers(first,second,firstAt == null ? null :firstAt.next,secondAt == null ? null:secondAt.next,
                resultList.next,toMove);

    }

    public int getNullSafeValue(ListNode list) {
        return list == null ? 0 : list.val;
    }
}


