package main.codechef.monthly.NOV14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.string.StringUtils;

public class LetUsConstructPalindrome {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String input    =   in.readString();
        if(input.length()   ==  1 || input.length() ==  2) {
            out.printLine("YES");
            return;
        }

        int start   =   0;
        int end     =   input.length()-1;

        while(start < end) {
            if(input.charAt(start)  ==  input.charAt(end)) {
                start++;
                end--;
                continue;
            }


            boolean x   =   StringUtils.isPalindrome(input.substring(start,end));
            boolean y   =   StringUtils.isPalindrome(input.substring(start+1,end+1));

            if(!x && !y)  {
                out.printLine("NO");
                return;
            }

            if(x || y) {
                out.printLine("YES");
                return;
            }
            start++;
            end--;
        }


        out.printLine("YES");

    }
}
