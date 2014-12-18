package main.leetcode;

import java.util.LinkedList;
import java.util.Stack;


public class    ValidParenthesis {

    public static void main(String...s) {

        System.out.println();

    }


    public boolean isValid(String s) {

        Stack<Character> stack= new Stack<Character>();
        char[] array    =   s.toCharArray();


        for(int i   =   0;i < array.length ; i++) {

            char inputChar  =   array[i];

            if(inputChar    ==  '(' || inputChar    ==  '{' || inputChar    ==  '[') {
                stack.push(inputChar);
            } else {
                char matchingChar   =   stack.pop();
                if(inputChar ==  ')') {
                    if(matchingChar !=  '(') {
                        return false;
                    }
                }
                else if(inputChar ==  '}') {
                    if(matchingChar !=  '{') {
                        return false;
                    }
                } else if(inputChar ==  ']'){
                    if(matchingChar !=  '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}


