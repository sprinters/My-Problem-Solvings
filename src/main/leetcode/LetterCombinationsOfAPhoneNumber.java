package main.leetcode;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character,String> dict =   new HashMap<Character,String>() {{
            put('0',"");
            put('1',"1");
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");

    }};


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        List<String> outputs    =   new ArrayList<String>();
        char[] inputs   =   in.readString().toCharArray();
        dfs(inputs,outputs);
        out.printLine(outputs);


    }

    private void dfs(char[] inputs, List<String> outputs) {

        dfs(inputs, outputs,"",0);
    }

    private void dfs(char[] inputs, List<String> outputs, String output, int start) {
        if(inputs   ==  null || start < 0) {
            outputs.add("");
            return;
        }

        if(start    >=  inputs.length) {
            //add current output to outputList
            outputs.add(output);
            return;
        }

        char dummy  =   inputs[start];
        String letters  =   dict.get(dummy);

        for(int i   =   0;i < letters.length() ; i++) {
            // do dfs for the second level
            dfs(inputs,outputs,output+""+letters.charAt(i),start+1);
        }

    }
}
