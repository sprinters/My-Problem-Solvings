package main.geeksforgeek.dp.partition;

public class DpTester extends PartitionHelper {
    private int[] array =   null;

    public DpTester(int[] array) {
        this.array=array;
    }
    @Override
    public boolean abstractSolver() {
        PartitionSolver solver =   new SolveWithDp();
        setSolver(solver);
        return performOperation(array);
    }
}
