package main.codechef.monthly.FEB14;


import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;


public class LittleElephantAndSubarray {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        int arrayCount  =   in.readInt();
        int[] entries   = IOUtils.readIntArray(in, arrayCount);

        // do some processing

//        LongIntervalTree tree   =   new MinIntervalTree(entries);
//        tree.init();
//
//
//        int queryCount  =   in.readInt();
//        int answer      =   0;
//        for(int i   =   0;i < queryCount ; i++) {
//            answer  =   0;
//            int fromCheck  =   in.readInt();
//            // generate all continious segment and lets see thier min value.
//            for(int j   =   0;j < arrayCount ; j++) {
//
//                for(int k   =   j ; k < arrayCount ; k++) {
//
//                    int toCheck =   tree.query(j,k);
//
//                  //  out.printLine("Min Value is::"+toCheck);
//
//                    if(toCheck  ==  fromCheck) {
//                        answer++;
//
//                    }
//                }
//            }
//            out.printLine(answer);
//        }
//    }
    }
}
