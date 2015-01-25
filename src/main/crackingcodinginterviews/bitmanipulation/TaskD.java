package main.crackingcodinginterviews.bitmanipulation;

/**
 * * @author sandeepandey
 */
public class TaskD {

    public static void main(String...s) {

        TaskD taskD =   new TaskD();
        System.out.println(taskD.solve(1234,3459));
    }

    private int solve(int first, int second) {

        if(second   ==  0) {
            return first;
        }

        int sum =   first ^ second;
        int carry = (first & second) << 1;
        return solve(sum,carry);

    }
}
