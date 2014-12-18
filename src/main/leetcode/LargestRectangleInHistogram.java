package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);

        if(elementCount ==  1) {
            out.printLine(array[0]);
            return;
        }
        out.printLine(largestRectangleArea(array,out));

    }

    public long largestRectangleArea(int[] height,OutputWriter out) {

            if ( height==null||height.length==0){
                return 0;
            }
            Stack<Integer> stack=new Stack<Integer>();
            int max=0;
            int i=0;
            while(i<height.length){
                if (stack.isEmpty()||height[i]>=height[stack.peek()]){
                    stack.push(i);
                    i++;
                }
                else{
                    int h=height[stack.pop()];
                    int wid=stack.isEmpty()?i:i-stack.peek()-1;
                    max=Math.max(h*wid, max);
                }
            }
            while (!stack.isEmpty()){
                int h=height[stack.pop()];
                int wid=stack.isEmpty()?i:i-stack.peek()-1;
                max=Math.max(h*wid, max);
            }
            return max;
    }
}
