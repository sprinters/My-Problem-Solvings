package main.geeksforgeek.dp.longestpalindromicsubsequence;


public class Main {

    public static void main(String...s) {
        LpsHelper bruteHelper    =   new BruteTester();
        LpsHelper memoHelper     =   new MemoTester();
        int maxLen  =   memoHelper.abstractSolver("");
        System.out.println(maxLen);
    }
}
