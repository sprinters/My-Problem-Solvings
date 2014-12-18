package main.geeksforgeek.dp.palindromepartitioning;

public class Main {
    public static void main(String...s ) {
        String input1   =   "ababab" ;
        String input2   =   "ababbbabbababa";
        PartitionHelper helper= new DpTester(input2);
        System.out.println(helper.abstractSolver());
    }
}
