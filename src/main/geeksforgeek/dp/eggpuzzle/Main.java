package main.geeksforgeek.dp.eggpuzzle;


public class Main {

    public static void main(String...s) {
        EggPuzzleHelper helper= new MemoTester();
        int minTrials   =   helper.abstractSolver(2,10);
        System.out.println("min trials::"+minTrials);

    }
}
