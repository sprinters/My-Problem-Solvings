package main.hackerearth.target;

import main.api.my.intervaltree.ArrayBasedIntervalTree;
import main.api.my.intervaltree.MultipicationBasedIntervalTree;
import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class AToB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] elementAt    = IOUtils.readIntArray(in, elementCount);

        int[] copy          = Arrays.copyOf(elementAt,elementCount);

        ArrayBasedIntervalTree intervalTree =   new MultipicationBasedIntervalTree(elementAt);



        int qty =   in.readInt();

        for(int i   =   0;i < qty ; i++) {

            int operationType   =   in.readInt();

            if(operationType    ==  1) {

                int at  =   in.readInt()-1;
                out.printLine(intervalTree.query(0,elementCount)/copy[at]);


            }   else {

                int at  =   in.readInt() -1 ;
                int withValue   =   in.readInt();

                intervalTree.update(at,at,withValue);

                out.printLine(intervalTree.query(0,elementCount)/copy[at]);


            }

        }
    }


}
