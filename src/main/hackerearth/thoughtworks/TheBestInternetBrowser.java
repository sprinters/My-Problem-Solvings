package main.hackerearth.thoughtworks;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.HashSet;

public class TheBestInternetBrowser {


    private static String prefix    =   "www." ;
    private static String suffix    =   ".com";

    private static HashSet<Character> dict  =   null;

    static  {
        dict    =   new HashSet<Character>();

        dict.add('a');
        dict.add('i');
        dict.add('o');
        dict.add('u');
        dict.add('e');


    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {


        String input    =   in.readString();
        String copy     =   input;
        char[] array    =   input.toCharArray();
        String output   =   "";


        if(input.startsWith(prefix)) {
            //out.printLine("start");
            copy    =   input.substring(4);
        }


        int index   =   copy.indexOf('.');
       // out.printLine(copy);
        for(int i   =   0;i < index ; i++) {
            if(dict.contains(copy.charAt(i))) {
                continue;
            }

            output+=copy.charAt(i);
        }


        if(copy.endsWith(suffix)) {
            output+=suffix;
        }

        out.printLine(output.length()+"/"+input.length());


    }
}
