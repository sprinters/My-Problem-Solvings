package main.hackerrank.practice.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class Canadies {

    private static final int INCREASING =   0;
    private static final int DECREASING =   1;
    private static final int EQUAL      =   2;


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);

        int[] distribution  =   new int[elementCount];
        int state   =   EQUAL;
        distribution[0] =   1;
        int j;
        for(j   =   1; j < elementCount ; j++) {
           if(array[j] >  array[j-1]) {

                if(state == DECREASING) {
                    updateLeft(array,distribution,j-1);
                }
                state   =   INCREASING;
                distribution[j] =   distribution[j-1] + 1;
            } else if(array[j] < array[j-1]) {
                state   =   DECREASING;
                distribution[j] =   distribution[j-1]-1;
            }  else {
                if(state    ==  DECREASING)
                    updateLeft(array,distribution,j-1);
                state   =   EQUAL;
                distribution[j] =   1;
            }
        }

        if(state == DECREASING) {
            updateLeft(array,distribution,elementCount-1);
        }

        int result  =   0;

        for(int i : distribution) {
            result+=i;
        }

        out.printLine(result);
    }

    private void updateLeft(int[] array, int[] distribution, int posToUpdate) {

        int toSubtract  =   distribution[posToUpdate]-1;

        int index   =   posToUpdate;
        while(index > 0 && array[index] < array[index-1]) {
            distribution[index] -= toSubtract;
            index--;
        }
        if(index  ==  0) {
            distribution[index]-=toSubtract;
        }  else {

            distribution[index]   =   Math.max(distribution[index],distribution[index + 1] + 1);
        }
    }
}
