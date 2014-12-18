package main.geeksforgeek.dp.eggpuzzle;


public abstract class EggPuzzleHelper {
    private EggPuzzleSolver solver  =   null;

    public void setSolver(EggPuzzleSolver solver) {
        this.solver =   solver;
    }

    public EggPuzzleSolver getPuzzleSolver() {
        return solver;
    }

    public int performOperation(int eggCount,int floorCount) {
        return getPuzzleSolver().getMinTrials(eggCount,floorCount);
    }

    public abstract int abstractSolver(int eggCount,int floorCount);
}
