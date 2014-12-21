package main.hackerearth.druva;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Stack;

public class TaskA {

    private static final int MOD    =   1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[] array         = IOUtils.readLongArray(in, elementCount);
        out.printLine(accumulateWater(array));

    }
    public long accumulateWater(long[] A) {
        long[] array =   A;
        long answer				=	0;
        Stack<Long> helper	=	new Stack<Long>();
        Stack<Long> indexer	=	new Stack<Long>();


        if(array    ==  null) {
            return 0;
        }

        if(array.length == 1) {
            return 0;
        }
        int start				=	0;
        // get first +ve entry

        for(int i	=	0;i < array.length ; i++) {
            if(array[i] > 0) {
                start	=	i;
                break;
            }
        }
        if(start >= array.length) {
            return 0;
        }
        helper.push(array[start]);
        indexer.push(Long.valueOf(start));


        for(int j	=	start+1;j < array.length ; j++) {

            if(helper.isEmpty() || helper.peek() > array[j]) {
                helper.push(array[j]);
                indexer.push(Long.valueOf(j));
                continue;
            }


            while(!(helper.isEmpty()) && (array[j] >= helper.peek())) {




                if(helper.size() == 1) {
                    helper.pop();
                    indexer.pop();
                    break;
                }


                long mid	=	helper.pop();

                long left	=	helper.peek();
                long right	=	array[j];

                long midStart	=	indexer.pop();
                long windowStart	=	indexer.peek();
                long windowEnd	=	j;



                long minLen		=	windowEnd-windowStart-1;
                long minHeight	=	Math.min(left, right)-mid;


                //	out.printLine("Area info is::"+"("+minLen+","+minHeight+")");

                long tmpResult	=	(minLen * minHeight) % MOD;

                answer = (answer +  tmpResult) % MOD;

                // ensure topElement of the stack and current array element should not be same.


                if(helper.peek() == array[j]) {
                    helper.pop();
                    indexer.pop();
                }
            }

            helper.push(array[j]);
            indexer.push(Long.valueOf(j));
        }

        return answer;
    }
}
