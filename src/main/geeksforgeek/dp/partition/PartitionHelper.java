package main.geeksforgeek.dp.partition;

public abstract class PartitionHelper {

    public PartitionSolver solver   =   null;

    public void setSolver(PartitionSolver solver) {
        this.solver =   solver;
    }

    public PartitionSolver getSolver() {
        return solver;
    }

    public boolean performOperation(int...array) {
        return getSolver().isPartionable(array);
    }

    public abstract boolean abstractSolver();

}
