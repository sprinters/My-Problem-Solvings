package main.crackingcodinginterviews.bitmanipulation;

/**
 * * @author sandeepandey
 */
public class TaskA {

    //--------------------------------------------------------------------

    /**
     *
     * @param s
     */
    public static void main(String...s) {
        TaskA taskA =   new TaskA();
        int N   =   1 << 10;
        int M   =   21;

        int pos1 =  2;
        int pos2 =  6;
        taskA.doSolve(N,M,pos1,pos2);
    }

    //----------------------------------------------------------------------

    /**
     *
     * @param N
     * @param M
     * @param pos1
     * @param pos2
     */
    private void doSolve(int N, int M, int pos1, int pos2) {

        /**
         * Here is my thought to solve this problem.
         * We will first clear all bits of N between i and j.
         * for that we need to define cleaver mask. lets do that.
         */


        int max = ~0;

        int left    =   max - ( (1 << pos2) -1 ) ;
        int right   =   (1 << pos1) -1 ;

        int mask    =   left | right;
        int result  =   (N & mask) | (M << pos1);
        System.out.println("Collected Result is:"+result);
    }


}
