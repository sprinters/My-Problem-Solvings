package main.hackerrank.smallhacks.july14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusStation {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int groupCount  =   in.readInt();
        int[] array     =   IOUtils.readIntArray(in,groupCount);
        long sum        = ArrayUtils.sumArray(array);

        List<Long> divisors    =   MyIntegerUtils.getDivisors(sum);

        List<Long> answer       =   new ArrayList<Long>();
        for(Long div : divisors) {

            if(isPossible(array,div)) {
               answer.add(div);
            }


        }

        Collections.sort(answer);

        IOUtils.printSingleArray(answer.toArray());


    }


    public boolean isPossible(int[] array,long block) {

        long can =   0;

        for(int i   =   0;i < array.length ; i++) {


            can =   can + array[i];

            if(can > block) {
                return false;
            }

            if(can ==   block) {
                can =   0;
            }

        }

        return can  ==  0;


    }
}
