package main.crackingcodinginterviews.bitmanipulation;

/**
 * * @author sandeepandey
 */
public class TaskC {
    public static void main(String...s) {

        TaskC taskC =   new TaskC();
        int result  =   taskC.bitSwapRequired(31,14);
        System.out.println("Result found is:"+result);
    }



    public int bitSwapRequired(int first,int second) {

        int resultCount =   0;
        for(int resultXOR = first ^ second ; resultXOR != 0 ; resultXOR = resultXOR >> 1) {
            resultCount =   resultXOR & 1;
        }
        return resultCount;

    }
}
