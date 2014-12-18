package main.geeksforgeek.dp;

import java.util.HashMap;
import java.util.Map;


public class AllInterpretationOfDigits {

    private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "v", "z"};
    public static void printAllInterpretation(Map<String,String> inputValue,String output,String inputArray) {
        //System.out.println(output);
        if(inputArray   ==  null || inputArray.length() ==  0) {
            System.out.println(output);
            return;
        }

        if(inputArray.length()>=1) {
            printAllInterpretation(inputValue, output + inputValue.get(inputArray.charAt(0) + ""), inputArray.substring(1));
        }

        if(inputArray.length()>=2) {
            printAllInterpretation(inputValue, output + inputValue.get(findIndex(inputArray)), inputArray.substring(2));
        }
    }

    private static String findIndex(String inputArray) {

        if(inputArray   ==  null || inputArray.length() ==  0) {
            return 0+"";
        }

        int first  =   inputArray.charAt(0)-'0';
        int second =   inputArray.charAt(1)-'0';

        int third   =   first*10 + second;
        if(third > 26) {
            return 0+"";
        }
        return third+"";



    }


    public static void main(String...s) {

        Map<String,String> map  =   new HashMap<String,String>();
        for(int i   =   0;i < alphabet.length ; i++) {
            map.put(String.valueOf(i),alphabet[i]+"");
        }

        String output   =   "";
        String inputArray   =   "1221";
        printAllInterpretation(map,output,inputArray);

    }

}
