package main.geeksforgeek.dp.eggpuzzle;
public class MemoTester extends EggPuzzleHelper {

    public MemoTester() {

    }

    @Override
    public int abstractSolver(int eggCount,int floorCount) {
        EggPuzzleSolver solver  =   new SolveWithMemorization();
        setSolver(solver);
        return performOperation(eggCount,floorCount);
    }
}
