package main.leetcode;

import java.util.Stack;

public class TrapingRainWater {
    public static void main(String...s) {
        TrapingRainWater runner =   new TrapingRainWater();
        int[] array =   {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(runner.solve(array));

    }

    private int solve(int[] array) {
        return trapWater(array);
    }

    public int trapWater(int[] array) {

        int answer				=	0;
        Stack<Integer> helper	=	new Stack<Integer>();
        Stack<Integer> indexer	=	new Stack<Integer>();

        int start				=	0;
        // get first +ve entry

        for(int i	=	0;i < array.length ; i++) {
            if(array[i] > 0) {
                start	=	i;
                break;
            }
        }

        helper.push(array[start]);
        indexer.push(start);


        for(int j	=	start+1;j < array.length ; j++) {

            if(helper.isEmpty() || helper.peek() > array[j]) {
                helper.push(array[j]);
                indexer.push(j);
                continue;
            }


            while(!(helper.isEmpty()) && (array[j] >= helper.peek())) {
                if(helper.size() == 1) {
                    helper.pop();
                    indexer.pop();
                    break;
                }


                int mid	=	helper.pop();

                int left	=	helper.peek();
                int right	=	array[j];

                int midStart	=	indexer.pop();
                int windowStart	=	indexer.peek();
                int windowEnd	=	j;



                int minLen		=	windowEnd-windowStart-1;
                int minHeight	=	Math.min(left, right)-mid;


                //	out.printLine("Area info is::"+"("+minLen+","+minHeight+")");

                int tmpResult	=	minLen * minHeight;

                answer += tmpResult;

                // ensure topElement of the stack and current array element should not be same.


                if(helper.peek() == array[j]) {
                    helper.pop();
                    indexer.pop();
                }
            }

            helper.push(array[j]);
            indexer.push(j);
        }

        return answer;

    }

}
